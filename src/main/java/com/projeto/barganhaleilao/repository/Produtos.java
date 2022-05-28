package com.projeto.barganhaleilao.repository;

import java.util.List;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projeto.barganhaleilao.model.CadProduto;

public interface Produtos extends JpaRepository<CadProduto, Long>{
	
	@Query(nativeQuery = true, value = "SELECT cli.celular FROM {h-schema}clientes cli, "
			+ "{h-schema}cad_produto prod WHERE cli.usuario = :cliente and cli.usuario = prod.usuario")
	String buscarCelularDoVendedor(@Param("cliente") String cliente);
	
	public List<CadProduto> findByProdutoContaining(String produto);
	
	public List<CadProduto> findByUsuarioContaining(String ObjCliente);
	
}
