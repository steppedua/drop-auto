package com.steppedua.dropauto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String indexPage(Model model) {
        return "index";
    }

    @GetMapping("/course")
    public String coursePage() {
        return "course";
    }


}
