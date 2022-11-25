package org.soulcodeacademy.helpr.domen;

import org.soulcodeacademy.helpr.domen.enums.StatusChamado;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Chamado {
        @Id
        @GeneratedValue(strategy =  GenerationType.IDENTITY)
        private Integer idChamado;

        @Column(nullable = false, length = 150)
        private String titulo;

        @Column(nullable = false, length = 256)
        private  String descricao;

        private LocalDate dataAbertura = LocalDate.now();

        private LocalDate dataFechamento;

        @Enumerated(EnumType.STRING) // Representa o enum escrito
        private StatusChamado status = StatusChamado.RECEBIDO;

        @JoinColumn(name = "id_funcionario") // chave estrangeira
        @ManyToOne // muitos chamados para 1 funcionario
        private Funcionario funcionario;

        @ManyToOne
        @JoinColumn(name = "id_cliente")
        private Cliente cliente;

        public Chamado(){}
        public Chamado(Integer idChamado, String titulo, String descricao) {
                this.idChamado = idChamado;
                this.titulo = titulo;
                this.descricao = descricao;
        }

        public Integer getIdChamado() {
                return idChamado;
        }

        public void setIdChamado(Integer idChamado) {
                this.idChamado = idChamado;
        }

        public String getTitulo() {
                return titulo;
        }

        public void setTitulo(String titulo) {
                this.titulo = titulo;
        }

        public String getDescricao() {
                return descricao;
        }

        public void setDescricao(String descricao) {
                this.descricao = descricao;
        }

        public LocalDate getDataAbertura() {
                return dataAbertura;
        }

        public void setDataAbertura(LocalDate dataAbertura) {
                this.dataAbertura = dataAbertura;
        }

        public LocalDate getDataFechamento(LocalDate now) {
                return dataFechamento;
        }

        public void setDataFechamento(LocalDate dataFechamento) {
                this.dataFechamento = dataFechamento;
        }

        public StatusChamado getStatus() {
                return status;
        }

        public void setStatus(StatusChamado status) {
                this.status = status;
        }

        public Funcionario getFuncionario() {
                return funcionario;
        }

        public void setFuncionario(Funcionario funcionario) {
                this.funcionario = funcionario;
        }

        public Cliente getCliente() {
                return cliente;
        }

        public void setCliente(Cliente cliente) {
                this.cliente = cliente;
        }
}
