package br.com.senai.tcc.dao.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.inject.Singleton;

import org.slf4j.Logger;

import br.com.senai.tcc.dao.UsuarioDAO;
import br.com.senai.tcc.eventbus.UsuarioMessageService;
import br.com.senai.tcc.model.Usuario;

@Stateful
@Singleton
public class MemUsuarioDAOImpl implements UsuarioDAO {

	/**
	 *
	 */
	private static final long serialVersionUID = -8550555529366657788L;

	private Long sequence = 1l;
	private Map<Long, Usuario> usuarios;

	@Inject
	private Logger log;

	@Inject
	private UsuarioMessageService messageService;

	@PostConstruct
	private void init() {
		System.out.println("MemUsuarioDAOImpl init()");
		usuarios = new LinkedHashMap<Long, Usuario>();
	}

	@Override
	public void salvar(Usuario u) {
		if (u.getId() == null) {
			u.setId(sequence);
			sequence = sequence + 1;
		}
		usuarios.put(u.getId(), u);
		log.info("{} com id {} persistido.", u.getClass().getSimpleName(), u.getId());
		messageService.broadcast(u);
	}

	@Override
	public Usuario getPorId(Long id) {
		return usuarios.get(id);
	}

	@Override
	public Usuario getPorLogin(String login) {
		for (Entry<Long, Usuario> entry : usuarios.entrySet()) {
			Usuario usuario = entry.getValue();
			if (usuario.getLogin().equals(login)) {
				return usuario;
			}
		}
		return null;
	}

	@Override
	public Usuario getPorLoginSenha(String login, String senha) {
		for (Entry<Long, Usuario> entry : usuarios.entrySet()) {
			Usuario usuario = entry.getValue();
			if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
				return usuario;
			}
		}
		return null;
	}

	@Override
	public List<Usuario> buscarTodos() {
		List<Usuario> lista = new ArrayList<Usuario>();
		for (Entry<Long, Usuario> entry : usuarios.entrySet()) {
			lista.add(entry.getValue());
		}
		return lista;
	}

}
