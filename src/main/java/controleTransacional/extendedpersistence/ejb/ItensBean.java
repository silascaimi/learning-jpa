package controleTransacional.extendedpersistence.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import controleTransacional.extendedpersistence.model.Item;

/**
 * Session Bean implementation class ItensBean
 */
@Stateful
@LocalBean
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class ItensBean {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager em;
	
	public void adcidionarItem(Item item) {
		em.persist(item);
	}
	
	public void removerItem(int itemId) {
		Item item = em.find(Item.class, itemId);
		em.remove(item);
	}
	
	// Excluio o EJB para efetivar as mudan�ar no banco
	// Tudo que foi armazenado pela jpa � armazenado
	@Remove
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void finalizar() {
		System.out.println("Commit realizado");
	}

}
