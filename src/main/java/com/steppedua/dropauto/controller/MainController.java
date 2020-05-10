package com.steppedua.dropauto.controller;

import com.steppedua.dropauto.domain.User;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
