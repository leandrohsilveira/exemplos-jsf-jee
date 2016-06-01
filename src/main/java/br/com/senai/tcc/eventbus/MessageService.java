package br.com.senai.tcc.eventbus;

import java.io.Serializable;

import br.com.senai.tcc.eventbus.events.MessageEvent;

public interface MessageService<T extends Serializable, E extends MessageEvent<T>> extends Serializable {

	void broadcast(T event);

	void subscribe(E event);

	void unsubscribe(E event);

}
