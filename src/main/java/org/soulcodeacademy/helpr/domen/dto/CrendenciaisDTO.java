package org.soulcodeacademy.helpr.domen.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CrendenciaisDTO {
    @NotBlank(message = "Email invalido")
    @Email(message = "Email Invalido")
    private String email;

    @NotBlank(message = "Senha é obrigatoria")
    private String senha;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
