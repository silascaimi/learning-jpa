package controleTransacional.containerManaged.ejb;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import controleTransacional.containerManaged.model.Livro;

/**
 * Session Bean implementation class MyBean
 */
@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER) // Opcional- valor padrão
public class MyBean {

	@PersistenceContext
	private EntityManager em;
	
	@Resource
	private EJBContext ejbContext;
	
	public void realizarRollback() {
		// método que realiza um rollback manual no contexto de transação
		ejbContext.setRollbackOnly();
	}
	
	// REQUIRED - usa a transação existente de quem chamou ou cria uma nova caso não exista
	// REQUIRES_NEW - cria uma nova transação
	// MANDATORY - usa a transação existente, se não existir lança uma exceção
	// NOT_SUPPORTED - a transação existente é suspensa pois não há suporte a transação
	// SUPPORTS - usa a transação existente, se não houver transação não cria
	// NEVER - se houve transação lança uma exceção
	
	// Ao lançar uma system exception o container faz um rollback da transação

	@TransactionAttribute(TransactionAttributeType.REQUIRED) // Valor padrão REQUIRED
	public void mA() {
		Livro l1 = em.find(Livro.class, 1);
		l1.setNumPaginas(100);

		Livro l2 = em.find(Livro.class, 2);
		l2.setNumPaginas(100);
	}

}
