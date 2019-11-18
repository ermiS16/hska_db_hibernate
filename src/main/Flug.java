package main;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Flug")

public class Flug {
	@Column(name="number")
	private String flightNumber;
	@Column(name="time")
	@Temporal(TemporalType.TIME)
	private Date departureTime;
	@Column(name="start")
	private String departureAirport;
	
	@OneToMany(cascade=CascadeType.ALL)
	private Set<Kunde> customers;
	
	public Flug(String flightNumber, Date deprartureTime, String departureAirport) {
		this.flightNumber = flightNumber;
		this.departureTime = departureTime;
		this.departureAirport = departureAirport;
		this.customers = new HashSet<Kunde>();
	}
	
	public Flug() {
		this.flightNumber = new String();
		this.departureTime = new Date(0);
		this.departureAirport = new String();
	}
}
