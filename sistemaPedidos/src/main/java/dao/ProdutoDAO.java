package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Produto;

public class ProdutoDAO {

	@PersistenceContext
	private EntityManager em;

	public void salvar(Produto produto) {
		em.persist(produto);
	}

	public List<Produto> listarTodos() {
		return em.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
	}

	public List<Produto> listarPorVendedor(Long vendedorId) {
		return em.createQuery("SELECT p FROM Produto p WHERE p.vendedor.id = :vendedorId", Produto.class)
				.setParameter("vendedorId", vendedorId).getResultList();
	}
}
