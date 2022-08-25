package br.com.metasix.mvcube.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.metasix.mvcube.entity.Usuario;

public class UsuarioDetails implements UserDetails{

	private static final long serialVersionUID = 1L;
	private String email;
	private String senha;
	private Collection<? extends GrantedAuthority> authorities;
	
	public UsuarioDetails(Usuario usuario) {
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		
		authorities = usuario.getRoles().stream().map(role ->{
			return new SimpleGrantedAuthority("ROLE_".concat(role.getNome()));
		}).collect(Collectors.toList());
		
		this.authorities = authorities;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	public static UsuarioDetails create(Usuario usuario) {
		return new UsuarioDetails(usuario);
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
