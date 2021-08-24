package net.etfbl.ip.jsp.dto;

import java.io.Serializable;

public class Drzava implements Serializable {

	private static final long serialVersionUID = -5662442923864455450L;
	private int id;
	private String nazivDrzave;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNazivDrzave() {
		return nazivDrzave;
	}
	public void setNazivDrzave(String nazivDrzave) {
		this.nazivDrzave = nazivDrzave;
	}
	public Drzava(int id, String nazivDrzave) {
		super();
		this.id = id;
		this.nazivDrzave = nazivDrzave;
	}
	public Drzava() {
		super();
	}
	
	
	

}
