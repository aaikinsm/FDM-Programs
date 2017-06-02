package com.fdmgroup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fdmgroup.model.User;

public class UserJpaDao implements IStorage<User>{

	private static UserJpaDao userJpaDao = null;
	private DbConnection connection = null;
	private EntityManager em;
	
	
	public UserJpaDao() {
		super();
		connection = DbConnection.getInstance();
		em = connection.getEntityManager();
	}

	public static UserJpaDao getInstance(){
		if (userJpaDao == null){
			userJpaDao = new UserJpaDao();
		}
		return userJpaDao;
	}

	public User create (User user){
		if(!em.getTransaction().isActive())
			em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		return user;
	}

	public User update (User user){
		User foundUser = findById(user.getId());
		if (foundUser == null)
			return null;
		if(!em.getTransaction().isActive())
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
		return foundUser;
	}
	
	
	public boolean delete(User user){
		User foundUser = findById(user.getId());
		if (foundUser == null)
			return false;
		if(!em.getTransaction().isActive())
			em.getTransaction().begin();
		em.remove(foundUser);
		em.getTransaction().commit();
		return true;
	}
	
	public User findById(int id){
		User foundUser = em.find(User.class, id);
		return foundUser;
	}
	
	public List<User> findAll(){
		TypedQuery<User> query = em.createNamedQuery("user.findAll",User.class);
		List<User> users = query.getResultList();
		return users;
	}

	public User findByUsername(String username){
		TypedQuery<User> query = em.createNamedQuery("user.findByUsername",User.class);
		query.setParameter("uname", username);
		List<User> users =  query.getResultList();
		if(users.size()==1)
			return users.get(0);
		else 
			return null;
	}

}
