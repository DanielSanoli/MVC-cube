package br.com.metasix.mvcube.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "chamados")
@EntityListeners(AuditingEntityListener.class)
public class Chamado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String descricao;
	
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAbertura;
	private String status;
	private String tipoChamado;
	
	@ManyToOne
	private Usuario usuario;
	
	public Chamado() {
	}
	
	public Chamado(Long id, String titulo, String descricao, Date dataAbertura, String status, String tipoChamado,
			Usuario usuario) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataAbertura = dataAbertura;
		this.status = status;
		this.tipoChamado = tipoChamado;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public Date getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTipoChamado() {
		return tipoChamado;
	}
	public void setTipoChamado(String tipoChamado) {
		this.tipoChamado = tipoChamado;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
