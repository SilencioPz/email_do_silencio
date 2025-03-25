package org.example;

import org.example.model.Email;
import org.example.model.EmailRequest;
import org.example.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

@Service
public class EmailService {

    private int contagemEnvio = 0; // Contador interno

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private EmailRepository emailRepository;

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                    + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"
    );

    public void enviarEmail(String remetente, String destinatario, String assunto, String texto) {

        if (destinatario == null || destinatario.isBlank()) {
            throw new RuntimeException("Destinatário não pode ser vazio");
        }

        Email email = new Email();
        email.setRemetente(remetente);
        email.setDestinatario(destinatario);
        email.setAssunto(assunto);
        email.setTexto(texto);
        email.setDataEnvio(LocalDateTime.now());
        emailRepository.save(email);

        String[] destinos = destinatario.split(",");
        for (String destino : destinos) {
            SimpleMailMessage mensagem = new SimpleMailMessage();
            mensagem.setFrom(remetente);
            mensagem.setTo(destino.trim());
            mensagem.setSubject(assunto);
            mensagem.setText(texto);
            mailSender.send(mensagem);
        }
    }

    public boolean enviarEmail(EmailRequest request) {
        // Lógica de envio de email...
        contagemEnvio++; // Incrementa a cada envio
        return true;
    }

    // Método para teste (NÃO usar em produção)
    public int getContagemEnvio() {
        return contagemEnvio;
    }

    public boolean validarEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        return EMAIL_PATTERN.matcher(email).matches();
    }

    public int algumaLogicaDeNegocio() {
        return 0;
    }
}