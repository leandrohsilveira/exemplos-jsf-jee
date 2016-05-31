package br.com.senai.tcc.controllers.usuario;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jms.Message;
import javax.jms.MessageListener;

import br.com.senai.tcc.dao.UsuarioDAO;
import br.com.senai.tcc.jms.MessageService;
import br.com.senai.tcc.jms.UsuarioMessageService;
import br.com.senai.tcc.model.Usuario;

@Named
@ViewScoped
@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = MessageService.QUEUE_LOOKUP),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = UsuarioMessageService.DESTINATION_LOOKUP) })
public class UsuariosProvider implements Serializable, MessageListener {

	private static final long serialVersionUID = 5179957765595619662L;

	@Inject
	private UsuarioDAO usuarioDAO;

	private List<Usuario> usuarios;

	@PostConstruct
	public void initListarUsuarios() {
		usuarios = usuarioDAO.buscarTodos();
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	@Override
	public void onMessage(Message message) {
		initListarUsuarios();
	}

}
