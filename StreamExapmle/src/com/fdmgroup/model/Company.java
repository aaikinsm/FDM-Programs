package com.fdmgroup.model;

import java.io.Serializable;

public class Company implements Serializable{

	private static final long serialVersionUID = 1L;

	private int id;
	private String name;

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", stock=" + stock + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Company(int id, String name, Stock stock) {
		super();
		this.id = id;
		this.name = name;
		this.stock = stock;
	}

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Stock stock;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((stock == null) ? 0 : stock.hashCode());
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (stock == null) {
			if (other.stock != null)
				return false;
		} else if (!stock.equals(other.stock))
			return false;
		return true;
	}
}
