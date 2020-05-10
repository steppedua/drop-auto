package com.steppedua.dropauto.controller;


import com.steppedua.dropauto.domain.User;
import com.steppedua.dropauto.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/registration")
    public String registrationPage(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String registrationNewUser(@ModelAttribute("user") @Valid User user, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "registration";
        }

        if (!user.getPassword().equals(user.getMatchingPassword())) {
            //кидаем свою ошибку, если password не совпадает по полю "password"
            result.rejectValue("password", "", "Password not matching");
            return "registration";
        }

        userService.create(user);
        return "redirect:/login";
    }
}
