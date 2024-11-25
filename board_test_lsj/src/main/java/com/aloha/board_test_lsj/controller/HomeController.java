package com.aloha.board_test_lsj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
    
    // 메인
    @GetMapping({"","/"})
    public String index() {
        return "/index";
    }
    
}
