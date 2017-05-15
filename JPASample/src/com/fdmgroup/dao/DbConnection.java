package com.fdmgroup.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DbConnection {

	private static DbConnection connection = null;
	private EntityManager em;
	private EntityManagerFactory emf;
	private DbConnection(){
		init();
	}
	
	private void init(){
		if (emf == null)
			emf = Persistence.createEntityManagerFactory("JPASample");
		em = emf.createEntityManager();
	}
	
	public static DbConnection getInstance(){
		if (connection == null)
			connection = new DbConnection();
		return connection;
	}
	
	public EntityManager getEntityManager(){
		if (em == null || !em.isOpen()){
			init();
		}
		return em;
	}
	
	public void close(){
		em.close();
	}
}
