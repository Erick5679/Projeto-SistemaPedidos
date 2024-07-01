package services;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import dao.ProdutoDAO;
import model.Produto;

@SuppressWarnings("deprecation")
@RequestScoped
public class ProdutoService {

	@Inject
	private ProdutoDAO produtoDAO;

	public void salvar(Produto produto) {
		produtoDAO.salvar(produto);
	}

	public List<Produto> listarTodos() {
		return produtoDAO.listarTodos();
	}

	public List<Produto> listarPorVendedor(Long vendedorId) {
		return produtoDAO.listarPorVendedor(vendedorId);
	}
}
