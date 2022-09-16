package com.company.springboot.app.springbootform.controllers;

import com.company.springboot.app.springbootform.models.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
// Keep Default Values
@SessionAttributes("user")
public class FormController {



    @GetMapping("/form")
    public String form(Model model) {
        /***************** Send to view to Errors Validations, IMPORTANT! *********************/
        User user = new User();
        user.setName("John");
        user.setLastName("Doe");
        user.setDni("03091999000084");
        model.addAttribute("title", "Forms with Thymeleaf");
        model.addAttribute("user", user);
        return "form";
    }

    @PostMapping("/form")
    public String processForm(@Valid User user, BindingResult result, Model model, SessionStatus status/*
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

        // With (User user) maps to object. (Params must have the same name as in the User Class | Pojo)

        model.addAttribute("title", "Forms with Thymeleaf");

        // Errors
        if (result.hasErrors()) {
            /** Map Errors -> #1
             *Map<String, String> errors = new HashMap<>();
             *             result.getFieldErrors().forEach(err -> {
             *                 errors.put(err.getField(), err.getDefaultMessage());
             *             });
             *             model.addAttribute("errors", errors);
             */
            return "form";
        }

        model.addAttribute("user", user);

        // Complete Session Value
        status.setComplete();

        return "result";

    }

}
