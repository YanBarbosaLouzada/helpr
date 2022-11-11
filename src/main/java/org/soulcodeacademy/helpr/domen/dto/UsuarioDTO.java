package org.soulcodeacademy.helpr.domen.dto;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UsuarioDTO {

 @NotBlank(message = "O nome é obrigatorio")
 protected String nome;

 @Email(message = "Email invalido")
 @NotBlank(message = "Este campo nao pode estar vazio")
 protected String email;

 @NotBlank(message = "Campo vazio")
 protected String senha;


 @NotBlank(message = "campo vazio")
 @CPF
 protected String cpf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

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


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
