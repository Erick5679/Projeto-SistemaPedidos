package services;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import dao.UsuarioDAO;
import model.Usuario;

@SuppressWarnings("deprecation")
@RequestScoped
public class UsuarioService {

	@Inject
	private UsuarioDAO usuarioDAO;

	public void salvar(Usuario usuario) {
		usuarioDAO.salvar(usuario);
	}

	public Usuario buscarPorEmailSenha(String email, String senha) {
		return usuarioDAO.buscarPorEmailSenha(email, senha);
	}

	public List<Usuario> listarTodos() {
		return usuarioDAO.listarTodos();
	}
}
