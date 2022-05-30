package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Pedido;

/**
 * Session Bean implementation class PedidoBean
 */
@Stateless
@LocalBean
public class PedidoBean {

	@PersistenceContext
	private EntityManager em;
	
	public List<Pedido> listar() {
		return em.createQuery("SELECT p FROM Pedido p", Pedido.class).getResultList();
	}
	
	public void pagar(Integer pedidoId, String tipo) {
		
	}
	
	public void excluir(Integer peidoId) {
		
	}
	
	public void cadastrar(Integer clienteId, Integer[] produtosIds) throws Exception {
		
	}

}
