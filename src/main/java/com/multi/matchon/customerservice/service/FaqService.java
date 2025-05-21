package com.multi.matchon.customerservice.service;

import com.multi.matchon.customerservice.domain.CustomerServiceType;
import com.multi.matchon.customerservice.domain.Faq;
import com.multi.matchon.customerservice.dto.res.FaqDto;
import com.multi.matchon.customerservice.repository.FaqRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FaqService {

    private final FaqRepository faqRepository;

    public List<Faq> getFaqList(CustomerServiceType category) {
        return (category != null)
                ? faqRepository.findByFaqCategoryAndIsDeletedFalse(category)
                : faqRepository.findByIsDeletedFalse(); // 전체 목록
    }

    public List<FaqDto> searchPosts(String keyword) {
        List<Faq> faqs = faqRepository.findByFaqTitleContaining(keyword);
        List<FaqDto> faqDtoList = new ArrayList<>();

        if(faqs.isEmpty()) return faqDtoList;

        for(Faq faq : faqs) {
            faqDtoList.add(this.convertEntityToDto(faq));
        }
        return faqDtoList;
    }

    private FaqDto convertEntityToDto(Faq faq) {
        return FaqDto.builder()
                .id(faq.getId())
                .member(faq.getMember())
                .faqCategory(faq.getFaqCategory())
                .faqTitle(faq.getFaqTitle())
                .faqContent(faq.getFaqContent())
                .isDeleted(faq.getIsDeleted())
                .build();
    }
}
