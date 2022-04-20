package com.projeto.barganhaleilao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projeto.barganhaleilao.model.Clientes;

public interface UsuarioInterface extends JpaRepository<Clientes, Long>{
    @Query("SELECT u FROM Clientes u WHERE u.usuario = ?1")
    public Clientes findByUsuario(String usuario);
}
