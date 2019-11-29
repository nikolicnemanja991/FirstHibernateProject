package model;

import javax.persistence.Entity;

@Entity
public class Kupac extends User {
	
	private String jmbg;

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

}
