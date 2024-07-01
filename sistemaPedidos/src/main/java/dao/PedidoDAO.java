package dao;

import model.Pedido;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class PedidoDAO {

    @PersistenceContext
    private EntityManager em;

    public void salvar(Pedido pedido) {
        em.persist(pedido);
    }

    public List<Pedido> listarPorComprador(Long compradorId) {
        return em.createQuery("SELECT p FROM Pedido p WHERE p.comprador.id = :compradorId", Pedido.class)
                .setParameter("compradorId", compradorId)
                .getResultList();
    }

    public List<Pedido> listarPorVendedor(Long vendedorId) {
        return em.createQuery("SELECT p FROM Pedido p WHERE p.produto.vendedor.id = :vendedorId", Pedido.class)
                .setParameter("vendedorId", vendedorId)
                .getResultList();
    }
}

