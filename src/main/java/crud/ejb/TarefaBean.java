package crud.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import crud.model.Tarefa;

/**
 * Session Bean implementation class TarefaBean
 */
@Stateless
@LocalBean
public class TarefaBean {
	
	@PersistenceContext(unitName = "jpaDB") // Informa o nome caso haja mais de um persistenceUnit
	private EntityManager em;

    public void inserir(Tarefa tarefa) {
    	em.persist(tarefa);
    }

    public void atualizar(Tarefa tarefa) {
    	em.merge(tarefa);
    }
    
    public void excluir(Tarefa tarefa) {
    	// obtém a tarefa a ser gerenciada pela JPA
    	tarefa = carregar(tarefa.getId());
    	// remove o elemento
    	em.remove(tarefa);
    }
    
    public Tarefa carregar(int id) {
    	// Carrega passando a classe e a chave
		return em.find(Tarefa.class, id);
    }
}
