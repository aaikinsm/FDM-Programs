package com.fdmgroup.dao;

import javax.persistence.EntityManager;

public interface DBConnection {
	public EntityManager getEntityManager();
	public void close();
}
