package org.soulcodeacademy.helpr.domen;

import javax.persistence.*;

//transformar a class em uma entidade

@Entity
public class Cargo {
    @Id // torna o atrinuto abaixo como chave 1°
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoIncrement
    private Integer idCargo;
    @Column(nullable = false,  length = 50) // not null e varchar
    private String nome;
    @Column(nullable = false, length = 120)
    private String descricao;
    @Column(nullable = false)
    private Double salario;

    // a ORM  irá usar este cosntrutor em conjuntos de getters/setters

    public Cargo() {}

    public Cargo(Integer idCargo, String nome, String descricao, Double salario) {
        this.idCargo = idCargo;
        this.nome = nome;
        this.descricao = descricao;
        this.salario = salario;
    }

    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }





}
