package com.fdmgroup.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private transient int id;
	public static int count = 0;
	private String name;
	private double mark;
	private Company company;

	public User() {
		super();
	}

	public User(int id, String name, double mark, Company company) {
		super();
		this.id = id;
		this.name = name;
		this.mark = mark;
		this.company = company;
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

	public double getMark() {
		return mark;
	}

	public void setMark(double mark) {
		this.mark = mark;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", mark=" + mark + ", company=" + company + ", count=" + count
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + id;
		long temp;
		temp = Double.doubleToLongBits(mark);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(mark) != Double.doubleToLongBits(other.mark))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	private void writeObject(ObjectOutputStream oos) throws IOException{
		oos.writeInt(id);
		oos.writeInt(count);
		oos.defaultWriteObject();
	}

	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException{
		this.id = ois.readInt();
		this.count = ois.readInt();
		ois.defaultReadObject();
	}

}
