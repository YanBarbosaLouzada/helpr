package org.soulcodeacademy.helpr.repositories;

import org.soulcodeacademy.helpr.domen.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {// Generics

}
