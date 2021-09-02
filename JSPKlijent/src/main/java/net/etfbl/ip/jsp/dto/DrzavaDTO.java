package net.etfbl.ip.jsp.dto;

public class DrzavaDTO {
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
	public DrzavaDTO(int id, String nazivDrzave) {
		super();
		this.id = id;
		this.nazivDrzave = nazivDrzave;
	}
	public DrzavaDTO() {
		super();
	}
	@Override
	public String toString() {
		return "" + nazivDrzave + "";
	}
	
	

	

}
