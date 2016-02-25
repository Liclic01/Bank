package model;

import java.util.Date;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import model.Account;

@Entity
public class Client {
	@Id
	@GeneratedValue
	private long id;
	private String firstName;
	private String lastName;
	private java.sql.Date registrationDate;
	private java.sql.Date birthDate;
	@OneToMany
	@JoinTable(name = "client_account", joinColumns = @JoinColumn(name = "client_id"), inverseJoinColumns = @JoinColumn(name = "account_id"))
	@ElementCollection(fetch = FetchType.EAGER)
	private Collection<Account> accounts = new ArrayList<>();
	
	protected Client(){}
	
	public Client(String firstName, String lastName, Date birthDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = new java.sql.Date(birthDate.getTime());
		this.registrationDate = new java.sql.Date(new Date().getTime());
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", registrationDate="
				+ registrationDate + ", birthDate=" + birthDate + ", accounts=" + accounts + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(java.sql.Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(java.sql.Date birthDate) {
		this.birthDate = birthDate;
	}

	public Collection<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Collection<Account> accounts) {
		this.accounts = accounts;
	}
	
	
}
