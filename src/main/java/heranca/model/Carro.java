package heranca.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2") // Informa o valor da columa discriminator definida na entidade mãe
public class Carro extends VeiculoPasseio {

	private Integer qtdePortas;

	public Integer getQtdePortas() {
		return qtdePortas;
	}

	public void setQtdePortas(Integer qtdePortas) {
		this.qtdePortas = qtdePortas;
	}

}
