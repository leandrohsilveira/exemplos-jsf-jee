package br.com.senai.tcc.controllers;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named("olaMundo")
@RequestScoped
public class OlaMundoController implements Serializable {

	private static final long serialVersionUID = -934063998130755004L;

	@Inject
	private SessionController sessionController;

	private String nome;

	public String getNome() {
		System.out.println("Método 'getNome' chamado na fase " + FacesContext.getCurrentInstance().getCurrentPhaseId().getName());
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void mudarNome() {
		System.out.println("Mudando nome da sessão");
		sessionController.setSessionName(nome);
	}

}
