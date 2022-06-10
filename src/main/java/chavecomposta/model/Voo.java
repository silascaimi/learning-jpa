package chavecomposta.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Voo
 *
 */
@Entity

@IdClass(VooPK.class) // Informa qual classe representa a chave composta
public class Voo implements Serializable {

	@Id
	private Integer numero;
	@Id
	private String empresa;

	private String origem;
	private String destino;
	private static final long serialVersionUID = 1L;

	public Voo() {
		super();
	}

	public Integer getNumero() {
		return this.numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getDestino() {
		return this.destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getOrigem() {
		return this.origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	@Override
	public String toString() {
		return "Voo [numero=" + numero + ", empresa=" + empresa + ", destino=" + destino + "]";
	}

}
