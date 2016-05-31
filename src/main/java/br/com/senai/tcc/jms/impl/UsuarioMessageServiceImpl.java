package br.com.senai.tcc.jms.impl;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Destination;

import br.com.senai.tcc.jms.AbstractMessageService;
import br.com.senai.tcc.jms.UsuarioMessageService;
import br.com.senai.tcc.model.Usuario;

@Stateless
public class UsuarioMessageServiceImpl extends AbstractMessageService<Usuario> implements UsuarioMessageService {

	private static final long serialVersionUID = 8449652160052952437L;

	@Resource(lookup = DESTINATION_LOOKUP)
	private Destination destination;

	@Override
	protected Destination getDestination() {
		return destination;
	}

}
