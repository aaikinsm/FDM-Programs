package com.fdmgroup.app;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.fdmgroup.model.Company;
import com.fdmgroup.model.Role;
import com.fdmgroup.model.Stock;
import com.fdmgroup.model.User;

public class MainApp {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SpringMVCUploadAJAX");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		
		User u1 = new User("jdoe", "1234", "John", "Doe");
		User u2 = new User("asmith", "1234", "Alex", "Smith");
		User u3 = new User("dbowie", "1234", "David", "Bowie");
		
		Company c1 = new Company("Google", "Mountain View, CA", new Date(1998, 05, 01), new Stock("GGL", 100.0));
		Company c2 = new Company("Microsoft", "Redmond, WA", new Date(1980, 07, 01), new Stock("MS", 50.0));
		
		Role r1 = new Role("Admin");
		Role r2 = new Role("User");
		
		ArrayList<Role> roles1 = new ArrayList<Role>();
		ArrayList<Role> roles2 = new ArrayList<Role>();
		ArrayList<Role> roles3 = new ArrayList<Role>();
		
		roles1.add(r1);
		roles2.add(r2);
		roles3.add(r2);
		
		u1.setRoles(roles1);
		u2.setRoles(roles2);
		u3.setRoles(roles3);
		
		u1.setCompany(c1);
		u2.setCompany(c1);
		u3.setCompany(c2);

		em.persist(r1);
		em.persist(r2);
		
		em.persist(u1);
		em.persist(u2);
		em.persist(u3);
		
		tr.commit();
		
		System.out.println("Objects stored.");
		
		em.close();
		emf.close();
	}
}
