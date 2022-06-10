package crud.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2022-06-09T21:27:02.468-0300")
@StaticMetamodel(Tarefa.class)
public class Tarefa_ {
	public static volatile SingularAttribute<Tarefa, Integer> id;
	public static volatile SingularAttribute<Tarefa, String> descricao;
	public static volatile SingularAttribute<Tarefa, Integer> prioridade;
	public static volatile SingularAttribute<Tarefa, Boolean> concluida;
}
