package controleTransacional.containerManaged.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import controleTransacional.containerManaged.model.Livro;

/**
 * Session Bean implementation class MyBean
 */
@Stateless
@LocalBean
public class MyBean {

	@PersistenceContext
	private EntityManager em;
	
	public void mA() {
		Livro l1 = em.find(Livro.class, 1);
		l1.setNumPaginas(100);
		
		Livro l2 = em.find(Livro.class, 2);
		l2.setNumPaginas(100);
	}
	
}
