package controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Car;
import model.User;

public class HibernateDAO {
	// DAO - Data Access Object 
	// CRUD - Create Read Update Delete
	// INSERT -> save() - mora da bude otvorena transakcija
	//        -> persist() - ne mora da bude otvorena transakcija
	// SELECT -> get(Cae.class, ID)
	//        -> load() - ista stvar kao i get() - vraca exeption
	// UPDATE -> update()
	// DELETE -> delete()
	
	
	// SessionFactory - interface
    // Configuration - class
	// Configure - method
	SessionFactory factory = new Configuration().configure().buildSessionFactory();
	
	public boolean snimiAutoUbazu (Car car) {
		Session sesija = factory.openSession();
		   sesija.beginTransaction();
		   try {
			  sesija.save(car); 
			  
			  sesija.getTransaction().commit();
			  
			  return true;
		   } catch (Exception e) {
		      sesija.getTransaction().rollback();
		      return false;
		   } finally {
		      sesija.close();
		   }
		
	}
	
	public Car vratiAuto (int id) {
		Session sesija = factory.openSession();
		sesija.beginTransaction();
		
		Car car = null;
		try {
		   car = sesija.get(Car.class, id);
		   sesija.getTransaction().commit();
		   return car;
		} catch (Exception e) {
		   sesija.getTransaction().rollback();
		   return null;
	    } finally {
		   sesija.close();
		}
		
	}
	
	public void updateCarPrice (int id, double novaCena) {
		Session sesija = factory.openSession();
		sesija.beginTransaction();
		
		Car car = null;
		try {
		   car = sesija.get(Car.class, id);
		   car.setCena(novaCena);
		   sesija.update(car);
		   sesija.getTransaction().commit();
		} catch (Exception e) {
		   sesija.getTransaction().rollback();
	    } finally {
		   sesija.close();
		}
		
	}
	
	public boolean deleteCar (int id) {
		Session sesija = factory.openSession();
		sesija.beginTransaction();
		
		Car car = null;
		try {
		   car = sesija.get(Car.class, id);
		   sesija.delete(car);
		   sesija.getTransaction().commit();
		   return true;
		} catch (Exception e) {
		   sesija.getTransaction().rollback();
		   return false;
	    } finally {
		   sesija.close();
		}
		
	}
	
	public boolean snimiUseraUbazu (User user) {
		Session sesija = factory.openSession();
		   sesija.beginTransaction();
		   try {
			  sesija.save(user); 
			  
			  sesija.getTransaction().commit();
			  
			  return true;
		   } catch (Exception e) {
		      sesija.getTransaction().rollback();
		      return false;
		   } finally {
		      sesija.close();
		   }
		
	}
	
	/*
	 * public void linkujUseraIauto(int idCar, int idUser) {
	 * 
	 * Session sesija = factory.openSession(); sesija.beginTransaction(); Car car;
	 * User user;
	 * 
	 * try { // preuzmi usera i car iz baze car = sesija.get(Car.class, idCar); user
	 * = sesija.get(User.class, idUser);
	 * 
	 * car.setKorisnik(user); user.setAuto(car);
	 * 
	 * sesija.update(user); sesija.update(car);
	 * 
	 * sesija.getTransaction().commit(); } catch (Exception e) {
	 * sesija.getTransaction().rollback(); } finally { sesija.close(); }
	 * 
	 * }
	 */
	
}
