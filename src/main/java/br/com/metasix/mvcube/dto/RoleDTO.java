package br.com.metasix.mvcube.dto;

import java.util.List;

public class RoleDTO {

	 private Long idUsuario;

	 private List<Long> idsRoles;

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public List<Long> getIdsRoles() {
		return idsRoles;
	}

	public void setIdsRoles(List<Long> idsRoles) {
		this.idsRoles = idsRoles;
	}
	 
}
