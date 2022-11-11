package org.soulcodeacademy.helpr.domen;

import org.soulcodeacademy.helpr.domen.enums.Perfil;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Funcionario extends Usuario{

    private String foto;

    @ManyToOne // Muitos funcionarios para um Cargo
    @JoinColumn(name = "idCargo") // Cria uma coluna nova que a chave estrangeira e idCargo
    private Cargo cargo;

    public Funcionario(){}

    public Funcionario(Integer id, String nome, String email, String cpf, String senha,String foto, Cargo cargo) {
        super(id, nome, email, cpf, senha,Perfil.FUNCIONARIO); // CHama de construtor do Usuario
        this.foto = foto;
        this.cargo = cargo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }


}
