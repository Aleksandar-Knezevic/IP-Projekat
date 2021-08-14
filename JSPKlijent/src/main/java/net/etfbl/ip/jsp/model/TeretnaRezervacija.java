package net.etfbl.ip.jsp.model;

import net.etfbl.ip.jsp.dto.TeretniLetDTO;

public class TeretnaRezervacija {

	
	private TeretniLetDTO let;
	private String statusRezervacije;
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
	public TeretnaRezervacija(TeretniLetDTO let, String statusRezervacije) {
		super();
		this.let = let;
		this.statusRezervacije = statusRezervacije;
	}
	public TeretnaRezervacija() {
		super();
	}
	

}
