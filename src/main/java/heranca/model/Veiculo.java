package heranca.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
// @MappedSuperclass ao invés de @Entity para não mapear a classe para uma tabela

@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Define uma tabela para toda hierarquia agrupando todos os atributos
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.INTEGER) // Informa o nome da coluna que diferencia os elementos filhos
// O discriminator value é definido em cada entidade filha

// @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) Define uma tabela para cada entidade concreta com seus atributos e classes herdadas
// @Inheritance(strategy = InheritanceType.JOINED) Define uma tabela para cada entidade (concreta e abstrata) apenas com seus respectivos atributos
public abstract class Veiculo implements Serializable {

	@Id
	@GeneratedValue
	private Integer id;

	private String fabricante;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

}
