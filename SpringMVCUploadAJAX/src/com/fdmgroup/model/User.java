package com.fdmgroup.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "jpa_user")
@NamedQueries({
	@NamedQuery(name="find all", query = "SELECT u FROM User u"),
	@NamedQuery(name="find by username", query = "SELECT u FROM User u WHERE u.username = :username"),
	@NamedQuery(name="find by name", query = "SELECT u FROM User u WHERE u.firstname LIKE :name OR u.lastname LIKE :name OR CONCAT(u.firstname, ' ', u.lastname) LIKE :name"),
	@NamedQuery(name="find by name or company", query = "SELECT u, c FROM User u join u.company c WHERE u.firstname LIKE :name OR u.lastname LIKE :name OR CONCAT(u.firstname, ' ', u.lastname) LIKE :name OR c.name LIKE :name"),
	@NamedQuery(name="find by id", query = "SELECT u FROM User u WHERE u.id = :uId")
})
public class User {

	@Column(name="user_id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="username")
	@Size(min = 3, max = 25, message = "\"${validatedValue}\" is ${validatedValue.length() < 1 ? 'way' : ''} too short.")
	private String username;
	
	@Column(name="pw")
	@NotEmpty
	private String password;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//@JsonManagedReference
	private Company company;
	
	@ManyToMany
	@JsonIgnore
	private List<Role> roles;
	
	@Transient
	@Email
	private String email;
	
	@Transient
	private List<String> interests;
	
	@Transient
	private String fullname;
 
	public User() {
		super();
	}
	
	public User(String username, String password, String firstname,
			String lastname) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public User(int id, String username, String password, String firstname,
			String lastname) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getInterests() {
		return interests;
	}

	public void setInterests(List<String> interests) {
		this.interests = interests;
	}

	public String getFullname() {
		return firstname + " " + lastname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
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
}
