package com.multi.matchon.customerservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CsController {

    @GetMapping("/cs")
    public String showcs() {
        return "cs/cs";
    }
}
