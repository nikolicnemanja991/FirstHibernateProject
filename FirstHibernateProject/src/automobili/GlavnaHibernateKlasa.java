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
		
        User user = dao.vratiUsera(1);
        
        System.out.println("Zdravo " + user.getUserName());
        
        Car auto1 = dao.vratiAuto(2);
        Car auto2 = dao.vratiAuto(3);
        Car auto3 = dao.vratiAuto(5);
        
        List<Car> ruziniAutomobili = new ArrayList<Car>();
        
        ruziniAutomobili.add(auto1);
        ruziniAutomobili.add(auto2);
        ruziniAutomobili.add(auto3);
        
        if(dao.daLiUserImaDovoljnoParaZaAutomobil(user, ruziniAutomobili)) {
        	
        	dao.spojiUseraIcar(user, ruziniAutomobili);
        }

		dao.izlistajAutomobile(user);
		
	}

}
