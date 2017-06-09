package com.fdmgroup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.model.User;

public class UserDAO {

	@Autowired
	private DBConnection dbConnection;
	
	public List<User> findAll(){
		EntityManager em = dbConnection.getEntityManager();
		TypedQuery<User> query = em.createNamedQuery("user.findAll", User.class);
		List<User> users = (List<User>) query.getResultList();
				
		return users;
	}
	
	public User finUserByUsername(String username){
		EntityManager em = dbConnection.getEntityManager();
		TypedQuery<User> query = em.createNamedQuery("user.findByUsername", User.class);
		query.setParameter("username", username);
		List<User> users = (List<User>) query.getResultList();
		if (users != null && users.size() == 1){
			return users.get(0);
		}
		
		return null;
	}
	
	public List<User> findUserByName(String name){
		EntityManager em = dbConnection.getEntityManager();
		TypedQuery<User> query = em.createNamedQuery("user.findByName", User.class);
		query.setParameter("name", name + "%");
		List<User> users = (List<User>) query.getResultList();
				
		return users;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> findUserByNameAndCompany(String nameOrCompany){
		EntityManager em = dbConnection.getEntityManager();
		Query query = em.createNamedQuery("user.findByNameOrCompany");
		query.setParameter("name", nameOrCompany + "%");
		List<User> users = (List<User>) query.getResultList();
				
		return users;
	}
	
	public User findUserById(int id){
		EntityManager em = dbConnection.getEntityManager();
		return em.find(User.class, id);
	}
	
	public void createUser(User u){
		EntityManager em = dbConnection.getEntityManager();
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
	}
	
	public void updateUser(int id, User u){
		User foundUser = findUserById(id);
		EntityManager em = dbConnection.getEntityManager();
		em.getTransaction().begin();
		
		if (u.getEmail() != null && !u.getEmail().equals("")){
			foundUser.setEmail(u.getEmail());
		}
		
		if (u.getFirstname() != null && !u.getFirstname().equals("")){
			foundUser.setFirstname(u.getFirstname());
		}
		
		if (u.getLastname() != null && !u.getLastname().equals("")){
			foundUser.setLastname(u.getLastname());
		}
		
		if (u.getPassword() != null && !u.getPassword().equals("")){
			foundUser.setPassword(u.getPassword());
		}
			
		em.getTransaction().commit();
	}
	
	public void deleteUser(User u){
		EntityManager em = dbConnection.getEntityManager();
		em.getTransaction().begin();
		em.remove(u);
		em.getTransaction().commit();
	}
	
	public User deleteUser(int id){
		User foundUser = findUserById(id);
		deleteUser(foundUser);
		
		return foundUser;
	}
}
