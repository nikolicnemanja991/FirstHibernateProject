package automobili;

import java.util.ArrayList;
import java.util.List;

/*import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;*/

import controller.HibernateDAO;
import model.Car;
import model.Kupac;
import model.Prodavac;
import model.User;
import model.VisitCard;
import model.VrstaVozila;

public class GlavnaHibernateKlasa {


	public static void main(String[] args) {
		
		HibernateDAO dao = new HibernateDAO();
		
		
		List<Car> c = dao.dajMiSveJefeftinijeAutomobile(10000);
		
		for(Car car: c) {
			System.out.println(car.getMarka() + " " + car.getModel());
		}
		
		
		
		
		/*
		 * Car car3 = new Car(); car3.setMarka("Fiat"); car3.setModel("Punto");
		 * car3.setGodiste(2005); car3.setCena(3000);
		 * car3.setVrstaVozila(VrstaVozila.PUTNICKO); car3.setRegistracija(true);
		 * 
		 * Car car4 = new Car(); car4.setMarka("BMW"); car4.setModel("740");
		 * car4.setGodiste(2018); car4.setCena(50000);
		 * car4.setVrstaVozila(VrstaVozila.PUTNICKO); car4.setRegistracija(true);
		 * 
		 * dao.snimiAutoUbazu(car3); dao.snimiAutoUbazu(car4);
		 * 
		 * User kupac = dao.vratiUsera(4); Car car1 = dao.vratiAuto(1); Car car2 =
		 * dao.vratiAuto(2);
		 * 
		 * car1.setKorisnik(kupac); car2.setKorisnik(kupac);
		 * 
		 * List<Car> automobili = new ArrayList<Car>();
		 * 
		 * dao.spojiUseraIcar(kupac, automobili); automobili.add(car1);
		 * automobili.add(car2);
		 */
		

		
		
		

		
	}

}
