package chavecomposta.bean;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import chavecomposta.ejb.VooBean;
import chavecomposta.model.Voo;

@Named("chaveComposta")
@RequestScoped
public class FormBean {

	@EJB
	private VooBean vooBean;
	
	public String processar() {
		
		int numero = 1266;
		String empresa = "LATAM";
		
		Voo voo = new Voo();
		voo.setNumero(numero);
		voo.setEmpresa(empresa);
		voo.setOrigem("São Paulo");
		voo.setDestino("Paris");
		
		vooBean.inserir(voo);
		
		return null;
	}
}
