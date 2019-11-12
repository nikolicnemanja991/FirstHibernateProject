package automobili;

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
		
        Car car = new Car("land rover", "discovery", 2018, 39990, false, VrstaVozila.SUV);
        
        VisitCard visitCard = new VisitCard();
        visitCard.setIme("ruzica");
        visitCard.setEmail("ruza@gmail.com");
        visitCard.setBrojTelefona("0641234567");
        
        User user = new User();
        user.setUserName("ruza");
        user.setPassword("programer123");
        user.setNovcanik(100000);
        user.setVisitCard(visitCard);
        
        dao.snimiAutoUbazu(car);
        dao.snimiUseraUbazu(user);
	}

}
