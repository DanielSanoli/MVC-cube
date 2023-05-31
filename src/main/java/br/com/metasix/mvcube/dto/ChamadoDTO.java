package br.com.metasix.mvcube.dto;

import javax.validation.constraints.NotBlank;

import br.com.metasix.mvcube.entity.Chamado;
import br.com.metasix.mvcube.entity.Usuario;

public class ChamadoDTO {

	@NotBlank
	private String titulo;
	@NotBlank
	private String descricao;
	
	private Long idUsuario;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Chamado toChamado(Usuario usuario) {
		Chamado chamado = new Chamado();
		chamado.setTitulo(titulo);
		chamado.setDescricao(descricao);
		chamado.setUsuario(usuario);
		return chamado;
	}

}
