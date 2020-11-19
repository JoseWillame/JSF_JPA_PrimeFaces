package entidade;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import dao.LocalDao;

@ManagedBean
public class LocalBea {
	private Local local = new Local();
	private List<Local> lista;
	
	public String salvar() {
		LocalDao.salvar(local);
		local = new Local();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Endereço salvo com sucesso."));
		return null;
	}
	
	
	public Local getLocal() {
		return local;
	}
	public void setLocal(Local local) {
		this.local = local;
	}
	public List<Local> getLista() {
		if(lista == null) {
			lista = LocalDao.listar();			
		}
		return lista;
	}
	public void setLista(List<Local> lista) {
		this.lista = lista;
	}

}
