package com.projeto.barganhaleilao.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CadProdutoVendido {

	public CadProdutoVendido(String usuario, String produto, BigDecimal preco, BigDecimal leilaoFinal, String status, String descricao, String nomeLeilao) {
		this.usuario = usuario;
		this.produto = produto;
		this.preco = preco;
		this.descricao = descricao;
		this.status = status;
		this.nomeLeilao = nomeLeilao;
		this.leilaoFinal = leilaoFinal;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long codigo;
	
	private String usuario;
	private String produto;
	private BigDecimal preco;
	private String descricao;
	private String status;
	private String nomeLeilao;
	private BigDecimal leilaoFinal;
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public BigDecimal getPreco() {
		return preco;
		
	}

	public void setPreco(BigDecimal preco) {
		setLeilaofinal(preco);
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public BigDecimal getLeilaofinal() {
		return leilaoFinal;
	}

	public void setLeilaofinal(BigDecimal leilaoFinal) {
		this.leilaoFinal = leilaoFinal;
	}

	public String getNomeleilao() {
		return nomeLeilao;
	}

	public void setNomeleilao(String nomeleilao) {
		this.nomeLeilao = nomeleilao;
	}

}
