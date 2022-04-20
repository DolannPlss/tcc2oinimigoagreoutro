package com.projeto.barganhaleilao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.barganhaleilao.model.CadProduto;
import com.projeto.barganhaleilao.repository.Produtos;

@Controller
@RequestMapping("/produto/compra/")
public class CompraController {

	@Autowired
	private Produtos prod;
	
	@RequestMapping(value="{codigo}", method = RequestMethod.GET)
	public ModelAndView tela(@PathVariable("codigo") Long codigo) {
		CadProduto todosProdutos = prod.findById(codigo).get();
		ModelAndView mv = new ModelAndView("TelaDeCompra");
		mv.addObject("produtos", todosProdutos);
		mv.addObject(new CadProduto());
		return mv;
	}
	
	@RequestMapping(value ="{codigo}")
	public String compra(Long codigo){
		prod.deleteById(codigo);
		return "/";
	}
	
}
