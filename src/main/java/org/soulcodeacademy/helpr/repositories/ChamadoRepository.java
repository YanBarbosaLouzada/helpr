package org.soulcodeacademy.helpr.repositories;

import org.soulcodeacademy.helpr.domen.Chamado;
import org.soulcodeacademy.helpr.domen.Cliente;
import org.soulcodeacademy.helpr.domen.Funcionario;
import org.soulcodeacademy.helpr.domen.enums.StatusChamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ChamadoRepository extends JpaRepository <Chamado, Integer> {

    List<Chamado> findByStatus (StatusChamado status); // Filtrar os chamados de acordo com o status
    List<Chamado> findByCliente(Cliente cliente); // Filtrar os chamados de um cliente
    List<Chamado> findByFuncionario(Funcionario funcionario); // Filtrar os chamados de um funcionario

    @Query(value = "SELECT * FROM chamado WHERE data abertura BETWEEN :date1 AND :date2", nativeQuery = true)
            List<Chamado> buscarEntreDatas(LocalDate date1, LocalDate date2);




}

