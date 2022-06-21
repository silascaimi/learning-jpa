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
@TransactionManagement(TransactionManagementType.CONTAINER) // Opcional- valor padr�o
public class MyBean {

	@PersistenceContext
	private EntityManager em;
	
	@Resource
	private EJBContext ejbContext;
	
	public void realizarRollback() {
		// m�todo que realiza um rollback manual no contexto de transa��o
		ejbContext.setRollbackOnly();
	}
	
	// REQUIRED - usa a transa��o existente de quem chamou ou cria uma nova caso n�o exista
	// REQUIRES_NEW - cria uma nova transa��o
	// MANDATORY - usa a transa��o existente, se n�o existir lan�a uma exce��o
	// NOT_SUPPORTED - a transa��o existente � suspensa pois n�o h� suporte a transa��o
	// SUPPORTS - usa a transa��o existente, se n�o houver transa��o n�o cria
	// NEVER - se houve transa��o lan�a uma exce��o
	
	// Ao lan�ar uma system exception o container faz um rollback da transa��o

	@TransactionAttribute(TransactionAttributeType.REQUIRED) // Valor padr�o REQUIRED
	public void mA() {
		Livro l1 = em.find(Livro.class, 1);
		l1.setNumPaginas(100);

		Livro l2 = em.find(Livro.class, 2);
		l2.setNumPaginas(100);
	}

}
