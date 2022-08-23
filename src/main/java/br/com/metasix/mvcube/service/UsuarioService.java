package br.com.metasix.mvcube.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.metasix.mvcube.entity.Usuario;
import br.com.metasix.mvcube.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	private BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public Usuario execute(Usuario usuario) {

		Usuario existsUsuario = usuarioRepository.findByEmail(usuario.getEmail());

		if (existsUsuario != null) {
			throw new Error("Usuario já existe!");
		}
		
		usuario.setSenha(passwordEncoder().encode(usuario.getSenha()));

		Usuario createdUsuario = usuarioRepository.save(usuario);

		return createdUsuario;
	}

}
