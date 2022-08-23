package br.com.metasix.mvcube.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.metasix.mvcube.entity.Usuario;

public class RequisicaoNovoUsuario {

	@NotBlank
	private String nomeCompleto;
	@NotBlank
	private String cpf;
	@NotBlank
	private String telefone;
	@NotBlank
	private String email;
	@NotBlank
	private String dataNascimento;
	@NotBlank
	private String senha;
	@NotBlank
	private String logradouro;
	@NotNull
	private Integer numero;
	private String complemento;
	@NotBlank
	private String bairro;
	@NotBlank
	private String cidade;
	@NotBlank
	private String uf;
	
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
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
	
	public Usuario toUsuario() {
		Usuario usuario = new Usuario();
		usuario.setNomeCompleto(nomeCompleto);
		usuario.setCpf(cpf);
		usuario.setTelefone(telefone);
		usuario.setEmail(email);
		usuario.setDataNascimento(dataNascimento);
		usuario.setSenha(senha);
		usuario.setLogradouro(logradouro);
		usuario.setNumero(numero);
		usuario.setComplemento(complemento);
		usuario.setBairro(bairro);
		usuario.setCidade(cidade);
		usuario.setUf(uf);
		return usuario;
	}
	
}
