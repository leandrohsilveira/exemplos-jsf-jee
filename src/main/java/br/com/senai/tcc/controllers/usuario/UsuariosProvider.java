package br.com.senai.tcc.controllers.usuario;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;

import br.com.senai.tcc.dao.UsuarioDAO;
import br.com.senai.tcc.model.Usuario;

@Named
@SessionScoped
public class UsuariosProvider implements Serializable {

	private static final long serialVersionUID = 5179957765595619662L;

	@Inject
	private Logger log;

	@Inject
	private UsuarioDAO usuarioDAO;

	@Inject
	@Named("sessionId")
	private String sessionId;

	private List<Usuario> usuarios;

	@PostConstruct
	private void postConstruct() {
		log.info("Instance {} created ", this);
		init();
	}

	public void init() {
		recuperarLista();
	}

	private void recuperarLista() {
		usuarios = usuarioDAO.buscarTodos();
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

}
