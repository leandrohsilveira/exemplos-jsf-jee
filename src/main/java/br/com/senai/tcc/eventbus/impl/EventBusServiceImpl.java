package br.com.senai.tcc.eventbus.impl;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import br.com.senai.tcc.eventbus.EventBusService;

import com.google.common.eventbus.EventBus;

@Singleton
public class EventBusServiceImpl implements EventBusService {

	private static final long serialVersionUID = 1927337685183754422L;

	private EventBus eventBus;

	@PostConstruct
	private void init() {
		eventBus = new EventBus();
	}

	@Override
	public EventBus getEventBus() {
		return eventBus;
	}

}
