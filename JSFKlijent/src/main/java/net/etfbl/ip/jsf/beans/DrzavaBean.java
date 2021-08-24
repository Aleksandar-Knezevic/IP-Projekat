package net.etfbl.ip.jsf.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import net.etfbl.ip.jsf.dao.DrzavaDAO;
import net.etfbl.ip.jsp.dto.Drzava;

@ManagedBean(name = "drzaveBean")
@SessionScoped
public class DrzavaBean implements Serializable {

	private static final long serialVersionUID = 7183047544446152L;
	
	private Drzava drzava = new Drzava();
	private ArrayList<Drzava> sveDrzave = new ArrayList<Drzava>();

	public DrzavaBean() {
		
	}
	




	public Drzava getDrzava() {
		return drzava;
	}

	public void setDrzava(Drzava drzava) {
		this.drzava = drzava;
	}

	public ArrayList<Drzava> getSveDrzave() {
		return sveDrzave;
	}

	public void setSveDrzave(ArrayList<Drzava> sveDrzave) {
		this.sveDrzave = sveDrzave;
	}
	
	public String ocitajDrzaveizBaze()
	{
		try
		{
			sveDrzave = DrzavaDAO.selectAll();
		}
		catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		
		return "drzave.xhtml?faces-redirect=true";
	}
	
	public String obrisiDrzavu()
	{
		try
		{
			Map<String, String> reqMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			if (reqMap.containsKey("id")) {
				int z = Integer.parseInt(reqMap.get("id"));
				for (Drzava d : sveDrzave) {
					if (d.getId() == z) {
						sveDrzave.remove(d);
						DrzavaDAO.obrisiDrzavu(d.getId());
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
	
	public String dodajDrzavu()
	{
		try
		{
				DrzavaDAO.insert(drzava.getNazivDrzave());
				drzava = new Drzava();
			
		}
		catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return "drzave.xhtml?faces-redirect=true";
	}
	
	public String novaDrzava()
	{
		return "nova_drzava.xhtml?faces-redirect=true";
	}
	
	
	public String azurirajDrzavuPage()
	{
		Map<String, String> reqMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		if (reqMap.containsKey("id")) 
		{
			int z = Integer.parseInt(reqMap.get("id"));
			for (Drzava d : sveDrzave)
			{
				if (d.getId() == z) 
				{
					drzava = d;
					break;
				}
			}
		}

		return "azuriraj_drzavu.xhtml?faces-redirect=true";
	}
	
	public String azurirajDrzavu()
	{
		try
		{
			DrzavaDAO.update(drzava);
			drzava = new Drzava();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return "drzave.xhtml?faces-redirect=true";
	}

}
