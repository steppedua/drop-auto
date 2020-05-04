package com.steppedua.dropauto.controller;

import com.steppedua.dropauto.domain.RegistrationForm;
import com.steppedua.dropauto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String registration(){
        return "registration";
    }

    @PostMapping
    public String processUser(RegistrationForm form){
        //сохраняем зашифрованный пароль user
        userRepository.save(form.toUser(passwordEncoder));

        return "redirect:/login";
    }
}
