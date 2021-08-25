package net.etfbl.ip.jsf.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import net.etfbl.ip.jsf.dao.AdministratorDAO;
import net.etfbl.ip.jsp.dto.Administrator;

@ManagedBean(name = "userBean")
@RequestScoped
public class UserBean implements Serializable {



	private static final long serialVersionUID = -3518097095125933016L;
	private Administrator admin = new Administrator();
	
	
	public Administrator getAdmin() {
		return admin;
	}


	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}


	public UserBean() {
		
	}
	
	public String login()
	{
		try
		{
			Administrator user = AdministratorDAO.login(admin.getKorisnickoIme(), admin.getLozinka());
			FacesContext context = FacesContext.getCurrentInstance();
			if(user!=null)
			{
				context.getExternalContext().getSessionMap().put("user", user);
				return "index.xhtml?faces-redirect=true";
			}
			else
			{
				context.addMessage(null, new FacesMessage("Unknown login, try again."));
		        return null;
			}
		}
		catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return null;
	}
	
	public String logout()
	{
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", null);
		admin=new Administrator();
		return "login.xhtml?faces-redirect=true";
	}

}
