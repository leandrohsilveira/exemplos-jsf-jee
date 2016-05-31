package br.com.senai.tcc.jms;

import br.com.senai.tcc.model.Usuario;

public interface UsuarioMessageService extends MessageService<Usuario> {

	public static final String DESTINATION_LOOKUP = "entidades/broadcast/usuario";

}
