package jpql.ejb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import jpql.model.Aula;
import jpql.model.Curso;
import jpql.model.Modulo;

/**
 * Session Bean implementation class QueryBean
 */
@Singleton
@LocalBean
@Startup
public class QueryBean {

	@PersistenceContext
	private EntityManager em;

	@PostConstruct
	public void setup() {

		Curso c1 = new Curso("JavaEE");
		em.persist(c1);

		Modulo m1c1 = new Modulo("Introdução ao JavaEE", 1, c1);
		Modulo m2c1 = new Modulo("JSF", 2, c1);
		Modulo m3c1 = new Modulo("EJB", 3, c1);
		em.persist(m1c1);
		em.persist(m2c1);
		em.persist(m3c1);

		Aula a1m1c1 = new Aula("A Plataforma", 10, 1, m1c1);
		Aula a2m1c1 = new Aula("Ambiente de Desenvolvimento", 15, 2, m1c1);
		Aula a1m2c1 = new Aula("Ciclo de Vida", 20, 1, m2c1);
		Aula a2m2c1 = new Aula("Beans JSF", 16, 2, m2c1);
		Aula a1m3c1 = new Aula("Stateless Session Beans", 10, 1, m3c1);
		Aula a2m3c1 = new Aula("Stateful Session Beans", 12, 2, m3c1);
		em.persist(a1m1c1);
		em.persist(a2m1c1);
		em.persist(a1m2c1);
		em.persist(a2m2c1);
		em.persist(a1m3c1);
		em.persist(a2m3c1);
		
		Curso c2 = new Curso("Fundamentos de Java");
		em.persist(c2);

		Modulo m1c2 = new Modulo("Introdução ao Java", 1, c2);
		Modulo m2c2 = new Modulo("Variáveis", 2, c2);
		Modulo m3c2 = new Modulo("Orientação a Objetos", 3, c2);
		em.persist(m1c2);
		em.persist(m2c2);
		em.persist(m3c2);

		Aula a1m1c2 = new Aula("A História do Java", 6, 1, m1c2);
		Aula a2m1c2 = new Aula("Características do Java", 10, 2, m1c2);
		Aula a1m2c2 = new Aula("Criação de Variáveis", 15, 1, m2c2);
		Aula a2m2c2 = new Aula("Atribuição de Valor", 12, 2, m2c2);
		Aula a1m3c2 = new Aula("Classes", 25, 1, m3c2);
		Aula a2m3c2 = new Aula("Objetos", 22, 2, m3c2);
		em.persist(a1m1c2);
		em.persist(a2m1c2);
		em.persist(a1m2c2);
		em.persist(a2m2c2);
		em.persist(a1m3c2);
		em.persist(a2m3c2);
	}
	
	private static final String TODOS_CURSOS = 
			"SELECT c "
			+ "FROM Curso c";
	
	private static final String TODAS_AULAS_NOME = 
			"SELECT a.nome "
			+ "FROM Aula a";
	
	private static final String TODAS_AULAS_NOME_DURACAO = 
			"SELECT a.nome, a.duracao "
			+ "FROM Aula a";
	
	private static final String TODAS_AULAS_NOME_DURACAO_DESC = 
			"SELECT a.nome, a.duracao "
			+ "FROM Aula a "
			+ "ORDER BY a.duracao DESC";
	
	private static final String SOMA_DURACAO_AULAS = 
			"SELECT SUM(a.duracao) "
			+ "FROM Aula a";
	
	private static final String DURACAO_AULA_POR_MODULO = 
			"SELECT m.nome, SUM(a.duracao) "
			+ "FROM Aula a "
			+ "JOIN a.modulo m "
			+ "GROUP BY m.nome";
	
	// Partindo de modulo que possui atributo curso
	private static final String MODULOS_CURSO_1 = 
			"SELECT m "
			+ "FROM Modulo m "
			+ "WHERE m.curso.id = 1 "
			+ "ORDER BY m.posicao";
	
	// Partindo de curso que possui uma lista de modulos
	private static final String MODULOS_CURSO_1_2 = 
			"SELECT m "
			+ "FROM Curso c "
			+ "JOIN c.modulos m "
			+ "WHERE c.id = 1";
	
	private static final String CURSO_MODULO_AULA = 
			"SELECT c.nome, m.nome, a.nome "
			+ "FROM Curso c "
			+ "JOIN c.modulos m "
			+ "JOIN m.aulas a "
			+ "ORDER BY m.posicao, a.posicao";

	public List<?> executar(String jpql) {
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}

}
