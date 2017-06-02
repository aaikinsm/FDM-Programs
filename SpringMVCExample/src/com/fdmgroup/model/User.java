package com.fdmgroup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "JPA_USER")
@NamedQueries({
	@NamedQuery(name = "user.findByUsername", query= "SELECT u from User u where u.username = :uname"),
	@NamedQuery(name = "user.findAll", query= "SELECT u from User u")
})
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int id;
	
	
	@NotEmpty
	@Size(min = 3, max=20, message="must be between 3 and 20")
	@Column
	private String username;
	
	@NotEmpty
	@Size(min = 3, max=32)
	@Column (name = "pw")
	private String password;
	
	@Column
	private String firstname;
	
	@Column
	private String lastname;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username, String password, String firstname, String lastname) {
		super();
		
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + "]";
	}
	
	
}
