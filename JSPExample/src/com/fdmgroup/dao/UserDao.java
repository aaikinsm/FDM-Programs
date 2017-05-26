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
	
	
	public List<User> findAll(){
		EntityManager em = connection.getEntityManager();
		TypedQuery<User> query = em.createNamedQuery("user.findAll",User.class);
		return query.getResultList();
	}

	public User findUserByUsername(String username){
		EntityManager em = connection.getEntityManager();
		TypedQuery<User> query = em.createNamedQuery("user.findByUsername",User.class);
		query.setParameter("uname", username);
		List<User> users =  query.getResultList();
		if(users.size()==1)
			return users.get(0);
		else 
			return null;
	}
	
}
