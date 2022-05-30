package model;

public class Pagamento {
	public enum TipoPagamento{
		CARTAO_CREDITO,
		BOLETO;
	}

	private Integer id;
	
	private TipoPagamento tipoPagamento;
	
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
