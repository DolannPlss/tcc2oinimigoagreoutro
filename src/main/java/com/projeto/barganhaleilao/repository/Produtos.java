package com.projeto.barganhaleilao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projeto.barganhaleilao.model.CadProduto;

public interface Produtos extends JpaRepository<CadProduto, Long>{
	
	@Query(nativeQuery = true, value = "SELECT cli.celular FROM clientes cli, "
			+ "cad_produto prod WHERE cli.usuario = ?1 and cli.usuario = prod.usuario")
	public String buscarCelularDoVendedor(String cliente);
	
	public List<CadProduto> findByProdutoContaining(String produto);
	
	public List<CadProduto> findByUsuarioContaining(String ObjCliente);
	
}
