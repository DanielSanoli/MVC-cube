package br.com.metasix.mvcube.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeCompleto;
	private String email;
	private String senha;
	private String cpf;
	private String dataNascimento;
	private String telefone;
	private String logradouro;
	private String cidade;
	private String uf;
	private Integer numero;
	private String complemento;
	private String bairro;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Role> roles;
	
	@OneToMany
	private List<Chamado> chamado;
	
	public Usuario() {
	}
	
	public Usuario(Long id, String nomeCompleto, String email, String senha, String cpf, String dataNascimento, String telefone,
			String logradouro, String cidade, String uf, Integer numero, String complemento, String bairro, List<Role> roles, List<Chamado> chamado) {
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.email = email;
		this.senha = senha;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.logradouro = logradouro;
		this.cidade = cidade;
		this.uf = uf;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.roles = roles;
		this.chamado = chamado;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Integer getNumero() {
		return numero;
	}
	
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public String getComplemento() {
		return complemento;
	}
	
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Chamado> getChamado() {
		return chamado;
	}

	public void setChamado(List<Chamado> chamado) {
		this.chamado = chamado;
	}
}
