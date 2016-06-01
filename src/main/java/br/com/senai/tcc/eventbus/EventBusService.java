package br.com.senai.tcc.eventbus;

import java.io.Serializable;

import com.google.common.eventbus.EventBus;

public interface EventBusService extends Serializable {

	EventBus getEventBus();

}
