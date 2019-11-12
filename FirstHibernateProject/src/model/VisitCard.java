package model;

import javax.persistence.Embeddable;

@Embeddable
public class VisitCard { // value object - slozeni tip 
	
	private String ime;
	private String brojTelefona;
	private String email;
	
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getBrojTelefona() {
		return brojTelefona;
	}
	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
