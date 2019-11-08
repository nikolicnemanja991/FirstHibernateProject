package automobili;

/*import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;*/

import controller.HibernateDAO;
import model.Car;

public class GlavnaHibernateKlasa {


	public static void main(String[] args) {
		
		HibernateDAO dao = new HibernateDAO();
		
		/*
		 * Car car = new Car("maserati", "levante", 2019, 1.2, true);
		 * dao.snimiAutoUbazu(car);
		 */
		
		/*
		 * Car car = dao.vratiAuto(2); System.out.println("Uzeo si auto marke: " +
		 * car.getMarka() + " model: " + car.getModel() + " cena: " + car.getCena());
		 */
		
		/*
		 * Car car = dao.vratiAuto(5); dao.updateCarPrice(car.getIdCar(), 1500000);
		 * System.out.println("Uzeo si auto marke: " + car.getMarka() + " model: " +
		 * car.getModel() + " cena: " + car.getCena());
		 */
		
		if(dao.deleteCar(4)) System.out.println("Obrisan je auto!");
		else System.out.println("Nije obrisan je auto!");
	}

}
