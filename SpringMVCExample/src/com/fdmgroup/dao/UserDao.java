package com.fdmgroup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.model.User;

public class UserDao {

	@Autowired
	private DbConnection dbConnection = null;
	
	public UserDao(){
		super();
	}
	
	
	public DbConnection getDbConnection() {
		return dbConnection;
	}


	public void setDbConnection(DbConnection dbConnection) {
		this.dbConnection = dbConnection;
	}


	public List<User> findAll(){
		EntityManager em = dbConnection.getEntityManager();
		TypedQuery<User> query = em.createNamedQuery("user.findAll",User.class);
		return query.getResultList();
	}

	public User findUserByUsername(String username){
		EntityManager em = dbConnection.getEntityManager();
		TypedQuery<User> query = em.createNamedQuery("user.findByUsername",User.class);
		query.setParameter("uname", username);
		List<User> users =  query.getResultList();
		if(users.size()==1)
			return users.get(0);
		else 
			return null;
	}
	
}
