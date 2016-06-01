package br.com.senai.tcc.eventbus;

import java.io.Serializable;

import javax.inject.Inject;

import org.slf4j.Logger;

import br.com.senai.tcc.eventbus.events.MessageEvent;

public abstract class AbstractMessageService<T extends Serializable, E extends MessageEvent<T>> implements MessageService<T, E> {

	private static final long serialVersionUID = -3055337120590863336L;

	@Inject
	private Logger log;

	@Inject
	private EventBusService eventBusService;

	@Override
	public void broadcast(T object) {
		eventBusService.getEventBus().post(object);
	}

	@Override
	public void subscribe(E event) {
		eventBusService.getEventBus().register(event);
		log.info("Event subscribed {}.", event);
	}

	@Override
	public void unsubscribe(E event) {
		try {
			eventBusService.getEventBus().unregister(event);
			log.info("Event unsubscribed {}.", event);
		} catch (IllegalArgumentException | NullPointerException e) {
			// object not subscribed.
		}
	}

}
