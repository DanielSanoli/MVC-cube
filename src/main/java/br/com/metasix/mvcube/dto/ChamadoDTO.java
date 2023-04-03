package br.com.metasix.mvcube.dto;

import javax.validation.constraints.NotBlank;

import br.com.metasix.mvcube.entity.Chamado;

public class ChamadoDTO {

	@NotBlank
	private String titulo;
	@NotBlank
	private String descricao;

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

	
	public Chamado toChamado() {
		Chamado chamado = new Chamado();
		chamado.setTitulo(titulo);
		chamado.setDescricao(descricao);
		return chamado;
	}

}
