package automobili;

import java.util.ArrayList;
import java.util.List;

/*import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;*/

import controller.HibernateDAO;
import model.Car;
import model.User;
import model.VisitCard;
import model.VrstaVozila;

public class GlavnaHibernateKlasa {


	public static void main(String[] args) {
		
		HibernateDAO dao = new HibernateDAO();
		
//		Car car1 = new Car("Zastava", "Yugo", 2018, 300, false, VrstaVozila.PUTNICKO);
//		Car car2 = new Car("Zastava", "Fica", 2008, 500, false, VrstaVozila.PUTNICKO);
//		Car car3 = new Car("Zastava", "Stojadin", 2001, 800, false, VrstaVozila.PUTNICKO);
//		Car car4 = new Car("Zastava", "101", 2008, 500, false, VrstaVozila.PUTNICKO);
//		
//		dao.snimiAutoUbazu(car1);
//		dao.snimiAutoUbazu(car2);
//		dao.snimiAutoUbazu(car3);
//		dao.snimiAutoUbazu(car4);
//		
//		VisitCard visitCard1 = new VisitCard();
//		visitCard1.setIme("ruzica");
//		visitCard1.setEmail("ruza1@gmail.com");
//		visitCard1.setBrojTelefona("064123456");
//		
//		VisitCard visitCard2 = new VisitCard();
//		visitCard2.setIme("ruzica");
//		visitCard2.setEmail("ruza2@gmail.com");
//		visitCard2.setBrojTelefona("062123456");
//		
//		List<VisitCard> vizitke = new ArrayList<VisitCard>();
//		vizitke.add(visitCard1);
//		vizitke.add(visitCard2);
//				
//	    User user = new User();
//		user.setUserName("Ruza");
//		user.setPassword("ruza123");
//		user.setNovcanik(200000);
//		user.setVisitCards(vizitke);
//		
//		dao.snimiUseraUbazu(user);
		
		Car auto1 = dao.vratiAuto(1);
		Car auto2 = dao.vratiAuto(3);
		
		List<Car> ruziniAutici = new ArrayList<Car>();
		ruziniAutici.add(auto1);
		ruziniAutici.add(auto2);
		
		User user = dao.vratiUsera(1);
		if(dao.daLiUserImaDovoljnoParaZaAutomobil(user, ruziniAutici)) {
			dao.spojiUseraIcar(user, ruziniAutici);
		}
		
		
		
		
		
		/*
		 * User user = dao.vratiUsera(1);
		 * 
		 * System.out.println("Zdravo " + user.getUserName());
		 * 
		 * Car auto1 = dao.vratiAuto(2); Car auto2 = dao.vratiAuto(3); Car auto3 =
		 * dao.vratiAuto(5);
		 * 
		 * List<Car> ruziniAutomobili = new ArrayList<Car>();
		 * 
		 * ruziniAutomobili.add(auto1); ruziniAutomobili.add(auto2);
		 * ruziniAutomobili.add(auto3);
		 * 
		 * if(dao.daLiUserImaDovoljnoParaZaAutomobil(user, ruziniAutomobili)) {
		 * 
		 * dao.spojiUseraIcar(user, ruziniAutomobili); }
		 * 
		 * dao.izlistajAutomobile(user);
		 */
		
	}

}
