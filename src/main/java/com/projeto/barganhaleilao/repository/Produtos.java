package com.projeto.barganhaleilao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.barganhaleilao.model.CadProduto;

public interface Produtos extends JpaRepository<CadProduto, Long>{
	
	public List<CadProduto> findByProdutoContaining(String produto);
	
	public List<CadProduto> findByUsuarioContaining(String ObjCliente);

	
	
}
