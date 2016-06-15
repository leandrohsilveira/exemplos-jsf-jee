package br.com.senai.tcc.push;

import org.primefaces.push.annotation.OnMessage;
import org.primefaces.push.impl.JSONEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractPushChannel<T> implements PushChannel<T> {

	private static final Logger LOG = LoggerFactory.getLogger(AbstractPushChannel.class);

	@OnMessage(encoders = JSONEncoder.class)
	public T onMessage(T message) {
		AbstractPushChannel.LOG.info("Push Message: {}", message);
		return message;
	}

}
