package br.com.senai.tcc.producers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@SessionScoped
public class SessionProducer implements Serializable {

	private static final long serialVersionUID = 6968952530689541081L;

	private String sessionId;

	@PostConstruct
	private void init() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		sessionId = session.getId();

	}

	@Produces
	@Named("sessionId")
	public String produceSessionId() {
		return sessionId;
	}

}
