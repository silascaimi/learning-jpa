package heranca.bean;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import heranca.ejb.VeiculoBean;

@Named("formHeranca")
@RequestScoped
public class FormBean {

	@EJB
	private VeiculoBean veiculoBean;

	public VeiculoBean getVeiculoBean() {
		return veiculoBean;
	}
}
