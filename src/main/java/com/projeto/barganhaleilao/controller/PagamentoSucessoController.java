package com.projeto.barganhaleilao.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pay")
public class PagamentoSucessoController {


    @RequestMapping
    public ModelAndView delete() {
        ModelAndView mv = new ModelAndView("Sucesso");
        return mv;
    }

}