package com.fdmgroup.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fdmgroup.model.User;

public class UserCollectionDao implements IStorage<User>{

	private static UserCollectionDao userCollectionDao = null;
	private DbConnection connection = null;
	
	
	private UserCollectionDao() {
		super();
		connection = DbConnection.getInstance();
	}

	public static UserCollectionDao getInstance(){
		if (userCollectionDao == null){
			userCollectionDao = new UserCollectionDao();
		}
		return userCollectionDao;
	}

	public User create (User user){
		EntityManager em = connection.getEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();
		return user;
	}

	public User update (User user){
		EntityManager em = connection.getEntityManager();
		User foundUser = findById(user.getId());
		if (foundUser == null)
			return null;
		em.getTransaction().begin();
		if (user.getFirstName()!=null && !user.getFirstName().equals("")){
			foundUser.setFirstName(user.getFirstName());
		}
		if (user.getLastName()!=null && !user.getLastName().equals("")){
			foundUser.setLastName(user.getLastName());
		}
		if (user.getPassword()!=null && !user.getPassword().equals("")){
			foundUser.setPassword(user.getPassword());
		}
		em.getTransaction().commit();
		em.close();
		return foundUser;
	}
	
	
	public boolean delete(User user){
		EntityManager em = connection.getEntityManager();
		User foundUser = findById(user.getId());
		if (foundUser == null)
			return false;
		em.getTransaction().begin();
		em.remove(foundUser);
		em.getTransaction().commit();
		em.close();
		return true;
	}
	
	public User findById(int id){
		EntityManager em = connection.getEntityManager();
		User foundUser = em.find(User.class, id);
		em.close();
		return foundUser;
	}
	
	public List<User> findAll(){
		EntityManager em = connection.getEntityManager();
		TypedQuery<User> query = em.createNamedQuery("user.findAll",User.class);
		List<User> users = query.getResultList();
		em.close();
		return users;
	}

	public User findByUsername(String username){
		EntityManager em = connection.getEntityManager();
		TypedQuery<User> query = em.createNamedQuery("user.findByUsername",User.class);
		query.setParameter("uname", username);
		List<User> users =  query.getResultList();
		em.close();
		if(users.size()==1)
			return users.get(0);
		else 
			return null;
	}

}
