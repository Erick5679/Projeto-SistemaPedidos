package controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Produto;
import model.Usuario;
import services.ProdutoService;

@Named
@RequestScoped
public class ProdutoController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Produto produto = new Produto();
	private List<Produto> produtos;

	@Inject
	private ProdutoService produtoService;

	@Inject
	private LoginController loginController;

	public String salvar() {
		Usuario vendedor = loginController.getUsuario();
		produto.setVendedor(vendedor);
		produtoService.salvar(produto);
		return "produtos.xhtml?faces-redirect=true";
	}

	public List<Produto> getProdutos() {
		if (produtos == null) {
			produtos = produtoService.listarTodos();
		}
		return produtos;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ProdutoService getProdutoService() {
		return produtoService;
	}

	public void setProdutoService(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	public LoginController getLoginController() {
		return loginController;
	}

	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
}
