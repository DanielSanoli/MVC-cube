package br.com.metasix.mvcube.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.metasix.mvcube.dto.ChamadoDTO;
import br.com.metasix.mvcube.entity.Chamado;
import br.com.metasix.mvcube.entity.Usuario;
import br.com.metasix.mvcube.service.ChamadoService;
import br.com.metasix.mvcube.service.UsuarioService;

@Controller
@RequestMapping("chamado")
public class ChamadoController {
	
	@Autowired
	ChamadoService chamadoService;
	
	@Autowired
	UsuarioService usuarioService;

	@GetMapping("formChamado")
	public String formChamado(ChamadoDTO chamado) {
		return "chamado/cadastroChamado";
	}
	
	@PostMapping("/formChamado")
	public String cadastroChamado(@Valid ChamadoDTO chamadoDto,  BindingResult result) {
		
		if(result.hasErrors()) {
			return "usuario/cadastroUsuario";
		}
		
		Usuario usuario = getUsuarioLogado();
		
		if (usuario == null) {
	        result.rejectValue("usuarioId", "error.chamadoDto", "Usuário não encontrado.");
	        return "usuario/cadastroUsuario";
	    }
		
		Chamado chamado = chamadoDto.toChamado(usuario);
		chamadoService.execute(chamado);
		
		return "home";
	}
	
	public Usuario getUsuarioLogado() {
	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
	        return null;
	    }
	    
	    UserDetails userDetails = (UserDetails) authentication.getPrincipal();
	    return usuarioService.findByUsername(userDetails.getUsername());
	}
	
}
