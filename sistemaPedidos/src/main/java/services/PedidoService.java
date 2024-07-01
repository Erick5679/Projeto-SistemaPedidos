package services;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import dao.PedidoDAO;
import model.Pedido;

@SuppressWarnings("deprecation")
@RequestScoped
public class PedidoService {

	@Inject
	private PedidoDAO pedidoDAO;

	public void salvar(Pedido pedido) {
		pedidoDAO.salvar(pedido);
	}

	public List<Pedido> listarPorComprador(Long compradorId) {
		return pedidoDAO.listarPorComprador(compradorId);
	}

	public List<Pedido> listarPorVendedor(Long vendedorId) {
		return pedidoDAO.listarPorVendedor(vendedorId);
	}
}
