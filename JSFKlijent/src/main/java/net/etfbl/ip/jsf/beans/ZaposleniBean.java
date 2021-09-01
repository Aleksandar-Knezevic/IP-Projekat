package net.etfbl.ip.jsf.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import net.etfbl.ip.jsf.dao.ZaposleniDAO;
import net.etfbl.ip.jsp.dto.Zaposleni;

@ManagedBean(name = "zaposleniBean")
@SessionScoped
public class ZaposleniBean implements Serializable {


	private static final long serialVersionUID = 624728777973754282L;
	private Zaposleni zaposleni = new Zaposleni();
	private ArrayList<Zaposleni> sviZaposleni = new ArrayList<Zaposleni>();
	public ZaposleniBean() {
	}
	public Zaposleni getZaposleni() {
		return zaposleni;
	}
	public void setZaposleni(Zaposleni zaposleni) {
		this.zaposleni = zaposleni;
	}
	public ArrayList<Zaposleni> getSviZaposleni() {
		return sviZaposleni;
	}
	public void setSviZaposleni(ArrayList<Zaposleni> sviZaposleni) {
		this.sviZaposleni = sviZaposleni;
	}
	
	
	public String ocitajZaposleneIzBaze()
	{
		try
		{
			sviZaposleni = ZaposleniDAO.selectAll();
		}
		catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return "zaposleni.xhtml?faces-redirect=true";
	}
	
	public String noviZaposleni()
	{
		zaposleni = new Zaposleni();
		return "novi_zaposleni.xhtml?faces-redirect";
	}
	
	public String dodajZaposlenog()
	{
		try
		{
			ZaposleniDAO.insert(zaposleni.getIme(), zaposleni.getPrezime(), zaposleni.getKorisnickoIme(), zaposleni.getLozinka());
			zaposleni = new Zaposleni();
		}
		catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return "zaposleni.xhtml?faces-redirect=true";
	}
	
	public String obrisiZaposlenog()
	{
		try
		{
			Map<String, String> reqMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			if(reqMap.containsKey("id"))
			{
				int z = Integer.parseInt(reqMap.get("id"));
				for(Zaposleni za : sviZaposleni)
				{
					if(za.getId()==z)
					{
						sviZaposleni.remove(za);
						ZaposleniDAO.delete(z);
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
	
	public String azurirajZaposlenogPage()
	{
		try
		{
			Map<String, String> reqMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			if(reqMap.containsKey("id"))
			{
				int z = Integer.parseInt(reqMap.get("id"));
				for(Zaposleni za : sviZaposleni)
				{
					if(za.getId()==z)
					{
						zaposleni = za;
						break;
					}
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		
		return "azuriraj_zaposlenog.xhtml?faces-redirect=true";
	}
	
	public String azurirajZaposlenog()
	{
		try
		{
			ZaposleniDAO.update(zaposleni.getIme(), zaposleni.getPrezime(), zaposleni.getKorisnickoIme(), zaposleni.getLozinka(), zaposleni.getId());
			zaposleni = new Zaposleni();
		}
		catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return "zaposleni.xhtml?faces-redirect=true";
	}
	

}
