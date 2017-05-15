package com.fdmgroup.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "JPA_COMPANY")
@SecondaryTables({
	@SecondaryTable(name = "JPA_COMPANY_PROFILE", pkJoinColumns = @PrimaryKeyJoinColumn(referencedColumnName = "company_id"))
})
@NamedQueries({
	@NamedQuery(name = "company.findBySize", query = "Select c from Company c where c.numOfEmployees > :size"),
})
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "company_id")
	private int id;
	
	@Column(name = "company_name")
	private String name;
	
	@Column(table = "JPA_COMPANY_PROFILE")
	private String address;
	
	@Column(table = "JPA_COMPANY_PROFILE")
	@Temporal(TemporalType.DATE)
	private Date established;
	
	@Column(table = "JPA_COMPANY_PROFILE", name = "number_of_employees")
	private int numOfEmployees;
	
	@OneToMany(mappedBy = "company")
	private List<User> users;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	
	private Stock stock;

	public Company() {
		super();
	}

	public Company(String name) {
		super();
		this.name = name;
	}
	

	public Company(String name, String address, Date established, int numOfEmployees, Stock stock) {
		super();
		this.name = name;
		this.address = address;
		this.established = established;
		this.numOfEmployees = numOfEmployees;
		this.stock = stock;
	}

	public Company(String name, String address, Date established, int numOfEmployees) {
		super();
		this.name = name;
		this.address = address;
		this.established = established;
		this.numOfEmployees = numOfEmployees;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	


	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Date getEstablished() {
		return established;
	}

	public void setEstablished(Date established) {
		this.established = established;
	}

	public int getNumOfEmployees() {
		return numOfEmployees;
	}

	public void setNumOfEmployees(int numOfEmployees) {
		this.numOfEmployees = numOfEmployees;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		Company other = (Company) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", address=" + address + ", established=" + established
				+ ", numOfEmployees=" + numOfEmployees + ", stock=" + stock + "]";
	}
	
}
