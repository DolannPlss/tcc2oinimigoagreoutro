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

import com.projeto.barganhaleilao.repository.Produtos;
import com.projeto.barganhaleilao.repository.UsuarioObjetoFiltro;

@Controller
@RequestMapping(value="/objetos/cliente")
public class ObjetosClienteController {
	
	@Autowired
	private Produtos prod;
    
	@RequestMapping
	public ModelAndView pesquisar(@ModelAttribute("filtro") UsuarioObjetoFiltro filtro) {
		String usuario = filtro.getUsuario() == null ? "%" : filtro.getUsuario();
		List<CadProduto> todosObjetos = prod.findByUsuarioContaining(usuario);
		ModelAndView mv = new ModelAndView("ObjetosCliente");
		mv.addObject("Produtos", todosObjetos);
		return mv;
	}
	
	@RequestMapping("{codigo}")
	public String excluir(@PathVariable CadProduto codigo) {
		prod.delete(codigo);
		
		return "redirect:/objetos/cliente";
	}
	


	

	

	}
