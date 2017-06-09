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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "jpa_company")
@SecondaryTables({
	@SecondaryTable(name = "jpa_company_profile", pkJoinColumns = @PrimaryKeyJoinColumn)
})
@NamedQueries({
	@NamedQuery(name = "company.findByDate", query = "SELECT c FROM Company c join c.stock s WHERE c.established BETWEEN :fromDate AND :toDate AND s.startPrice > :price")
})
public class Company {
	
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(length = 50, nullable = false)
	private String name;
	
	@Column(table = "jpa_company_profile")
	private String address;
	
	@Column(table = "jpa_company_profile")
	@Temporal(TemporalType.DATE)
	private Date established;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "company")
	@JsonBackReference
	private List<User> users;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private Stock stock;

	public Company() {
		super();
	}

	public Company(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Company(String name, String address, Date established, Stock stock) {
		super();
		this.name = name;
		this.address = address;
		this.established = established;
		this.stock = stock;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getEstablished() {
		return established;
	}

	public void setEstablished(Date established) {
		this.established = established;
	}
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		return "Company [id=" + id + ", name=" + name + ", address=" + address
				+ ", established=" + established + ", stock=" + stock + "]";
	}
}
