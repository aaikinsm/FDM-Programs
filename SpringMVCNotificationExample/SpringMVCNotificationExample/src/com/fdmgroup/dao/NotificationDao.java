package com.fdmgroup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.model.Notification;
import com.fdmgroup.model.User;

public class NotificationDao {

	@Autowired
	private DBConnection dbConnection;
	
	public List<Notification> findByUser(User user){
		EntityManager em = dbConnection.getEntityManager();
		TypedQuery<Notification> query = em.createNamedQuery("notification.findByUser", Notification.class);
		query.setParameter("usr", user);
		List<Notification> notifications = (List<Notification>) query.getResultList();
				
		return notifications;
	}
}
