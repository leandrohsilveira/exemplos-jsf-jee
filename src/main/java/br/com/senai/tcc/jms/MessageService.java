package br.com.senai.tcc.jms;

import java.io.Serializable;

public interface MessageService<T extends Serializable> extends Serializable {

	public static final String QUEUE_LOOKUP = "javax.jms.Queue";

	void broadcast(T entidade);

}
