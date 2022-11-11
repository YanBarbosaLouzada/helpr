package org.soulcodeacademy.helpr.repositories;

import org.soulcodeacademy.helpr.domen.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// Repository = É um recurso que permite manipular a entidade no banco de dados
// Adicionar entidades, atualizar entidades, remover entidades e listar( CRUD)
// Endicar qual a entidade vai ser gerenciada pelo repository e qual o tipo da Pk
// obs O Spring gera uma classe dinamica com base em nossa interface CargoRepository
// Jpa Possui mais funcionalidades p/ tratar a entidade
// crud comtem operaçpes mais basicas

@Repository // indica que a interface é um repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> { //Entidade e pk



}
