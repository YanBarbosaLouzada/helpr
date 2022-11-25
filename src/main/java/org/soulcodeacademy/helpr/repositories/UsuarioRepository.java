package org.soulcodeacademy.helpr.repositories;

import org.soulcodeacademy.helpr.domen.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {


    Optional<Usuario> findByEmail(String email); // WHERE email = email
    Optional<Usuario> findByCpf(String cpf); // WHERE cpf = cpf
    List<Usuario> findByNome(String nome); // WHERE nome = nome
    List<Usuario> findByNomeContaining(String busca); // Filtrar pelo nome

}
// Métodos presentes
// - findAll() => SELECT * FROM usuarios;
// - findById(Integer) => SELECT * FROM usuarios WHERE id = ?;
// - save(Usuario) => INSERT INTO(caso id nulo) ou UPDATE (caso id não nulo)
// - delete(Usuario) => DELETE FROM usuarios WHERE id = ?;

//crud
//entidade -> Repository -> dto -> service + controler