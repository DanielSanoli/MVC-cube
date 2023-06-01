package br.com.metasix.mvcube.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.metasix.mvcube.entity.Chamado;
import br.com.metasix.mvcube.entity.Usuario;
import br.com.metasix.mvcube.enums.StatusChamado;
import br.com.metasix.mvcube.enums.TipoChamado;

public class ChamadoDTO {

	@NotBlank
	private String titulo;
	@NotBlank
	private String descricao;
	@NotNull
	private TipoChamado tipoChamado;
	
	private StatusChamado statusChamado;
	
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
	
	public TipoChamado getTipoChamado() {
		return tipoChamado;
	}

	public void setTipoChamado(TipoChamado tipoChamado) {
		this.tipoChamado = tipoChamado;
	}
	
	public StatusChamado getStatusChamado() {
		return statusChamado;
	}

	public void setStatusChamado(StatusChamado statusChamado) {
		this.statusChamado = statusChamado;
	}

	public Chamado toChamado(Usuario usuario) {
		Chamado chamado = new Chamado();
		chamado.setTitulo(titulo);
		chamado.setDescricao(descricao);
		chamado.setUsuario(usuario);
		chamado.setTipoChamado(tipoChamado);
		chamado.setStatus(StatusChamado.ABERTO);
		return chamado;
	}

}
