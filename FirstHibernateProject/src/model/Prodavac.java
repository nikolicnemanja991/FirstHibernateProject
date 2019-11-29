package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
// Ovo je samo za single table strategy
//@DiscriminatorValue("Sales_manager")
public class Prodavac extends User {
	
	private int pib;

	public int getPib() {
		return pib;
	}

	public void setPib(int pib) {
		this.pib = pib;
	}

}
