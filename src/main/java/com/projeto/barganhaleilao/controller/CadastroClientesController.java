package com.projeto.barganhaleilao.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.barganhaleilao.model.Clientes;
import com.projeto.barganhaleilao.repository.ClientesInterface;

@Controller
@RequestMapping("/cadastro")
public class CadastroClientesController {
	
	@Autowired
	private ClientesInterface clientesInterface;
	
	@RequestMapping(value = "/cliente", method = RequestMethod.GET)
	public ModelAndView novo(Clientes clientes) {
		ModelAndView mv = new ModelAndView("CadastroClientes");
		return mv;
	}

	@RequestMapping(value="/cliente", method=RequestMethod.POST)
	public ModelAndView salvar(@Valid Clientes clientes, BindingResult result) {
		if(result.hasErrors()){
			return novo(clientes);
		}

		ModelAndView mv = new ModelAndView("CadastroClientes");
		
		  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		    String encodedPassword = passwordEncoder.encode(clientes.getSenha());
		    clientes.setSenha(encodedPassword);
		    
		clientesInterface.save(clientes);
		mv.addObject("mensagem", "Cliente cadastrado com sucesso!");
		return mv;
	}
	
	@RequestMapping(value="/pesquisa", method=RequestMethod.GET)
	public ModelAndView pesquisaCliente(Clientes clientes) {
		ModelAndView mv = new ModelAndView("PesquisaClientes");
		List<Clientes> todosClientes = clientesInterface.findAll();
		mv.addObject("clientes", todosClientes);
		return mv;
	}
	

}