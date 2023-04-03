package br.com.metasix.mvcube.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("chamado")
public class ChamadoController {

	@GetMapping("formChamado")
	public String cadastroChamado() {
		return "chamado/cadastroChamado";
	}
	
}
