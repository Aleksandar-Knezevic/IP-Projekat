package net.etfbl.ip.jsp.dto;

public class GradDTO {

	private int id;
	private String nazivGrada;
	private DrzavaDTO drzava;
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
	public DrzavaDTO getDrzava() {
		return drzava;
	}
	public void setDrzava(DrzavaDTO drzava) {
		this.drzava = drzava;
	}
	public GradDTO(int id, String nazivGrada, DrzavaDTO drzava) {
		super();
		this.id = id;
		this.nazivGrada = nazivGrada;
		this.drzava = drzava;
	}
	public GradDTO() {
		super();
	}
	@Override
	public String toString() {
		return "" + nazivGrada + "";
	}

	

}
