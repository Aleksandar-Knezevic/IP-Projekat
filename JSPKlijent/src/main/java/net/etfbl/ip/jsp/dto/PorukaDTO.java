package net.etfbl.ip.jsp.dto;

public class PorukaDTO {

	private int id;
	private String email;
	private String naslov;
	private String sadrzaj;
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNaslov() {
		return naslov;
	}
	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}
	public String getSadrzaj() {
		return sadrzaj;
	}
	public void setSadrzaj(String sadrzaj) {
		this.sadrzaj = sadrzaj;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public PorukaDTO(int id, String email, String naslov, String sadrzaj, String status) {
		super();
		this.id = id;
		this.email = email;
		this.naslov = naslov;
		this.sadrzaj = sadrzaj;
		this.status = status;
	}
	public PorukaDTO() {
		super();
	}
	

}
