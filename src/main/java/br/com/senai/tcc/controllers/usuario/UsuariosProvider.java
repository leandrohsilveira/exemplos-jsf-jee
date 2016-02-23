package br.com.senai.tcc.controllers.usuario;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.senai.tcc.dao.UsuarioDAO;
import br.com.senai.tcc.model.Usuario;

@Named
@RequestScoped
public class UsuariosProvider {

	@Inject
	private UsuarioDAO usuarioDAO;

	private List<Usuario> usuarios;

	public void initListarUsuarios() {
		usuarios = usuarioDAO.buscarTodos();
	}

	public String salvar(Usuario usuario) {
		usuarioDAO.salvar(usuario);
		return "/usuarios/lista.jsf?faces-redirect=true";
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

}
