package relacionamentos.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import relacionamentos.model.Cliente;

/**
 * Session Bean implementation class ClienteBean
 */
@Stateless
@LocalBean
public class ClienteBean {

	@PersistenceContext
	private EntityManager em;

	public List<Cliente> listar() {
		return em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
	}
}
