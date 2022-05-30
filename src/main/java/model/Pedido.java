package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
	
	private Integer id;
	
	private Double valorTotal;
	
	private Date data;
	
	private Pagamento pagamento;
	
	private Cliente cliente;
	
	private List<Produto> produtos = new ArrayList<Produto>();
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", valorTotal=" + valorTotal + ", data=" + data + "]";
	}
	
	
	
}
