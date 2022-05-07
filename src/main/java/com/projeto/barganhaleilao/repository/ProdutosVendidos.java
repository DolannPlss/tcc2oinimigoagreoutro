package com.projeto.barganhaleilao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.barganhaleilao.model.CadProdutoVendido;

public interface ProdutosVendidos extends JpaRepository<CadProdutoVendido, Long>{

}
