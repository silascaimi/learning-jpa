package relacionamentos.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import relacionamentos.model.Pagamento.TipoPagamento;

@Generated(value="Dali", date="2022-06-09T21:27:02.476-0300")
@StaticMetamodel(Pagamento.class)
public class Pagamento_ {
	public static volatile SingularAttribute<Pagamento, Integer> id;
	public static volatile SingularAttribute<Pagamento, TipoPagamento> tipoPagamento;
	public static volatile SingularAttribute<Pagamento, Pedido> pedido;
}
