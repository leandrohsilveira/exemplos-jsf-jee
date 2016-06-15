package br.com.senai.tcc.controllers;

import javax.servlet.annotation.WebServlet;

import org.primefaces.push.PushServlet;

@WebServlet(asyncSupported = true, name = "Push Servlet", urlPatterns = "/primepush/*")
public class PrimePushController extends PushServlet {

	private static final long serialVersionUID = 8090791909679187783L;

}
