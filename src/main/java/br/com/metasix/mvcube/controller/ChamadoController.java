package br.com.metasix.mvcube.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import br.com.metasix.mvcube.dto.ChamadoDTO;
import br.com.metasix.mvcube.entity.Chamado;
import br.com.metasix.mvcube.entity.Usuario;
import br.com.metasix.mvcube.repository.ChamadoRepository;
import br.com.metasix.mvcube.service.ChamadoService;
import br.com.metasix.mvcube.service.UsuarioService;

@Controller
@RequestMapping("chamado")
public class ChamadoController {
	
	@Autowired
	ChamadoService chamadoService;
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	ChamadoRepository chamadoRepository;

	@GetMapping("formChamado")
	public String formChamado(Model model) {
	    model.addAttribute("chamadoDTO", new ChamadoDTO());
	    return "chamado/cadastroChamado";
	}
	
	@GetMapping("/list")
	public ModelAndView chamadosList() {
		List<Chamado> chamados = chamadoRepository.findAllOrderById();
		ModelAndView mv = new ModelAndView("chamado/listChamados");
		mv.addObject("list", chamados);
		return mv;
	}
	
	@GetMapping("/chamadoEdit/{id}")
	public ModelAndView chamadoEdit(@PathVariable("id") Long id, Chamado chamado) {
		Chamado cm = chamadoRepository.findById(id).get();
		
		ModelAndView mv = new ModelAndView("chamado/editChamado");
		mv.addObject("chamado", cm);
		mv.addObject("idChamado", id);
		return mv;
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
		
		return "redirect:/home";
	}
	
	@PostMapping("/editChamado/{id}")
    public RedirectView editChamado(@PathVariable Long id, Chamado chamado) {
        RedirectView redirectView = new RedirectView("/chamado/list");
        
        if (chamado != null) {
            this.chamadoService.edit(chamado);
            return redirectView;
        } else {
            return redirectView;
        }
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
