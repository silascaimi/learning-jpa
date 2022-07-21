package controleTransacional.extendedpersistence.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.inject.Inject;
import javax.inject.Named;

import controleTransacional.extendedpersistence.ejb.ItensBean;
import controleTransacional.extendedpersistence.model.Item;

@Named("extended")
@SessionScoped
public class FormBean implements Serializable {

	@EJB
	private ItensBean itensBean;
	
	@Inject
	private ExternalContext ec;
	
	private List<Item> itens = new ArrayList<>();
	
	private Item item = new Item();
	
	public String adicionar() {
		itens.add(item);
		itensBean.adcidionarItem(item);
		item = new Item();
		return "extendedpersistence?faces-redirect=true";
	}
	
	public String remover(Item item) {
		itens.remove(item);
		itensBean.removerItem(item.getId());
		item = new Item();
		return "extendedpersistence?faces-redirect=true";
	}
	
	public String finalizar() {
		itensBean.finalizar();
		ec.invalidateSession(); // Mata a session após a conclusão
		return "extendedpersistence?faces-redirect=true";
	}
	
	public List<Item> getItens() {
		return itens;
	}
	
	public Item getItem() {
		return item;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
	
	
}
