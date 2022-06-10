package criteriaapi.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import criteriaapi.ejb.CriteriaQueryBean;


@Named("criteria")
@RequestScoped
public class FormBean implements Serializable {

	@EJB
	private CriteriaQueryBean criteriaQueryBean;
	
	private Integer opcao;
	
	private String result;
	
	public String executar() {
		
		List<?> list = null;
		
		switch(opcao) {
			case 1: list = criteriaQueryBean.executar1(); break;
			case 2: list = criteriaQueryBean.executar2(); break;
			case 3: list = criteriaQueryBean.executar3(); break;
			case 4: list = criteriaQueryBean.executar4(); break;
		}
		
		buildResult(list);
		return null;
	}
	
	private void buildResult(List<?> list) {
		result = "";
		list.forEach(i -> {
			if (i instanceof Object[]) {
				result += Arrays.toString((Object[]) i) + "\n";
			} else {
				result += i + "\n";
			}
		});
	}
	
	public String getResult() {
		return result;
	}
	
	public Integer getOpcao() {
		return opcao;
	}
	
	public void setOpcao(Integer opcao) {
		this.opcao = opcao;
	}
}
