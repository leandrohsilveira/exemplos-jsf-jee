package br.com.senai.tcc.controllers.usuario;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;

import br.com.senai.tcc.dao.UsuarioDAO;
import br.com.senai.tcc.eventbus.UsuarioMessageService;
import br.com.senai.tcc.eventbus.events.UsuarioMessageEvent;
import br.com.senai.tcc.model.Usuario;

import com.google.common.eventbus.Subscribe;

@Named
@SessionScoped
public class UsuariosProvider implements Serializable, UsuarioMessageEvent {

	private static final long serialVersionUID = 5179957765595619662L;

	@Inject
	private Logger log;

	@Inject
	private UsuarioDAO usuarioDAO;

	@Inject
	private UsuarioMessageService usuarioMessageService;

	private List<Usuario> usuarios;

	@PostConstruct
	private void postConstruct() {
		log.info("Instance {} created ", this);
		init();
	}

	public void init() {
		recuperarLista();
		usuarioMessageService.subscribe(this);
	}

	private void recuperarLista() {
		usuarios = usuarioDAO.buscarTodos();
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	@Subscribe
	@Override
	public void onMessage(Usuario object) {
		log.info("Mensagem de evento capturada pelo listener {} para sessão {}", this, FacesContext.getCurrentInstance().getExternalContext().getSessionId(false));
		recuperarLista();
	}

	@PreDestroy
	private void preDestroy() {
		log.info("Instance {} id about to be destroyed.", this);
		usuarioMessageService.unsubscribe(this);
	}

}
