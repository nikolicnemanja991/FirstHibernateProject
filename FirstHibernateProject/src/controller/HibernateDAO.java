package controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Car;
import model.Prodavac;
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
	
	public boolean snimiProdavcaUbazu (Prodavac prodavac) {
		Session sesija = factory.openSession();
		   sesija.beginTransaction();
		   try {
			  sesija.save(prodavac); 
			  
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
	
	public User vratiUsera (int id) {
		Session sesija = factory.openSession();
		sesija.beginTransaction();
		
		User user = null;
		try {
		   user = sesija.get(User.class, id);
		   sesija.getTransaction().commit();
		   return user;
		} catch (Exception e) {
		   sesija.getTransaction().rollback();
		   return user;
	    } finally {
		   sesija.close();
		}
		
	}
	
	public boolean daLiUserImaDovoljnoParaZaAutomobil(User user, List <Car> listaAutomobila) {
		Session sesija = factory.openSession();
		sesija.beginTransaction();
		
		double novcanik = user.getNovcanik();
		double krajnjaCena = 0;
		
		for(Car car: listaAutomobila) {
			krajnjaCena += car.getCena();
		}
		
		try {
		   
			if (novcanik >= krajnjaCena) {
				System.out.println("Kupili ste automobile");
				sesija.getTransaction().commit();
				return true;
			} else {
				System.out.println("Nemate dovoljno novca");
				sesija.getTransaction().commit();
				return false;
			}
		   
		} catch (Exception e) {
		   sesija.getTransaction().rollback();
		   return false;
	    } finally {
		   sesija.close();
		}
	}
	
	public void spojiUseraIcar(User user,  List <Car> listaAutomobila) {
		Session sesija = factory.openSession();
		sesija.beginTransaction();
		// dodaj listu automobila datom korisniku
		user.setAutomobili(listaAutomobila);
		double krajnjaCena = 0;
		
		
		try {
			for(Car car: listaAutomobila) {
				car.setKorisnik(user);
				sesija.update(car);
				krajnjaCena += car.getCena();
			}
			// azuriraj novcanik
			user.setNovcanik(user.getNovcanik() - krajnjaCena);
			
			sesija.update(user);
		   sesija.getTransaction().commit();
		   System.out.println("Sve OK, balanc azuriran!");
		} catch (Exception e) {
		   sesija.getTransaction().rollback();
		   
	    } finally {
		   sesija.close();
		}
	}
	
	public void izlistajAutomobile(User user){
		Session sesija = factory.openSession();
		sesija.beginTransaction();
		
		List<Car> automobili = new ArrayList<Car>();
		
		try {
			// - - - - - - - - - - - - - - - - - - - - - - -
			// lazy initialization - rucno preuzimanje liste
			// - - - - - - - - - - - - - - - - - - - - - - -
			//User u = sesija.get(User.class, user.getIdUser());
			// hakerska varijanta (inicijalizuje samo datu listu)
			//u.getAutomobili().size(); // povlacimo listu
			// skolska varijanta (inicijalizuje sve liste)
			//Hibernate.initialize(u); // populise u - izvlaci iz baze a ne iz kesa
			
		   
		   //automobili = u.getAutomobili();
		   automobili = user.getAutomobili();
		   int brojAutomobila = automobili.size();
		   System.out.println("Korisnik " + user.getUserName() + " je kupio " + brojAutomobila + " automobila.");
		   for(Car car: automobili) {
			   System.out.println(car.getMarka() + " "+ car.getModel());
		   }
		   sesija.getTransaction().commit();
		   
		} catch (Exception e) {
		   sesija.getTransaction().rollback();
		   e.printStackTrace();
		   
	    } finally {
		   sesija.close();
		}
	}
	
}
