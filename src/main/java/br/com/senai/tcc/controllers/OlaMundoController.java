package br.com.senai.tcc.controllers;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("olaMundo")
@RequestScoped
public class OlaMundoController implements Serializable {

	private static final long serialVersionUID = -934063998130755004L;

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
