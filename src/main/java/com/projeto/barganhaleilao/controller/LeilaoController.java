package com.projeto.barganhaleilao.controller;

import java.math.BigDecimal;

import com.projeto.barganhaleilao.model.CadProduto;
import com.projeto.barganhaleilao.repository.Produtos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/produto/leilao/")
public class LeilaoController {

	@Autowired
	private Produtos prod;

	@RequestMapping(value = "{codigo}", method = RequestMethod.GET)
	public ModelAndView tela(@PathVariable("codigo") Long codigo) {
		CadProduto todosProdutos = prod.findById(codigo).get();
		ModelAndView mv = new ModelAndView("Leilao");
		mv.addObject("produtos", todosProdutos);
		mv.addObject(new CadProduto());
		return mv;
	}
	@RequestMapping(value = "{codigo}", method = RequestMethod.POST)
	public ModelAndView salvar(@Validated CadProduto cadProduto, BigDecimal lancefinal,String nomeleilao, @PathVariable("codigo") Long codigo) {
		CadProduto todosProdutos = prod.findById(codigo).get();
		ModelAndView mv = new ModelAndView("redirect:{codigo}");
		todosProdutos.setLeilaofinal(lancefinal);
		todosProdutos.setNomeleilao(nomeleilao);
		mv.addObject(todosProdutos.getLeilaofinal());
		mv.addObject(todosProdutos.getNomeleilao());
		prod.save(todosProdutos);
		return mv;
	}

}