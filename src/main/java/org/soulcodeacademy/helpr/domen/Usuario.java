package org.soulcodeacademy.helpr.domen;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.soulcodeacademy.helpr.domen.enums.Perfil;

import javax.persistence.*;

@Entity
@Table(name = "usuarios") // nome da coluna
public abstract class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    @Column(nullable = false, length = 150)
    protected String nome;
    @Column(nullable = false,unique = true,length = 120)
    protected String email;
    @Column(nullable = false,unique = true,length = 11)
    protected String cpf;
    @JsonIgnore // Impede a leitura do Json
    @Column(nullable = false)
    protected String senha;

    @Enumerated(EnumType.STRING)
    protected Perfil perfil;
 public Usuario(){}
    public Usuario(Integer id, String nome, String email, String cpf, String senha, Perfil perfil) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
        this.perfil = perfil;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
}
