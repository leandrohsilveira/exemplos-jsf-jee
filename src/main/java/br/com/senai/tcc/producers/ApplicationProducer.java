package br.com.senai.tcc.producers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

@ApplicationScoped
public class ApplicationProducer implements Serializable {

	private static final long serialVersionUID = 468971424482702171L;

	private String pages;

	@PostConstruct
	private void init() {
		pages = System.getProperty("dir.pages", "jee6");
	}

	@Produces
	@Named("pages")
	public String producesJeeProvider() {
		return pages;
	}

}
