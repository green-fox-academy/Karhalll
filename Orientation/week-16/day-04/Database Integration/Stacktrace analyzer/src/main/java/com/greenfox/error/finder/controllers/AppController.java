package com.greenfox.error.finder.controllers;

import com.greenfox.error.finder.services.UserService;
import com.greenfox.error.finder.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class AppController {

    UserService service;

    public AppController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("new_user", new User());
        model.addAttribute("users", service.getAll());
        return "index";
    }

    @PostMapping
    public String create(@ModelAttribute("new_user") User newUser) {
        service.save(newUser);
        return "redirect:/app";
    }
}