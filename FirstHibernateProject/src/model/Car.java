package model;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCar;
	private String marka;
	private String model;
	private int godiste;
	private double cena;
	private boolean registracija;
	@Enumerated
	private VrstaVozila vrstaVozila;
	@OneToOne
	private User korisnik;
	
	
	public Car() {
		
	}
	
	public Car(String marka, String model, int godiste, double cena, boolean registracija, VrstaVozila vrstaVozila) {
		this.marka = marka;
		this.model = model;
		this.godiste = godiste;
		this.registracija = registracija;
		this.vrstaVozila = vrstaVozila;
	}
	
	
	
	public User getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(User korisnik) {
		this.korisnik = korisnik;
	}

	public VrstaVozila getVrstaVozila() {
		return vrstaVozila;
	}

	public void setVrstaVozila(VrstaVozila vrstaVozila) {
		this.vrstaVozila = vrstaVozila;
	}

	public int getIdCar() {
		return idCar;
	}

	public void setIdCar(int idCar) {
		this.idCar = idCar;
	}

	public String getMarka() {
		return marka;
	}
	public void setMarka(String marka) {
		this.marka = marka;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getGodiste() {
		return godiste;
	}
	public void setGodiste(int godiste) {
		this.godiste = godiste;
	}
	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}
	public boolean isRegistracija() {
		return registracija;
	}
	public void setRegistracija(boolean registracija) {
		this.registracija = registracija;
	}

}
