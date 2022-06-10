package chavecomposta.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import chavecomposta.model.Voo;
import chavecomposta.model.VooPK;

/**
 * Session Bean implementation class VooBean
 */
@Stateless
@LocalBean
public class VooBean {

	@PersistenceContext
	private EntityManager em;
	
	public void inserir(Voo voo) {
		em.persist(voo);
	}

	public Voo carregar(Integer numero, String empresa) {
		return em.find(Voo.class, new VooPK(numero, empresa));
	}
}
