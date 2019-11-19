package main;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(schema="main", name="Flug")

public class Flug {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", columnDefinition="serial")
	private int id;
	
	@Column(name="number", nullable=false, unique=true)
	private String flightNumber;
	
	@Column(name="time", nullable=false)
	@Temporal(TemporalType.TIME)
	private Date departureTime;
	
	@Column(name="start", nullable=false)
	private String departureAirport;
	
	@OneToMany(cascade=CascadeType.ALL)
	private Set<Kunde> customers;
	
	public Flug(String flightNumber, Date departureTime, String departureAirport) {
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
	
	public String getFlightNumber() {
		return flightNumber;
	}
	public Date getDepartureDate() {
		return departureTime;
	}
	public String getDepartureAirport() {
		return departureAirport;
	}
	public Set<Kunde> getCustomers(){
		return customers;
	}
}
