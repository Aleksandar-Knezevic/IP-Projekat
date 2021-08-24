package net.etfbl.ip.jsp.dto;

import java.io.Serializable;

public class Grad implements Serializable {


	private static final long serialVersionUID = -2617283420060349064L;
	private int id;
	private String nazivGrada;
	private Drzava drzava;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNazivGrada() {
		return nazivGrada;
	}
	public void setNazivGrada(String nazivGrada) {
		this.nazivGrada = nazivGrada;
	}
	public Drzava getDrzava() {
		return drzava;
	}
	public void setDrzava(Drzava drzava) {
		this.drzava = drzava;
	}
	public Grad(int id, String nazivGrada, Drzava drzava) {
		super();
		this.id = id;
		this.nazivGrada = nazivGrada;
		this.drzava = drzava;
	}
	public Grad() {
		super();
	}
	
	

}
