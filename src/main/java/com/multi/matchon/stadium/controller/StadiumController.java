package com.multi.matchon.stadium.controller;

import com.multi.matchon.stadium.domain.Stadium;
import com.multi.matchon.stadium.service.StadiumService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StadiumController {

    private final StadiumService stadiumService;

    @GetMapping("/stadium")
    public String showStadiumList(Model model) {
        List<Stadium> stadiums = stadiumService.getAllStadiums(); // 변수명 수정
        model.addAttribute("stadiums", stadiums); // ★ 뷰와 일치하게 변수명 수정
        return "stadium/stadium"; // stadium.html이 templates/stadium/ 하위에 위치해야 함
    }
}
