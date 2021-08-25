package net.etfbl.ip.jsf.model;

import java.io.Serializable;
import java.sql.Date;

public class GraphModel implements Serializable {


	private static final long serialVersionUID = -4778741905934957844L;
	private Date datum;
	private int brojPristupa;
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public int getBrojPristupa() {
		return brojPristupa;
	}
	public void setBrojPristupa(int brojPristupa) {
		this.brojPristupa = brojPristupa;
	}
	public GraphModel(Date datum, int brojPristupa) {
		super();
		this.datum = datum;
		this.brojPristupa = brojPristupa;
	}
	public GraphModel() {
		super();
	}
	
	

}
