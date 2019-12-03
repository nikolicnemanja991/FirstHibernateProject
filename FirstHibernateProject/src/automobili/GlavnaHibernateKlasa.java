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
		
		Car car3 = new Car(); car3.setMarka("Fiat"); car3.setModel("Punto");
		car3.setGodiste(2005); car3.setCena(3000);
		car3.setVrstaVozila(VrstaVozila.PUTNICKO); car3.setRegistracija(true);
		
		Car car4 = new Car(); car4.setMarka("BMW"); car4.setModel("740");
		car4.setGodiste(2018); car4.setCena(50000);
		car4.setVrstaVozila(VrstaVozila.PUTNICKO); car4.setRegistracija(true);
		
		dao.snimiAutoUbazu(car3);
		dao.snimiAutoUbazu(car4);
		
		
		
		User kupac = dao.vratiUsera(4);
		Car car1 = dao.vratiAuto(1);
		Car car2 = dao.vratiAuto(2);
		
		car1.setKorisnik(kupac);
		car2.setKorisnik(kupac);
		
		List<Car> automobili = new ArrayList<Car>();
		
		dao.spojiUseraIcar(kupac, automobili);
		automobili.add(car1);
		automobili.add(car2);
		
		/*
		 * VisitCard vizitKarta = new VisitCard(); vizitKarta.setIme("Sone");
		 * vizitKarta.setEmail("nenadcvija@gmail.com");
		 * vizitKarta.setBrojTelefona("0603332211");
		 * 
		 * List<VisitCard> kartice = new ArrayList<VisitCard>();
		 * kartice.add(vizitKarta);
		 * 
		 * Kupac kupac = new Kupac(); kupac.setUserName("Nenad");
		 * kupac.setPassword("nenad123"); kupac.setJmbg("9230567890123");
		 * kupac.setNovcanik(3000000);
		 * 
		 * dao.snimiUseraUbazu(kupac);
		 * 
		 * Car car1 = new Car(); car1.setMarka("Fiat"); car1.setModel("Punto");
		 * car1.setGodiste(2005); car1.setCena(3000);
		 * car1.setVrstaVozila(VrstaVozila.PUTNICKO); car1.setRegistracija(true);
		 * 
		 * Car car2 = new Car(); car2.setMarka("BMW"); car2.setModel("740");
		 * car2.setGodiste(2018); car2.setCena(50000);
		 * car2.setVrstaVozila(VrstaVozila.PUTNICKO); car2.setRegistracija(true);
		 * 
		 * dao.snimiAutoUbazu(car1);
		 * dao.snimiAutoUbazu(car2);
		 */
		
		
		

		
	}

}
