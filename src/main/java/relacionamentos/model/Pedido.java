package relacionamentos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pedido implements Serializable {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "valor_total")
	private Double valorTotal;

	// @Temporal(TemporalType.TIME) Hora
	// @Temporal(TemporalType.TIMESTAMP) Data e hora
	@Temporal(TemporalType.DATE) // Data
	@Column(nullable = false)
	private Date data;

	@OneToOne
	@JoinColumn(name = "pagamento_id") // coluna na tabela pedido que ser? FK
	private Pagamento pagamento;

	// Lado Many ? o dono do relacionamento, possui a FK e acompanha @joincolumn
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	// Chave estrangeira fica na tabela de associa??o
	// O dono do relacionamento e configura??o fica a crit?rio
	@ManyToMany(fetch = FetchType.EAGER) // Carrega os dados da tabela previamente
	@JoinTable(name = "pedido_produto",
		joinColumns = @JoinColumn(name = "pedido_id"),
		inverseJoinColumns = @JoinColumn(name = "produto_id"))
	private List<Produto> produtos = new ArrayList<Produto>();
	
	// @OneToOne e @ManyToOne usam EAGER
	// @OneToMany e @ManyToMany usam LAZY

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
