package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Pagamento implements Serializable {

	public enum TipoPagamento {
		CARTAO_CREDITO, BOLETO;
	}

	@Id
	@GeneratedValue
	private Integer id;

	@Enumerated(EnumType.STRING) // Utiliza na tabela o texto do enum
	@Column(name = "tipo_pagto", length = 20, nullable = false)
	private TipoPagamento tipoPagamento;

	@OneToOne(mappedBy = "pagamento")
	private Pedido pedido;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public String toString() {
		return "Pagamento [id=" + id + ", tipoPagamento=" + tipoPagamento + "]";
	}
}
