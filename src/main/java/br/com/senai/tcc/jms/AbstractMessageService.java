package br.com.senai.tcc.jms;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSContext;

public abstract class AbstractMessageService<T extends Serializable> implements MessageService<T> {

	private static final long serialVersionUID = -3055337120590863336L;

	@Resource(lookup = "jms/ConnectionFactory")
	private JMSContext context;

	protected abstract Destination getDestination();

	@Override
	public void broadcast(T entidade) {
		context.createProducer().send(getDestination(), entidade);
	}

}
