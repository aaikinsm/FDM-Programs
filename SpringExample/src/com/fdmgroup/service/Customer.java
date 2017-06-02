package com.fdmgroup.service;

import javax.annotation.Resource;
import javax.xml.registry.infomodel.PersonName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Customer {

	/*@Autowired
	@Qualifier("person2")*/
	@Resource(name = "person3")
	private Person person;
	private String orderType;

	public Customer(Person person, String orderType) {
		super();
		this.person = person;
		this.orderType = orderType;
	}

	public Customer() {
		super();
	}

	@Override
	public String toString() {
		return "Customer [person=" + person + ", orderType=" + orderType + "]";
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
}
