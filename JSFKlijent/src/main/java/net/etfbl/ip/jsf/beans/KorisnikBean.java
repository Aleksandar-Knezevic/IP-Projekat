package net.etfbl.ip.jsf.beans;

import java.io.Serializable;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.google.gson.Gson;

import net.etfbl.ip.jsf.dao.KorisnikDAO;
import net.etfbl.ip.jsf.model.RestDrzava;
import net.etfbl.ip.jsp.dto.Korisnik;

@ManagedBean(name = "korisniciBean")
@SessionScoped
public class KorisnikBean implements Serializable {

	private static final long serialVersionUID = 8063431556754112178L;
	private Korisnik korisnik = new Korisnik();
	private ArrayList<Korisnik> sviKorisnici = new ArrayList<Korisnik>();
	private ArrayList<RestDrzava> dostupneDrzave = new ArrayList<RestDrzava>();
	
	public KorisnikBean() {
		

	}
	
	

	public ArrayList<RestDrzava> getDostupneDrzave() {
		return dostupneDrzave;
	}



	public void setDostupneDrzave(ArrayList<RestDrzava> dostupneDrzave) {
		this.dostupneDrzave = dostupneDrzave;
	}



	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public ArrayList<Korisnik> getSviKorisnici() {
		return sviKorisnici;
	}

	public void setSviKorisnici(ArrayList<Korisnik> sviKorisnici) {
		this.sviKorisnici = sviKorisnici;
	}
	
	public String ocitajKorisnikeIzBaze()
	{
		try
		{
			sviKorisnici = KorisnikDAO.selectAll();
		}
		catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return "korisnici.xhtml?faces-redirect=true";
	}
	
	public String noviKorisnik()
	{
		korisnik=new Korisnik();
		return "novi_korisnik.xhtml?faces-redirect=true";
	}
	
	public String dohvatiDostupneDrzave()
	{
		try
		{
			HttpRequest request = HttpRequest
								 .newBuilder()
								 .uri(new URI("https://restcountries.eu/rest/v2/region/europe"))
								 .GET()
								 .build();
			HttpResponse<String> response = HttpClient
											.newBuilder()
											.build()
											.send(request, BodyHandlers.ofString());
			String result = response.body();
			Gson gson = new Gson();
			dostupneDrzave = gson.fromJson(result, ArrayList.class);
			
								 
								 
		}
		catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return null;
	}
	
	public String dodajKorisnika()
	{
		try
		{
			KorisnikDAO.insert(korisnik.getIme(),
							   korisnik.getPrezime(), 
							   korisnik.getKorisnickoIme(), 
							   korisnik.getEmail(),
							   korisnik.getLozinka(), 
							   korisnik.getDrzava(),
							   korisnik.getTipNaloga(),
							   korisnik.getAdresa());
			sviKorisnici.add(korisnik);
			korisnik = new Korisnik();
		}
		catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return "korisnici.xhtml?faces-redirect=true";
	}
	
	public String obrisiKorisnika()
	{
		try
		{
			Map<String, String> reqMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			if (reqMap.containsKey("id")) {
				int z = Integer.parseInt(reqMap.get("id"));
				for (Korisnik k : sviKorisnici) {
					if (k.getId() == z) {
						sviKorisnici.remove(k);
						KorisnikDAO.delete(k.getId());
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
	
	public String azurirajKorisnikaPage()
	{
		Map<String, String> reqMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		if(reqMap.containsKey("id"))
		{
			int z = Integer.parseInt(reqMap.get("id"));
			for(Korisnik k : sviKorisnici)
			{
				if(k.getId()==z)
				{
					korisnik=k;
					break;
				}
			}
		}
		return "azuriraj_korisnika.xhtml?faces-redirect=true";
	}
	
	public String azurirajKorisnika()
	{
		try
		{
			KorisnikDAO.update(korisnik.getIme(), korisnik.getPrezime(), korisnik.getKorisnickoIme(), korisnik.getEmail(), korisnik.getLozinka(), korisnik.getDrzava(), korisnik.getTipNaloga(), korisnik.getAdresa(), korisnik.getId());
			korisnik = new Korisnik();
		}
		catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return "korisnici.xhtml?faces-redirect=true";
	}
	
	

}
