package br.com.metasix.mvcube.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.metasix.mvcube.entity.Usuario;
import br.com.metasix.mvcube.repository.UsuarioRepository;

@Service
public class ImplementsUserDetailsService implements UserDetailsService{

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		
		Usuario existsUsuario = usuarioRepository.findByEmailFetchRoles(login);

		if (existsUsuario == null) {
			throw new Error("Usuário não existe!");
		}
		
		return UsuarioDetails.create(existsUsuario);
	}
	
	

}
