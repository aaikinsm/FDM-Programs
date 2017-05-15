package com.fdmgroup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fdmgroup.model.User;

public class UserDao {

	private DbConnection connection = null;
	
	public UserDao(){
		connection = DbConnection.getInstance();
	}
	
	public User create (User user){
		EntityManager em = connection.getEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		return user;
	}

	public User update (User user){
		EntityManager em = connection.getEntityManager();
		User foundUser = findById(user.getId());
		if (foundUser == null)
			return null;
		em.getTransaction().begin();
		if (user.getFirstname()!=null && !user.getFirstname().equals("")){
			foundUser.setFirstname(user.getFirstname());
		}
		if (user.getLastname()!=null && !user.getLastname().equals("")){
			foundUser.setLastname(user.getLastname());
		}
		if (user.getPassword()!=null && !user.getPassword().equals("")){
			foundUser.setPassword(user.getPassword());
		}
		em.getTransaction().commit();
		return foundUser;
	}
	
	
	public boolean remove(User user){
		EntityManager em = connection.getEntityManager();
		User foundUser = findById(user.getId());
		if (foundUser == null)
			return false;
		em.getTransaction().begin();
		em.remove(foundUser);
		em.getTransaction().commit();
		return true;
	}
	
	public User findById(int id){
		EntityManager em = connection.getEntityManager();
		User foundUser = em.find(User.class, id);
		return foundUser;
	}
	
	public List<User> findAll(){
		EntityManager em = connection.getEntityManager();
		TypedQuery<User> query = em.createNamedQuery("user.findAll",User.class);
		return query.getResultList();
	}

	public User findByUsername(String username){
		EntityManager em = connection.getEntityManager();
		TypedQuery<User> query = em.createNamedQuery("user.findByUsername",User.class);
		query.setParameter("uname", username);
		List<User> users =  query.getResultList();
		if(users.size()==1)
			return users.get(0);
		else 
			return null;
	}
	
	public List<User> findByCompanySize(int size){
		EntityManager em = connection.getEntityManager();
		TypedQuery<User> query = em.createNamedQuery("user.findUserByCompanySize",User.class);
		query.setParameter("size", size);
		
		return query.getResultList();
	}
}
