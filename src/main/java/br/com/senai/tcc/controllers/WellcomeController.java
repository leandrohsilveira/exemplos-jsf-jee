package br.com.senai.tcc.controllers;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/index.html" })
public class WellcomeController extends HttpServlet {

	private static final long serialVersionUID = 9151874474435966638L;

	@Inject
	@Named("pages")
	private String pagesDir;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect(String.format("%s/usuarios/lista.jsf", pagesDir));
	}

}
