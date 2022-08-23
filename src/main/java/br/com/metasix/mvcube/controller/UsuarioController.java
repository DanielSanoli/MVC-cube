package br.com.metasix.mvcube.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.metasix.mvcube.dto.RequisicaoNovoUsuario;
import br.com.metasix.mvcube.entity.Usuario;
import br.com.metasix.mvcube.repository.UsuarioRepository;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@GetMapping("form")
	public String form(RequisicaoNovoUsuario requisicao) {
		return "usuario/cadastroUsuario";
	}
	
	@PostMapping("cadastroUsuario")
	public String cadastroUsuario(@Valid RequisicaoNovoUsuario requisicao, BindingResult result) {
		
		if(result.hasErrors()) {
			return "usuario/cadastroUsuario";
		}
		
		Usuario usuario = requisicao.toUsuario();
		
		usuarioRepository.save(usuario);
		return "usuario/cadastroUsuario";
	}
	
}
