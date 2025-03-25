package org.example;

import org.example.model.EmailRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test") // Isso carrega o application-test.properties
public class EmailServiceTest {

    @Autowired
    private EmailService emailService;

    @Test
    public void teste1_AceitarEmailValido() {
        assertTrue(emailService.validarEmail("usuario@exemplo.com"));
    }

    @Test
    public void teste2_RejeitarEmailInvalido() {
        assertFalse(emailService.validarEmail("email-sem-arroba"));
        assertFalse(emailService.validarEmail("@sem-usuario.com"));
        assertFalse(emailService.validarEmail("usuario@"));
        assertFalse(emailService.validarEmail("usuario@dominio-sem-ponto"));
        assertFalse(emailService.validarEmail("a@b.c"));
        assertFalse(emailService.validarEmail(null));
        assertFalse(emailService.validarEmail(""));
    }

    @Test
    void teste3_VerificarLogicaDeNegocio() {
        EmailRequest request = new EmailRequest("outro@teste.com",
                "remetente@teste.com", "Assunto", "Texto");
        assertEquals(0, emailService.getContagemEnvio());
    }

    @Test
    public void testeSimples() {
        assertFalse(emailService.validarEmail("invalido"));
    }
}