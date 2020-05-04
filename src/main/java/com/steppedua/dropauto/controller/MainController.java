package com.steppedua.dropauto.controller;

import com.steppedua.dropauto.domain.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

//    @GetMapping("/")
//    public String indexPage() {
//        return "index";
//    }

    @GetMapping("/buy")
    public String buyCourse() {
        return "buy";
    }

    //достать из cookie, после входа в аккаунт,
    // в следующий раз, нужные параметры user
    @GetMapping("/")
    public String index(@AuthenticationPrincipal User user, Model model) {

        //если user был в базе данных
        if (user != null) {
            model.addAttribute("user", user.getUsername());
            return "index";
        }

        //если user не был в базе данных
        model.addAttribute("user", "anonymous");
        return "index";
    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @PreAuthorize(value = "hasAuthority('ADMIN') or hasAuthority('USER')")
    @GetMapping("/foruser")
    public String forUser() {
        return "foruser";
    }

    @PreAuthorize(value = "hasAuthority('ADMIN')")
    @GetMapping("/foradmin")
    public String forAdmin() {
        return "foradmin";
    }
}
