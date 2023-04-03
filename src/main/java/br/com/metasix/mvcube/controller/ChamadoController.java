package br.com.metasix.mvcube.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.metasix.mvcube.dto.ChamadoDTO;
import br.com.metasix.mvcube.entity.Chamado;
import br.com.metasix.mvcube.service.ChamadoService;

@Controller
@RequestMapping("chamado")
public class ChamadoController {
	
	@Autowired
	ChamadoService service;

	@GetMapping("formChamado")
	public String formChamado(ChamadoDTO chamado) {
		return "chamado/cadastroChamado";
	}
	
	@PostMapping("/formChamado")
	public String cadastroUsuario(@Valid ChamadoDTO chamadoDto,  BindingResult result) {
		
		if(result.hasErrors()) {
			return "usuario/cadastroUsuario";
		}
		
		Chamado chamado = chamadoDto.toChamado();
		service.execute(chamado);
		
		return "home";
	}
	
}
