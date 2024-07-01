package controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Pedido;
import model.Produto;
import model.Usuario;
import services.PedidoService;

@Named
@RequestScoped
public class PedidoController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Pedido pedido = new Pedido();
	private List<Pedido> pedidos;

	@Inject
	private PedidoService pedidoService;

	@Inject
	private LoginController loginController;

	public String realizarPedido(Produto produto) {
		Usuario comprador = loginController.getUsuario();
		pedido.setComprador(comprador);
		pedido.setProduto(produto);
		pedidoService.salvar(pedido);
		return "pedidos.xhtml?faces-redirect=true";
	}

	public List<Pedido> getPedidos() {
		if (pedidos == null) {
			pedidos = pedidoService.listarPorComprador(loginController.getUsuario().getId());
		}
		return pedidos;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public PedidoService getPedidoService() {
		return pedidoService;
	}

	public void setPedidoService(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
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

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
}
