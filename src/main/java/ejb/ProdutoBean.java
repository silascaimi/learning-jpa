package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Produto;

/**
 * Session Bean implementation class ProdutoBean
 */
@Stateless
@LocalBean
public class ProdutoBean {

	@PersistenceContext
    private EntityManager em;

	public List<Produto> listar() {
		return em.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
	}
}
