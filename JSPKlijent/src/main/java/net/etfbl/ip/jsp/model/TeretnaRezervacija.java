package net.etfbl.ip.jsp.model;

import net.etfbl.ip.jsp.dto.TeretniLetDTO;

public class TeretnaRezervacija {

	
	private TeretniLetDTO let;
	private String statusRezervacije;
	private String razlogPonistavanja;
	public TeretniLetDTO getLet() {
		return let;
	}
	public void setLet(TeretniLetDTO let) {
		this.let = let;
	}
	public String getStatusRezervacije() {
		return statusRezervacije;
	}
	public void setStatusRezervacije(String statusRezervacije) {
		this.statusRezervacije = statusRezervacije;
	}
	
	public TeretnaRezervacija(TeretniLetDTO let, String statusRezervacije, String razlogPonistavanja) {
		super();
		this.let = let;
		this.statusRezervacije = statusRezervacije;
		this.razlogPonistavanja = razlogPonistavanja;
	}
	public TeretnaRezervacija() {
		super();
	}
	public String getRazlogPonistavanja() {
		return razlogPonistavanja;
	}
	public void setRazlogPonistavanja(String razlogPonistavanja) {
		this.razlogPonistavanja = razlogPonistavanja;
	}
	

}
