package controleTransacional.beanManaged.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import controleTransacional.containerManaged.model.Livro;

/**
 * Session Bean implementation class DBSetupBean
 */
@Singleton
@LocalBean
@Startup
public class DBSetupBeanManaged {

    @PersistenceContext
    private EntityManager em;
    
    @PostConstruct
    public void setup() {
    	Livro l1 = new Livro();
    	l1.setId(3);
    	l1.setTitulo("Java2");
    	l1.setNumPaginas(260);
    	em.persist(l1);
    	
    	Livro l2 = new Livro();
    	l2.setId(4);
    	l2.setTitulo("Expressões Lambda");
    	l2.setNumPaginas(160);
    	em.persist(l2);
    }

}
