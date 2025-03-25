# 🤖 Email de testes usando Mailtrap (Java)

<p align="center">
  <em>Serviço de e-mail funcional para testes e produção</em>
</p>

---

## ✨ Sobre o Projeto
Serviço de e-mail simples e direto, funcional via Postman e integrado com:

**Mailtrap (TESTES)**:
- Plataforma gratuita para simulação de envios
- Sandbox para evitar spams reais
- Dashboard com análise de e-mails "enviados"

**Serviços de Produção**:
- Opções econômicas para envio real

---

## 🚀 Futuro do Projeto

| Versão          | Status       | Observação                          |
|-----------------|-------------|-----------------------------------|
| Mailtrap        | ✅ Pronto    | Atualizado e funcional            |
| SMTP Real       | 🚧 Planejado | Requer API paga (sugestões abaixo) |

---

## 🔧 Tecnologias

| Ferramenta       | Versão      | Uso                                  |
|------------------|------------|-------------------------------------|
| Java             | 17         | Linguagem principal                 |
| Mailtrap         | Free Tier  | Sandbox de e-mails (testes)         |
| Sendinblue       | €25/mês    | Opção econômica para produção       |
| Maven            | 3.9.0      | Gerenciamento de dependências       |
| Spring Boot      | 3.1.0      | Framework Java                      |

---

## 💰 Opções Econômicas para Produção

1. **Sendinblue** (Recomendado):
   - Preço: €25/mês (10k e-mails/dia)
   - Prós: API simples, 94% deliverability
   - Link: [sendinblue.com](https://www.sendinblue.com)

2. **Amazon SES** (Custo-benefício):
   - Preço: $0.10 a cada 1k e-mails
   - Prós: Escalável, integração com AWS
   - Contra: Configuração complexa

3. **Mailgun** (Barato para starters):
   - Preço: $0.80/1k e-mails (primeiros 10k/mês grátis)
   - Prós: Documentação excelente

---

## 📝 Como Usar

1. **Para testes (Mailtrap)**:
   ```properties
   # application.properties
   spring.mail.host=sandbox.smtp.mailtrap.io
   spring.mail.port=2525
   spring.mail.username=seu-usuario
   spring.mail.password=sua-senha

2. Para produção:
# application-prod.properties
    spring.mail.host=smtp-relay.sendinblue.com
    spring.mail.port=587
    spring.mail.username=seu-email@dominio.com
    spring.mail.password=sua-chave-api

3. Execute o projeto:

   java -jar target/EmailDoSilencio-1.0-SNAPSHOT.jar

   <p align="center"> <strong>💡 Dica:</strong> Use perfis do Spring para alternar entre Mailtrap (testes) e SMTP real (produção) </p> ```


