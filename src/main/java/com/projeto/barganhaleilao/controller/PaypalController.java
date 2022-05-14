package com.projeto.barganhaleilao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.barganhaleilao.model.CadProduto;
import com.projeto.barganhaleilao.model.CadProdutoVendido;
import com.projeto.barganhaleilao.model.StatusVenda;
import com.projeto.barganhaleilao.repository.Produtos;
import com.projeto.barganhaleilao.repository.ProdutosVendidos;

@Controller
@RequestMapping("/produto/Pagamento/")
public class PaypalController {

	@Autowired
	private Produtos prod;
	
	@Autowired
	private ProdutosVendidos prodVendidos;
	
	@RequestMapping(value="{codigo}", method = RequestMethod.GET)
	public ModelAndView tela(@PathVariable("codigo") Long codigo) {
		CadProduto todosProdutos = prod.findById(codigo).get();
		ModelAndView mv = new ModelAndView("Pagamento");
		mv.addObject("produtos", todosProdutos);
		mv.addObject(new CadProduto());
		return mv;
	}
	
	@RequestMapping("/finalizar/{codigo}")
	public String compra(@PathVariable CadProduto codigo){
		CadProdutoVendido cadProdutoVendido = new CadProdutoVendido(codigo.getUsuario(), codigo.getProduto(),  
																	codigo.getPreco(), codigo.getLeilaofinal(),
																	pegarStatus(codigo),
																	codigo.getDescricao(), codigo.getNomeleilao());
		prodVendidos.save(cadProdutoVendido);
		prod.delete(codigo);
		return "Sucesso"; 
	}
	
	private String pegarStatus(@PathVariable CadProduto produto) {
		produto.getStatus();
		if(produto.getStatus().toString().equals(StatusVenda.BARGANHA.toString())) {
			return "Barganha";
		} else {
			return "Leilão";
		}
	}
}
