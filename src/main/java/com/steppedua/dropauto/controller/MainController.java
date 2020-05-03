package com.steppedua.dropauto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String indexPage() {
        return "index";
    }




    @GetMapping("/buy")
    public String buyCourse() {
        return "buy";
    }


}
