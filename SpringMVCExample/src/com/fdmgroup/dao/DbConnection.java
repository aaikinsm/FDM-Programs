package com.fdmgroup.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DbConnection {


	private EntityManager em;
	private EntityManagerFactory emf;
	
	
	public DbConnection(){
	}
	
	public void init(){
		if (emf == null )
			emf = Persistence.createEntityManagerFactory("SpringMVCExample");
		em = emf.createEntityManager();
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
