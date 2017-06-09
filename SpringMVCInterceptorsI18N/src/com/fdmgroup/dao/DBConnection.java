package com.fdmgroup.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBConnection {
	
	private static final String JPA_UNIT = "SpringMVCInterceptorsI18N";
	private static DBConnection dbConnection = null;
	private static EntityManagerFactory emf = null;
	private static EntityManager em = null;
	
	public DBConnection(){
	}
	
	private void init(){
		if (dbConnection == null)
			dbConnection = new DBConnection();
		
		if (emf == null || !emf.isOpen()){
			emf = Persistence.createEntityManagerFactory(JPA_UNIT);
		}
		
		if (em == null || !em.isOpen()){
			em = emf.createEntityManager();
		}
	}
	
	public EntityManager getEntityManager(){
		return em;
	}
	
	public void closeAll(){
		if (em != null && em.isOpen())
			em.close();
		
		if (emf != null && emf.isOpen())
			emf.close();
	}
}






















