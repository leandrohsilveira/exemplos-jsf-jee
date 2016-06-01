package br.com.senai.tcc.eventbus;

import br.com.senai.tcc.eventbus.events.UsuarioMessageEvent;
import br.com.senai.tcc.model.Usuario;

public interface UsuarioMessageService extends MessageService<Usuario, UsuarioMessageEvent> {

}
