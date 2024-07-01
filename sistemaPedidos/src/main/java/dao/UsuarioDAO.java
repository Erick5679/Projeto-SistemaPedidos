package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Usuario;

public class UsuarioDAO {

	@PersistenceContext
	private EntityManager em;

	public void salvar(Usuario usuario) {
		em.persist(usuario);
	}

	public Usuario buscarPorEmailSenha(String email, String senha) {
		try {
			return em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha", Usuario.class)
					.setParameter("email", email).setParameter("senha", senha).getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	public List<Usuario> listarTodos() {
		return em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
	}
}
