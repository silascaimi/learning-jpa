package controleTransacional.containerManaged.bean;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import controleTransacional.containerManaged.ejb.MyBean;

@Named("cmt")
@RequestScoped
public class FormBean {
	
	@EJB
	private MyBean myBean;

	public String executar() {
		myBean.mA();
		
		return null;
	}
}
