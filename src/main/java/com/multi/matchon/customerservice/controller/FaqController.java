package com.multi.matchon.customerservice.controller;

import com.multi.matchon.customerservice.domain.CustomerServiceType;
import com.multi.matchon.customerservice.dto.res.FaqDto;
import com.multi.matchon.customerservice.service.FaqService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class FaqController {

    private final FaqService faqService;

    // 카테고리 + 키워드 통합 필터
    @GetMapping("/cs")
    public String faqShow(@RequestParam(required = false) CustomerServiceType category,
                          @RequestParam(required = false) String keyword,
                          Model model) {

        List<FaqDto> faqList;

        if (keyword != null && !keyword.isBlank()) {
            if (category != null) {
                faqList = faqService.searchByCategoryAndTitle(category, keyword);
            } else {
                faqList = faqService.searchByTitle(keyword);
            }
        } else {
            faqList = faqService.getFaqList(category);
        }

        // 로그 출력
        System.out.println("선택된 카테고리: " + category);
        System.out.println("입력된 키워드: " + keyword);
        faqList.forEach(f -> System.out.println("조회된 제목: " + f.getFaqTitle()));

        model.addAttribute("faqList", faqList);
        model.addAttribute("category", category);
        model.addAttribute("keyword", keyword); // 검색창 입력값 유지용
        return "cs/cs";
    }

    // 상세보기(챗봇 이용방법)
    @GetMapping("/faq/howtochatbot")
    public String faqChatbotPage() {
        return "cs/cs-faq-detail";
    }

    // 등록하기
    @GetMapping("/faq/register")
    public String write() {
        return "cs/cs-faq-register";
    }
}
