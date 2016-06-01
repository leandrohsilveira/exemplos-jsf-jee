package br.com.senai.tcc.eventbus.impl;

import javax.ejb.Stateless;

import br.com.senai.tcc.eventbus.AbstractMessageService;
import br.com.senai.tcc.eventbus.UsuarioMessageService;
import br.com.senai.tcc.eventbus.events.UsuarioMessageEvent;
import br.com.senai.tcc.model.Usuario;

@Stateless
public class UsuarioMessageServiceImpl extends AbstractMessageService<Usuario, UsuarioMessageEvent> implements UsuarioMessageService {

	private static final long serialVersionUID = 8449652160052952437L;

}
