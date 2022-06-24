package controleTransacional.beanManaged.bean;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import controleTransacional.beanManaged.ejb.MyBean;

@Named("bmt")
@RequestScoped
public class FormBean {
	
	@EJB
	private MyBean myBean;

	public String executar() throws Exception {
		myBean.mA();
		
		return null;
	}
}
