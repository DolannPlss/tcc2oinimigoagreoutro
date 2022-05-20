
package com.projeto.barganhaleilao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.barganhaleilao.model.CadProduto;
import com.projeto.barganhaleilao.repository.Produtos;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private Produtos prod;
	
	@RequestMapping
	public ModelAndView home() {
		List <CadProduto> todosProdutos = prod.findAll();
		ModelAndView mv = new ModelAndView("Home");
		mv.addObject("produtos", todosProdutos);
		return mv;
	}
	
	
	

}