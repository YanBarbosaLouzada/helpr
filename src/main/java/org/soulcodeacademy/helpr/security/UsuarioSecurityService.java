package org.soulcodeacademy.helpr.security;

import org.soulcodeacademy.helpr.domen.Usuario;
import org.soulcodeacademy.helpr.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

//Carregar a entidade do banco de dados e converter para o UsuarioSecurity
@Service
public class UsuarioSecurityService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuarioOptional = this.usuarioRepository.findByEmail(username);
        if (usuarioOptional.isEmpty()){
            //Nao encontrou o Usuario com o email indiacado em username
            throw new UsernameNotFoundException("Usuario nao encontradado");
        }else {
            Usuario usuario = usuarioOptional.get();
            //Reconhece o usuario
            return new UsuarioSecurity(usuario.getEmail(), usuario.getSenha(), usuario.getPerfil());
        }
    }
}
