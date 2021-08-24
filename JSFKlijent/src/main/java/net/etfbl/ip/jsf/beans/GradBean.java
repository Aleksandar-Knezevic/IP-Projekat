package net.etfbl.ip.jsf.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import net.etfbl.ip.jsf.dao.GradDAO;
import net.etfbl.ip.jsp.dto.Grad;

@ManagedBean(name = "gradoviBean")
@SessionScoped
public class GradBean implements Serializable {

	private static final long serialVersionUID = -907217122387175172L;
	
	private Grad grad = new Grad();
	private ArrayList<Grad> sviGradovi = new ArrayList<Grad>();
	private String selectedDrzava;

	public GradBean() {
		
	}
	

	public String getSelectedDrzava() {
		return selectedDrzava;
	}


	public void setSelectedDrzava(String selectedDrzava) {
		this.selectedDrzava = selectedDrzava;
	}


	public Grad getGrad() {
		return grad;
	}

	public void setGrad(Grad grad) {
		this.grad = grad;
	}

	public ArrayList<Grad> getSviGradovi() {
		return sviGradovi;
	}

	public void setSviGradovi(ArrayList<Grad> sviGradovi) {
		this.sviGradovi = sviGradovi;
	}
	
	public String ocitajGradoveIzBaze()
	{
		try
		{
			sviGradovi = GradDAO.selectAll();
		}
		catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return "gradovi.xhtml?faces-redirect=true";
	}
	
	public String noviGrad()
	{
		return "novi_grad.xhtml?faces-redirect=true";
	}
	
	public String dodajGrad()
	{
		try
		{
			GradDAO.insert(grad.getNazivGrada(), Integer.parseInt(selectedDrzava));
		}
		catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return "gradovi.xhtml?faces-redirect=true";
	}
	
	public String obrisiGrad()
	{
		try
		{
			Map<String, String> reqMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			if (reqMap.containsKey("id")) {
				int z = Integer.parseInt(reqMap.get("id"));
				for (Grad g : sviGradovi) {
					if (g.getId() == z) {
						sviGradovi.remove(g);
						GradDAO.delete(g.getId());
						break;
					}
				}
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return null;
	}
	
	public String azurirajGradPage()
	{
		try
		{
			Map<String, String> reqMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			if (reqMap.containsKey("id")) {
				int z = Integer.parseInt(reqMap.get("id"));
				for (Grad g : sviGradovi) {
					if (g.getId() == z) {
						grad = g;
						break;
					}
				}
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return "azuriraj_grad.xhtml?faces-redirect=true";
	}
	
	public String azurirajGrad()
	{
		try
		{
			
			GradDAO.update(grad.getNazivGrada(), Integer.parseInt(selectedDrzava), grad.getId());
			grad= new Grad();
		}
		catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return "gradovi.xhtml?faces-redirect=true";
	}

}
