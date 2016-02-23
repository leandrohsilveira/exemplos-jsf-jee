package br.com.senai.tcc.controllers;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("sessionController")
@SessionScoped
public class SessionController implements Serializable {

	private static final long serialVersionUID = 4931713009915255764L;

	private String sessionName;

	public String getSessionName() {
		return sessionName;
	}

	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}

}
