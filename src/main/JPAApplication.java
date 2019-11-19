package main;

import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAApplication {
	private EntityManagerFactory entityManagerFactory;

	public JPAApplication() {
		Logger.getLogger("org.hibernate").setLevel(Level.ALL);
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("DB1");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			createOrder(entityManager);
			printOrders(entityManager);
			entityManager.close();
			entityManagerFactory.close();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	public void createOrder(EntityManager em) {
		Date orderTime = new Date();
		Date departureDate = new Date();
		Date departureDate2 = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd hh:mm:ss");
		try {
			departureDate = dateFormat.parse("2019/11/19 13:30:00");
			departureDate2 = dateFormat.parse("2019/11/19 14:00:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		em.getTransaction().begin();		
		Flug flight1 = new Flug("abc123", departureDate, "Karlsruhe");
		em.persist(flight1);
		Flug flight2 = new Flug("def456", departureDate2, "Stuttgart");
		em.persist(flight2);
		
		Kunde customer1 = new Kunde("Vladimir", "Putin", "vladimir@putin.de");
		Kunde customer2 = new Kunde("Donald", "Trump", "donald@trump.com");
		Kunde customer3 = new Kunde("Angela", "Merkel", "angela@merkel.de");
		
		customer1.setOrder(new Buchung(customer1, flight1, orderTime, 2));		
		customer1.setOrder(new Buchung(customer1, flight2, orderTime, 2));
		em.persist(customer1);
		customer2.setOrder(new Buchung(customer2, flight2, orderTime, 2));
		em.persist(customer2);
		customer3.setOrder(new Buchung(customer3, flight1, orderTime, 2));
		em.persist(customer3);		
		
		em.getTransaction().commit();
	}
	
	public void printOrders(EntityManager em) {
		List<Kunde> customers = em.createQuery("FROM main.Kunde"
								+ " WHERE last_name='Putin'", Kunde.class).getResultList();
		for(Kunde cu : customers) {
			for(Buchung order : cu.getOrders()) {
				System.out.println(order.toString());
			}
		}
	}
	
	public void testFlights() {		
		
	}
	
	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public static void main(String[] args) {
		JPAApplication app = new JPAApplication();
		app.testFlights();
	}
}
