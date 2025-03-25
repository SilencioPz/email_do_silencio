package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.EmailRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class EmailControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmailService emailService;

    @Autowired
    private ObjectMapper objectMapper;

    // TESTE 1: Verifica se o endpoint retorna 200 (OK)
    @Test
    void enviarEmail_DeveRetornarOk() throws Exception {
        EmailRequest request = new EmailRequest(
                "remetente@teste.com",
                "destinatario@teste.com",
                "Assunto Teste",
                "Corpo do e-mail"
        );

        mockMvc.perform(MockMvcRequestBuilders.post("/api/emails/enviar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    // TESTE 2: Verifica se o endpoint retorna 400 (Bad Request) para dados inválidos
    @Test
    void enviarEmail_ComDadosInvalidos_DeveRetornarBadRequest() throws Exception {
        EmailRequest request = new EmailRequest(
                "não-é-email",
                "também-não-é-email",
                null,
                null
        );

        mockMvc.perform(MockMvcRequestBuilders.post("/api/emails/enviar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    // TESTE 3: Verifica se o serviço foi chamado corretamente
    @Test
    void enviarEmail_CamposObrigatoriosFaltando_DeveRetornarBadRequest() throws Exception {

        EmailRequest request = new EmailRequest(null, null, null, null);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/emails/enviar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    // Método auxiliar para converter objeto em JSON
    private static String asJsonString(Object obj) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(obj);
    }
}