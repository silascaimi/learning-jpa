package heranca.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1") // Informa o valor da columa discriminator definida na entidade mãe
public class Bicicleta extends VeiculoPasseio {

	private Integer tamanhoAro;
	
	public Integer getTamanhoAro() {
		return tamanhoAro;
	}

	public void setTamanhoAro(Integer tamanhoAro) {
		this.tamanhoAro = tamanhoAro;
	}

}
