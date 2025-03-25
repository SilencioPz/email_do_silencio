package org.example.controller;

import jakarta.validation.Valid;
import org.example.EmailService;
import org.example.model.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/emails")
public class EmailController {

    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public ResponseEntity<String> enviarEmail(@Valid @RequestBody EmailRequest request) {
        emailService.enviarEmail(
                request.getRemetente(),
                request.getPara(),
                request.getAssunto(),
                request.getTexto()
        );
        return ResponseEntity.ok("E-mail enviado com sucesso para " + request.getPara());
    }
}

