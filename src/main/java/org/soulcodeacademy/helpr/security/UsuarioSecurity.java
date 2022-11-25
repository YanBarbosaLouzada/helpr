package org.soulcodeacademy.helpr.security;

import org.soulcodeacademy.helpr.domen.enums.Perfil;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

//Esta classe serve de ponte para a comunicão entre as tabelas e o frameWork String Segurity
public class UsuarioSecurity  implements UserDetails {
    private String email;
    private String senha;
    //Dados de autorização
    private Perfil perfil;
    //Armazena as permissoes
    private ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();

    public UsuarioSecurity(String email, String senha, Perfil perfil) {
        this.email = email;
        this.senha = senha;
        this.perfil = perfil;
        this.authorities.add(new SimpleGrantedAuthority(perfil.getDescricao()));
    }

    // Indicar as permissoes e papeis do meu usaruio
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }
    // infica se a conta esta valida // Sim ela esta valida
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    // Indica se a conta esta desbloqueada
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    //Indica se as credenciais estão validadas  // Sim estao validads
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    // Indica se o usuario esta habilitado //Sim esta habilitado
    @Override
    public boolean isEnabled() {
        return true;
    }
}
