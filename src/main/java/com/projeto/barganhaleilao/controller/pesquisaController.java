package com.projeto.barganhaleilao.controller;

import java.util.List;

import com.projeto.barganhaleilao.model.CadProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.barganhaleilao.repository.ObjetoFiltro;
import com.projeto.barganhaleilao.repository.Produtos;

@Controller
@RequestMapping(value="/produto/pesquisa")
public class pesquisaController {
	
	@Autowired
	private Produtos prod;
    
	@RequestMapping
	public ModelAndView pesquisar(@ModelAttribute("filtro") ObjetoFiltro filtro) {
		String produto = filtro.getProduto() == null ? "%" : filtro.getProduto();
		List<CadProduto> todosObjetos = prod.findByProdutoContaining(produto);
		ModelAndView mv = new ModelAndView("PesquisaProdutos");
		mv.addObject("Produtos", todosObjetos);
		return mv;
	}
	
	@RequestMapping(value="{codigo}", method = RequestMethod.GET)
	public ModelAndView tela(@PathVariable("codigo") Long codigo) {
		CadProduto todosProdutos = prod.findById(codigo).get();
		ModelAndView mv = new ModelAndView("TelaDeCompra");
		mv.addObject("produtos", todosProdutos);
		mv.addObject(new CadProduto());
		return mv;
	}
}
