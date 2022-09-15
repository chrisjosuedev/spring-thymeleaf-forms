package com.company.springboot.app.springbootform.controllers;

import com.company.springboot.app.springbootform.models.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("title", "Forms with Thymeleaf");
        return "form";
    }

    @PostMapping("/form")
    public String processForm(User user, Model model/*
                              @RequestParam String username,
                              @RequestParam String password,
                              @RequestParam String email */) {

        // Basic way to received (req) params
        /*
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
         **/

        // With (User user) maps to object. (Params Should have the same name)

        model.addAttribute("user", user);
        return "result";

    }

}
