package net.etfbl.ip.jsp.dto;

public class KorisnikDTO {

	private int id;
	private String ime;
	private String prezime;
	private String korisnickoIme;
	private String email;
	private String lozinka;
	private String drzava;
	private String tipNaloga;
	private String adresa;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLozinka() {
		return lozinka;
	}
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	public String getDrzava() {
		return drzava;
	}
	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}
	public String getTipNaloga() {
		return tipNaloga;
	}
	public void setTipNaloga(String tipNaloga) {
		this.tipNaloga = tipNaloga;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public KorisnikDTO(int id, String ime, String prezime, String korisnickoIme, String email, String lozinka,
			String drzava, String tipNaloga, String adresa) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.korisnickoIme = korisnickoIme;
		this.email = email;
		this.lozinka = lozinka;
		this.drzava = drzava;
		this.tipNaloga = tipNaloga;
		this.adresa = adresa;
	}
	public KorisnikDTO() {
		super();
	}
	

}
