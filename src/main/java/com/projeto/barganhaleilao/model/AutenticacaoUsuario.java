package com.projeto.barganhaleilao.model;
 
import java.util.Collection;
 
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
 
public class AutenticacaoUsuario implements UserDetails {
 


	private Clientes cliente;
     
    public AutenticacaoUsuario(Clientes cliente) {
        this.cliente = cliente;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
 
    @Override
    public String getPassword() {
        return cliente.getSenha();
    }
 
    @Override
    public String getUsername() {
        return cliente.getUsuario();
    }
 
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return true;
    }
     
    public String getNome() {
        return cliente.getUsuario();
    }
 
}