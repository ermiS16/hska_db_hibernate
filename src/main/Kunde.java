package main;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Kunde")

public class Kunde {
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="email")
	private String email;
	
	@OneToMany(cascade=CascadeType.ALL)
	private Set<Flug> flights;
	
	public Kunde(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.flights = new HashSet<Flug>();
	}
	
	public Kunde() {
		this.firstName = new String();
		this.lastName = new String();
		this.email = new String();
	}
}
