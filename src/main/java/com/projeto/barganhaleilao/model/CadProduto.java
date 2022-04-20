package com.projeto.barganhaleilao.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class CadProduto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;
	
	private String usuario;
		
	@Size(max = 30, message = "Descri��o tem que ter no m�ximo 30 caracteres")
	private String produto;
	
	@DecimalMin(value= "0.01", message = "Pre�o n�o pode ser menor que 0,01")
	@DecimalMax(value= "9999999.99", message = "Pre�o n�o pode ser maior que 9999999.99")
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal preco;
	
	private BigDecimal leilaofinal;
	
	@Size(max = 60, message = "Descri��o tem que ter no m�ximo 60 caracteres")
	private String descricao;

	@Enumerated(EnumType.STRING)
	private StatusVenda status;
	
	private String caminho;
 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date comecoleilao;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fimleilao;
	
	private String nomeleilao;
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Date getComecoleilao() {
		return this.comecoleilao;
	}

	public void setComecoleilao(Date comecoleilao) {
		this.comecoleilao = comecoleilao;
	}

	public Date getFimleilao() {
		return this.fimleilao;
	}

	public void setFimleilao(Date fimleilao) {
		this.fimleilao = fimleilao;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
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

	public StatusVenda getStatus() {
		return status;
	}

	public void setStatus(StatusVenda status) {
		this.status = status;
	}
	public BigDecimal getLeilaofinal() {
		return leilaofinal;
	}

	public void setLeilaofinal(BigDecimal leilaofinal) {
		this.leilaofinal = leilaofinal;
	}

	public String getNomeleilao() {
		return nomeleilao;
	}

	public void setNomeleilao(String nomeleilao) {
		this.nomeleilao = nomeleilao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CadProduto other = (CadProduto) obj;
		return codigo == other.codigo;
	}

}
