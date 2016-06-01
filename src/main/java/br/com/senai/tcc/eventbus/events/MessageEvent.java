package br.com.senai.tcc.eventbus.events;

import java.io.Serializable;

public interface MessageEvent<T extends Serializable> extends Serializable {

	void onMessage(T object);

}
