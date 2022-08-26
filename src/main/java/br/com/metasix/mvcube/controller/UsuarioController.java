package br.com.metasix.mvcube.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.metasix.mvcube.dto.RequisicaoNovoUsuario;
import br.com.metasix.mvcube.dto.RoleDTO;
import br.com.metasix.mvcube.entity.Usuario;
import br.com.metasix.mvcube.repository.UsuarioRepository;
import br.com.metasix.mvcube.service.RoleService;
import br.com.metasix.mvcube.service.UsuarioService;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping("formUsuario")
	public String form(RequisicaoNovoUsuario requisicao) {
		return "usuario/cadastroUsuario";
	}
	
	@GetMapping("formCidadao")
	public String formCidadao(RequisicaoNovoUsuario requisicao) {
		return "cidadao/cadastroCidadao";
	}
	
	@PostMapping("cadastroUsuario")
	public String cadastroUsuario(@Valid RequisicaoNovoUsuario requisicao, BindingResult result) {
		
		if(result.hasErrors()) {
			return "usuario/cadastroUsuario";
		}
		
		Usuario usuario = requisicao.toUsuario();
		
		usuarioService.execute(usuario);
		
		RoleDTO roleDto = requisicao.toRole();
		roleDto.setIdUsuario(usuario.getId());
		roleService.execute(roleDto);
		return "home";
	}
	
	@PostMapping("cadastroCidadao")
	public String cadastroCidadao(@Valid RequisicaoNovoUsuario requisicao, BindingResult result) {
		
		if(result.hasErrors()) {
			return "cidadao/cadastroCidadao";
		}
		
		Usuario usuario = requisicao.toUsuario();
		
		usuarioService.execute(usuario);
		
		RoleDTO roleDto = requisicao.toRole();
		roleDto.setIdUsuario(usuario.getId());
		
		roleService.executeCidadao(roleDto);
		return "login";
	}
	
	@GetMapping("/list")
    public ModelAndView userList() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        ModelAndView mv = new ModelAndView("usuario/listUsuarios");
        mv.addObject("list", usuarios);
        return mv;
    }
	
	@PostMapping("/findByName")
    public ModelAndView findByName(@RequestParam("nomepesquisa") String nomepesquisa) {
        List<Usuario> user = null;
        if (nomepesquisa.equals("")) {
            user = this.usuarioRepository.findAll();
        } else {
            user = this.usuarioRepository.findByName(nomepesquisa);
        }
        ModelAndView mv = new ModelAndView("user/userlist");
        mv.addObject("list", user);
        return mv;
    }
	
}
