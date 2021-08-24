package net.etfbl.ip.jsp.dto;

import java.io.Serializable;

public class Zaposleni implements Serializable {


	private static final long serialVersionUID = 2360135447521653183L;
	private int id;
	private String ime;
	private String prezime;
	private String korisnickoIme;
	private String lozinka;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getKorisnickoIme() {
		return korisnickoIme;
	}
	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}
	public String getLozinka() {
		return lozinka;
	}
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	public Zaposleni(int id, String ime, String prezime, String korisnickoIme, String lozinka) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
	}
	public Zaposleni() {
		super();
	}
	
	

	

}
