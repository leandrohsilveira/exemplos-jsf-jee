package br.com.senai.tcc.controllers.usuario;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import br.com.senai.tcc.dao.UsuarioDAO;
import br.com.senai.tcc.model.Usuario;

@Named
@RequestScoped
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = 5431965786582636753L;

	private Long id;

	@Inject
	private UsuarioDAO usuarioDAO;

	@NotNull
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public void carregarUsuario() {
		Usuario usuario = usuarioDAO.getPorId(getId());
		if (usuario != null) {
			setId(usuario.getId());
			setLogin(usuario.getLogin());
			setNome(usuario.getNome());
		}
	}

	public Usuario get() {
		Usuario usuario = new Usuario();
		usuario.setId(getId());
		usuario.setNome(getNome());
		usuario.setLogin(getLogin());
		usuario.setSenha(getSenha());
		return usuario;
	}

	public String salvar(Usuario usuario) {
		usuarioDAO.salvar(get());
		return "/usuarios/lista.jsf?faces-redirect=true";
	}

}
