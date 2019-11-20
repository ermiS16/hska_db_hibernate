package main;

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

@Entity
@Table(schema ="main", name = "Kunde")

public class Kunde {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", columnDefinition="serial")
	private int id;
	
	@Column(name="first_name", nullable=false)
	private String firstName;
	
	@Column(name="last_name", nullable=false)
	private String lastName;
	
	@Column(name="email", nullable=false)
	private String email;
	
	@OneToMany(cascade=CascadeType.ALL)
	private Set<Buchung> orders;
	
	public Kunde(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.orders = new HashSet<Buchung>();
	}
	
	public Kunde() {
		this.firstName = new String();
		this.lastName = new String();
		this.email = new String();
		this.orders = new HashSet<Buchung>();
	}
	
	public void setOrder(Buchung order) {
		this.orders.add(order);
	}
	public int getCustomerId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}
	
	public Set<Buchung> getOrders(){
		return orders;
	}
}
