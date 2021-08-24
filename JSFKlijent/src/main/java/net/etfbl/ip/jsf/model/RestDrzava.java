package net.etfbl.ip.jsf.model;

import java.io.Serializable;

public class RestDrzava implements Serializable {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RestDrzava(String name) {
		super();
		this.name = name;
	}

	public RestDrzava() {
		super();
	}
	
	

}
