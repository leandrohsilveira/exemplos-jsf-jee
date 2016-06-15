package br.com.senai.tcc.push.impl;

import org.primefaces.push.EventBusFactory;
import org.primefaces.push.annotation.PushEndpoint;

import br.com.senai.tcc.model.Usuario;
import br.com.senai.tcc.push.AbstractPushChannel;
import br.com.senai.tcc.push.UsuarioPushChannel;

@PushEndpoint("/usuario")
public class UsuarioPushChannelImpl extends AbstractPushChannel<Usuario> implements UsuarioPushChannel {

	@Override
	public void publish(Usuario object) {
		EventBusFactory.getDefault().eventBus().publish("/usuario", object);
	}

}
