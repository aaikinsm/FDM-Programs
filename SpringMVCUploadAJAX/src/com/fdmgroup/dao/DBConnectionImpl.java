package com.fdmgroup.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBConnectionImpl implements DBConnection {

	EntityManager em = null;
	EntityManagerFactory emf = null;
	
	public DBConnectionImpl() {
		super();
		init();
	}
	
	public void init(){
		if (emf == null)
			emf = Persistence.createEntityManagerFactory("SpringMVCUploadAJAX");
		
		if (em == null)
			em = emf.createEntityManager();
		
		if (!em.isOpen())
			em = emf.createEntityManager();
		
		System.out.println("DBConnection initialized....");
	}

	public EntityManager getEntityManager() {
		if (em == null || !em.isOpen())
			init();
		
		return em;
	}

	public void close() {
		if (em != null && em.isOpen())
			em.close();
	}

}
