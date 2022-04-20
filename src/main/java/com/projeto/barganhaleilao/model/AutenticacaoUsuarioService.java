package com.projeto.barganhaleilao.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.projeto.barganhaleilao.repository.UsuarioInterface;

public class AutenticacaoUsuarioService implements UserDetailsService{
   
	@Autowired
    private UsuarioInterface cliente;
     
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Clientes user = cliente.findByUsuario(username);
        if (user == null) {
            throw new UsernameNotFoundException("Usuario não encontrado");
        }
        return new AutenticacaoUsuario(user);
    }
}
