package net.etfbl.ip.jsp.model;

import net.etfbl.ip.jsp.dto.PutnickiLetDTO;

public class PutnickaRezervacija {

	private PutnickiLetDTO let;
	private String statusRezervacije;
	private String razlogPonistavanja;
	public PutnickiLetDTO getLet() {
		return let;
	}
	public void setLet(PutnickiLetDTO let) {
		this.let = let;
	}
	public String getStatusRezervacije() {
		return statusRezervacije;
	}
	public void setStatusRezervacije(String statusRezervacije) {
		this.statusRezervacije = statusRezervacije;
	}
	
	public PutnickaRezervacija(PutnickiLetDTO let, String statusRezervacije, String razlogPonistavanja) {
		super();
		this.let = let;
		this.statusRezervacije = statusRezervacije;
		this.razlogPonistavanja = razlogPonistavanja;
	}
	public PutnickaRezervacija() {
		super();
	}
	public String getRazlogPonistavanja() {
		return razlogPonistavanja;
	}
	public void setRazlogPonistavanja(String razlogPonistavanja) {
		this.razlogPonistavanja = razlogPonistavanja;
	}
	

}
