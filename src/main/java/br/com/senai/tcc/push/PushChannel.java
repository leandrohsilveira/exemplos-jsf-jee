package br.com.senai.tcc.push;

public interface PushChannel<T> {

	void publish(T object);

}
