package com.projeto.barganhaleilao.model;

public enum StatusVenda {
	BARGANHA("Barganha"),
	LEILAO("Leilão");
	
	private String descricao;
	
	private StatusVenda(String descricao) {
		// TODO Auto-generated constructor stub
	} 
	
	public String getDescricao() {
		return descricao;
	}
}
