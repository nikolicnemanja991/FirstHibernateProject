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
		
		
		User user = new User();
		user.setUserName("Pera");
		
		Prodavac prodavac = new Prodavac();
		prodavac.setUserName("Elvis");
		prodavac.setPib(1);
		
		Kupac kupac = new Kupac();
		kupac.setUserName("Milica");
		kupac.setJmbg("1234567890123");
		
		dao.snimiUseraUbazu(user);
		dao.snimiUseraUbazu(prodavac);
		dao.snimiUseraUbazu(kupac);
		

		
	}

}
