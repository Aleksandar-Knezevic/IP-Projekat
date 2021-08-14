package net.etfbl.ip.jsp.dto;

import java.util.Date;

public class RezervacijaTeretnogLetaDTO {

	private KorisnikDTO korisnik;
	private TeretniLetDTO teretniLet;
	private String status;
	private Date datumKreiranja;
	private String razlogPonistavanja;
	public KorisnikDTO getKorisnik() {
		return korisnik;
	}
	public void setKorisnik(KorisnikDTO korisnik) {
		this.korisnik = korisnik;
	}
	public TeretniLetDTO getTeretniLet() {
		return teretniLet;
	}
	public void setTeretniLet(TeretniLetDTO teretniLet) {
		this.teretniLet = teretniLet;
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
	public RezervacijaTeretnogLetaDTO(KorisnikDTO korisnik, TeretniLetDTO teretniLet, String status,
			Date datumKreiranja, String razlogPonistavanja) {
		super();
		this.korisnik = korisnik;
		this.teretniLet = teretniLet;
		this.status = status;
		this.datumKreiranja = datumKreiranja;
		this.razlogPonistavanja = razlogPonistavanja;
	}
	public RezervacijaTeretnogLetaDTO() {
		super();
	}
	

}
