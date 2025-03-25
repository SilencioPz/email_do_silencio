package org.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigCheckController {
    @Value("${spring.mail.username}")
    private String mailUser;

    @GetMapping("/check-mail-config")
    public String checkConfig() {
        return "Username configurado: " + (mailUser != null ? "✔️" : "❌ (não encontrado)");
    }
}