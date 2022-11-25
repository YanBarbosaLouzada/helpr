package org.soulcodeacademy.helpr.repositories;

import org.soulcodeacademy.helpr.domen.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Repository = É um recurso que permite manipular a entidade no banco de dados
// Adicionar entidades, atualizar entidades, remover entidades e listar( CRUD)
// Endicar qual a entidade vai ser gerenciada pelo repository e qual o tipo da Pk
// obs O Spring gera uma classe dinamica com base em nossa interface CargoRepository
// Jpa Possui mais funcionalidades p/ tratar a entidade
// crud comtem operaçpes mais basicas

@Repository // indica que a interface é um repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> { //Entidade e pk

            List<Cargo> findByNome(String valor); //where nome = valor
            List<Cargo> findBySalario(Double valor); // salrio = valor
            List<Cargo> findBySalarioGreaterThan(Double valor); // salario > valor
            List<Cargo> findBySalarioGreaterThanEqual(Double valor); //salario >= valor
            List<Cargo> findBySalarioLessThan(Double valor); // where salario < valor
            List<Cargo> findBySalarioLessThanEqual(Double valor); // where salario <= valor
            List<Cargo> findBySalarioBetween(Double valor1, Double valor2); // salario entre valor 1 e 2


}
