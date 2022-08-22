package br.com.metasix.mvcube.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.metasix.mvcube.dto.RoleDTO;
import br.com.metasix.mvcube.entity.Usuario;
import br.com.metasix.mvcube.entity.Role;
import br.com.metasix.mvcube.repository.UsuarioRepository;

public class RoleService {

	@Autowired
	UsuarioRepository UsuarioRepository;

	public Usuario execute(RoleDTO roleDTO) {

		Optional<Usuario> usuarioExists = UsuarioRepository.findById(roleDTO.getIdUsuario());
		List<Role> roles = new ArrayList<>();

		if (usuarioExists.isEmpty()) {
			throw new Error("Usuário não existe!");
		}

		roles = roleDTO.getIdsRoles().stream().map(role -> {
			return new Role(role);
		}).collect(Collectors.toList());

		Usuario usuario = usuarioExists.get();

		usuario.setRoles(roles);

		UsuarioRepository.save(usuario);

		return usuario;

	}
}
