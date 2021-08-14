package net.etfbl.ip.jsp.dto;

import java.sql.Time;
import java.util.Date;

public class PutnickiLetDTO {

	private int id;
	private Date datumLeta;
	private int brojMjesta;
	private GradDTO polazniGrad;
	private GradDTO odredisniGrad;
	private DrzavaDTO polaznaDrzava;
	private DrzavaDTO odredisnaDrzava;
	private String status;
	private Time vrijemePolaska;
	private Time vrijemeDolaska;
	private int brojSlobodnihMjesta;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDatumLeta() {
		return datumLeta;
	}
	public void setDatumLeta(Date datumLeta) {
		this.datumLeta = datumLeta;
	}
	public int getBrojMjesta() {
		return brojMjesta;
	}
	public void setBrojMjesta(int brojMjesta) {
		this.brojMjesta = brojMjesta;
	}
	public GradDTO getPolazniGrad() {
		return polazniGrad;
	}
	public void setPolazniGrad(GradDTO polazniGrad) {
		this.polazniGrad = polazniGrad;
	}
	public GradDTO getOdredisniGrad() {
		return odredisniGrad;
	}
	public void setOdredisniGrad(GradDTO odredisniGrad) {
		this.odredisniGrad = odredisniGrad;
	}
	public DrzavaDTO getPolaznaDrzava() {
		return polaznaDrzava;
	}
	public void setPolaznaDrzava(DrzavaDTO polaznaDrzava) {
		this.polaznaDrzava = polaznaDrzava;
	}
	public DrzavaDTO getOdredisnaDrzava() {
		return odredisnaDrzava;
	}
	public void setOdredisnaDrzava(DrzavaDTO odredisnaDrzava) {
		this.odredisnaDrzava = odredisnaDrzava;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Time getVrijemePolaska() {
		return vrijemePolaska;
	}
	public void setVrijemePolaska(Time vrijemePolaska) {
		this.vrijemePolaska = vrijemePolaska;
	}
	public Time getVrijemeDolaska() {
		return vrijemeDolaska;
	}
	public void setVrijemeDolaska(Time vrijemeDolaska) {
		this.vrijemeDolaska = vrijemeDolaska;
	}
	
	public int getBrojSlobodnihMjesta() {
		return brojSlobodnihMjesta;
	}
	public void setBrojSlobodnihMjesta(int brojSlobodnihMjesta) {
		this.brojSlobodnihMjesta = brojSlobodnihMjesta;
	}
	public PutnickiLetDTO(int id, Date datumLeta, int brojMjesta, GradDTO polazniGrad, GradDTO odredisniGrad,
			DrzavaDTO polaznaDrzava, DrzavaDTO odredisnaDrzava, String status, Time vrijemePolaska, Time vrijemeDolaska,
			int brojSlobodnihMjesta) {
		super();
		this.id = id;
		this.datumLeta = datumLeta;
		this.brojMjesta = brojMjesta;
		this.polazniGrad = polazniGrad;
		this.odredisniGrad = odredisniGrad;
		this.polaznaDrzava = polaznaDrzava;
		this.odredisnaDrzava = odredisnaDrzava;
		this.status = status;
		this.vrijemePolaska = vrijemePolaska;
		this.vrijemeDolaska = vrijemeDolaska;
		this.brojSlobodnihMjesta = brojSlobodnihMjesta;
	}
	public PutnickiLetDTO() {
		super();
	}

	

}
