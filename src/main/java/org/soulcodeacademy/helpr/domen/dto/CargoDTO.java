package org.soulcodeacademy.helpr.domen.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CargoDTO {
    @NotBlank(message = "Campo nome é obrigatório ")
    private String  nome;
    @NotBlank(message = "Campo descrição é obrigatório ")
    private String  descricao;
    @NotNull(message = "Campo salário é obrigatório")
    @Min(value = 500, message = "Campo salario deve ser maior que 500")
    @Max(value = 100000, message = "O salario não pode ser maior que 100.000,00")
    private double  salario;

    public CargoDTO(String nome, String descricao, double salario) {
        this.nome = nome;
        this.descricao = descricao;
        this.salario = salario;
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

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }



}
