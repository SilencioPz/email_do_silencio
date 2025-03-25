package org.example.controller;

import org.example.model.Email;
import org.example.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private EmailRepository emailRepository;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/inbox")
    public String inbox(Model model) {
        List<Email> emails = emailRepository.findAll();
        model.addAttribute("emails", emails);
        return "inbox";
    }
}