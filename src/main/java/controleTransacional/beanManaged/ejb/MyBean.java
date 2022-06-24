package controleTransacional.beanManaged.ejb;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import controleTransacional.containerManaged.model.Livro;

/**
 * Session Bean implementation class MyBean
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
@LocalBean
public class MyBean {
	
	@PersistenceContext
	private EntityManager em;
	
	@Resource
	private UserTransaction ut;

    public void mA() throws Exception {
    	
    	List<Livro> livros = em.createQuery("SELECT l FROM Livro l ORDER BY l.id", Livro.class).getResultList();
    	
    	for (Livro livro : livros) {
    		// inicia a transação
    		ut.begin();
    		
    		livro.setTitulo("???");
    		
    		// faz com que a entidade passe a ser gerenciada pela jpa
    		em.merge(livro);
    		
    		if(livro.getId() == 3) {
    			// realiza um rollback da transação
    			ut.rollback();
    			continue;
    		}
    		
    		// efetua o commit
    		ut.commit();
    	}
    }

}
