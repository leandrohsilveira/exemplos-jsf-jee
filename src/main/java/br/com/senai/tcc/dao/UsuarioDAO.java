package br.com.senai.tcc.dao;

import java.io.Serializable;
import java.util.List;

import br.com.senai.tcc.model.Usuario;

public interface UsuarioDAO extends Serializable {

	void salvar(Usuario usuario);

	Usuario getPorId(Long id);

	Usuario getPorLogin(String login);

	Usuario getPorLoginSenha(String login, String senha);

	List<Usuario> buscarTodos();

}
