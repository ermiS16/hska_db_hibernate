package main;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.internal.util.privilegedactions.GetInstancesFromServiceLoader;


@Entity
@Table(schema="main", name="Buchung")

public class Buchung {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", columnDefinition="serial")
	private int id;
	
	@OneToOne(cascade=CascadeType.ALL)
//	@Column(name="customer", nullable=false)
	private Kunde customer;
	
	@OneToOne(cascade=CascadeType.ALL)
//	@Column(name="flight", nullable=false)
	private Flug flight;
	
	@Column(name="date", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column(name="seats", nullable=false)
	private int amountSeats;

	
	public Buchung(Kunde customer, Flug flight, Date date, int amountSeats){
		this.customer = customer;
		this.flight = flight;
		this.date = date;
		this.amountSeats = amountSeats;
	}
	
	public Buchung() {
		this.customer = new Kunde();
		this.flight = new Flug();
		this.date = new Date(0);
		this.amountSeats = 0;
	}
	
	public Kunde getCustomer() {
		return customer;
	}
	public Flug getFlight() {
		return flight;
	}
	public Date getDate() {
		return date;
	}
	public int getAmountSeats() {
		return amountSeats;
	}
	public int getId() {
		return id;
	}
	
	public void setNumberSeats(int amount) {
		this.amountSeats = amount;
	}
	public void setCustomer(Kunde customer) {
		this.customer = customer;
	}
	public void setFlight(Flug flight) {
		this.flight = flight;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String toString() {
		return "Buchungsnummer: " + getId()
		+ "\nKunde: " + customer.getFirstName() + " " + customer.getLastName()
		+ "\nFlug: " + flight.getFlightNumber()
		+ "\nDepartureTime: " + flight.getDepartureAirport()
		+ "\nAmount Seats: " + getAmountSeats()
		+ "\nDatum: " + getDate();
		
	}
}
