package org.example.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class EmailRequest {
    @NotBlank(message = "Remetente é obrigatório")
    @Email(message = "Remetente deve ser um e-mail válido")
    private String remetente;

    @NotBlank(message = "Destinatário é obrigatório")
    @Email(message = "Destinatário deve ser um e-mail válido")
    private String para;

    @NotBlank(message = "Assunto é obrigatório")
    private String assunto;

    @NotBlank(message = "Texto é obrigatório")
    private String texto;

    // Construtor padrão (necessário para o Spring)
    public EmailRequest() {
    }

    // Construtor completo
    public EmailRequest(String remetente, String para, String assunto, String texto) {
        this.remetente = remetente;
        this.para = para;
        this.assunto = assunto;
        this.texto = texto;
    }

    // Getters e Setters (mantidos conforme estava)
    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getPara() {
        return para;
    }

    public void setPara(String para) {
        this.para = para;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}