package jpql.bean;

import java.util.Arrays;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import jpql.ejb.QueryBean;

@Named("jpqlBean")
@RequestScoped
public class FormBean {

	@EJB
	private QueryBean queryBean;

	private String jpql;

	private String result;

	public String executar() {
		List<?> list = queryBean.executar(jpql);
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

	public String getJpql() {
		return jpql;
	}

	public void setJpql(String jpql) {
		this.jpql = jpql;
	}

	public String getResult() {
		return result;
	}

}
