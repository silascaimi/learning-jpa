package controleTransacional.beanManaged.bean;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import controleTransacional.beanManaged.ejb.BeanManaged;

@Named("bmt")
@RequestScoped
public class FormBean {
	
	@EJB
	private BeanManaged myBean;

	public String executar() throws Exception {
		myBean.mA();
		
		return null;
	}
}
