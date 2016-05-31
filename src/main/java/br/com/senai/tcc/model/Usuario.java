package br.com.senai.tcc.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 1064048757496573495L;

	private Long id;

	private String nome;

	@NotNull
	private String login;

	@NotNull
	private String senha;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
