package jpql.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2022-06-09T21:27:02.473-0300")
@StaticMetamodel(Aula.class)
public class Aula_ {
	public static volatile SingularAttribute<Aula, Integer> id;
	public static volatile SingularAttribute<Aula, String> nome;
	public static volatile SingularAttribute<Aula, Integer> duracao;
	public static volatile SingularAttribute<Aula, Integer> posicao;
	public static volatile SingularAttribute<Aula, Modulo> modulo;
}
