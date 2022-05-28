package com.projeto.barganhaleilao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projeto.barganhaleilao.model.Clientes;

public interface ClientesInterface extends JpaRepository<Clientes, Long>{

	@Query(nativeQuery = true, value = "SELECT cli.celular FROM barganhaleilao.clientes cli, "
							+ "barganhaleilao.cad_produto prod WHERE WHERE cli.nome = :cliente and cli.nome = prod.nomeleilao")
	String buscarCelularDoVendedor(@Param("cliente") String cliente);
	
}
