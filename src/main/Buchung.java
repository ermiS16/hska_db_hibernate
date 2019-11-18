package main;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.cfg.FkSecondPass;

@Entity
@Table(name="Buchung")

public class Buchung {
	@Column(name="customer")
	private Kunde customer;
	@Column(name="flight")
	private Flug flight;
	@Column(name="date")
	@Temporal(TemporalType.DATE)
	private Date date;
	@Column(name="seats")
	private int numberSeats;

	
	public Buchung(Kunde customer, Flug flight, Date date, int numberSeats){
		this.customer = customer;
		this.flight = flight;
		this.date = date;
		this.numberSeats = numberSeats;
	}
	
	public Buchung() {
		this.customer = new Kunde();
		this.flight = new Flug();
		this.date = new Date(0);
		this.numberSeats = 0;
	}
}
