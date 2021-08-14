package net.etfbl.ip.jsp.dto;

import java.util.Date;

public class RezervacijaPutnickogLetaDTO {

	private KorisnikDTO korisnik;
	private PutnickiLetDTO putnickiLet;
	private String status;
	private Date datumKreiranja;
	private String razlogPonistavanja;
	private int brojMjesta;
	public KorisnikDTO getKorisnik() {
		return korisnik;
	}
	public void setKorisnik(KorisnikDTO korisnik) {
		this.korisnik = korisnik;
	}
	public PutnickiLetDTO getPutnickiLet() {
		return putnickiLet;
	}
	public void setPutnickiLet(PutnickiLetDTO putnickiLet) {
		this.putnickiLet = putnickiLet;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDatumKreiranja() {
		return datumKreiranja;
	}
	public void setDatumKreiranja(Date datumKreiranja) {
		this.datumKreiranja = datumKreiranja;
	}
	public String getRazlogPonistavanja() {
		return razlogPonistavanja;
	}
	public void setRazlogPonistavanja(String razlogPonistavanja) {
		this.razlogPonistavanja = razlogPonistavanja;
	}
	public int getBrojMjesta() {
		return brojMjesta;
	}
	public void setBrojMjesta(int brojMjesta) {
		this.brojMjesta = brojMjesta;
	}
	public RezervacijaPutnickogLetaDTO(KorisnikDTO korisnik, PutnickiLetDTO putnickiLet, String status,
			Date datumKreiranja, String razlogPonistavanja, int brojMjesta) {
		super();
		this.korisnik = korisnik;
		this.putnickiLet = putnickiLet;
		this.status = status;
		this.datumKreiranja = datumKreiranja;
		this.razlogPonistavanja = razlogPonistavanja;
		this.brojMjesta = brojMjesta;
	}
	public RezervacijaPutnickogLetaDTO() {
		super();
	}
	
	

}
