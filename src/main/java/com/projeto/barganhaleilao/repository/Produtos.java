package com.projeto.barganhaleilao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projeto.barganhaleilao.model.CadProduto;

public interface Produtos extends JpaRepository<CadProduto, Long>{
	
	@Query(nativeQuery = true, value = "SELECT cli.celular FROM barganhaleilao.clientes cli, "
			+ "barganhaleilao.cad_produto prod WHERE cli.usuario = :cliente and cli.usuario = prod.usuario")
	String buscarCelularDoVendedor(@Param("cliente") String cliente);
	

	
	
}
