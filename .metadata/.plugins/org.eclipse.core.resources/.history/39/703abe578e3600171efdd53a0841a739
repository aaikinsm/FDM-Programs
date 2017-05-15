package com.fdmgroup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.fdmgroup.dao.DbConnection;
import com.fdmgroup.dao.UserDao;
import com.fdmgroup.model.Company;
import com.fdmgroup.model.Role;
import com.fdmgroup.model.Stock;
import com.fdmgroup.model.User;
import com.fdmgroup.model.UserProfile;

public class EnhancedJpaApp {

	public static void main(String[] args) {
		/*EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPASample");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		
		Role r1 = new Role("Admin");
		Role r2 = new Role("Super User");
		Role r3 = new Role("User");

		User u1 = new User("jDoe", "1234", "John", "Doe", new UserProfile("Toronto, ON", 10, "569-989-656"));
		User u2 = new User("mmingi", "6322", "Michelle", "Mingi", new UserProfile("Toronto, ON", 18, "785-548-645"));
		User u3 = new User("thussain", "18543", "Taha", "Hussain", new UserProfile("Toronto, ON", 18, "343-233-652"));
		
		List<Role> roles1 = new ArrayList<Role>();
		List<Role> roles2 = new ArrayList<Role>();
		List<Role> roles3 = new ArrayList<Role>();
		
		roles1.add(r1);
		roles2.add(r2);
		roles2.add(r3);
		roles3.add(r3);
		
		u1.setRoles(roles1);
		u2.setRoles(roles2);
		u3.setRoles(roles3);
		
		Company c1 = new Company("Google", "Mountain View CA", new Date(1998, 8, 1), 150000, new Stock("GGL"));
		Company c2 = new Company("Microsoft", "Redmond WA", new Date(1976, 5, 1), 200000, new Stock("MS"));
		Company c3 = new Company("Yahoo!", "Sunnyville CA", new Date(1994, 10, 1), 400000, new Stock("Y!"));
		
		UserDao userDao = new UserDao();
		userDao.create(u1);
		userDao.create(u2);
		userDao.create(u3);
		
		System.out.println("Objects Created");
		/*
		
		UserDao userDao = new UserDao();
		User u = new User();
		u.setId(1);
		
		userDao.remove(u);
		/*u.setPassword("12312434");
		u.setLastname("Smith");

		
		userDao.update(u);*/
		UserDao userDao = new UserDao();
		List<User> users = userDao.findAll();
		for (User user : users) {
			System.out.println(user);
		}
		
		System.out.println("---------------------------------------");
		User michelle = userDao.findByUsername("mmingi");
		System.out.println(michelle.getCompany().getName());
		
		System.out.println("---------------------------------------");
		EntityManager em = DbConnection.getInstance().getEntityManager();
		Company founCompany = em.find(Company.class, 2);
		System.out.println(founCompany);

		System.out.println("---------------------------------------");
		TypedQuery<Company> query = em.createNamedQuery("company.findBySize", Company.class);
		query.setParameter("size", 149000);
		List<Company> companies =  query.getResultList();
		for (Company company : companies) {
			System.out.println(company);
		}
		
		
		DbConnection.getInstance().close();
		System.out.println("Done");
	}
}
