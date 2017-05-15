package com.fdmgroup.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fdmgroup.model.Exam;
import com.fdmgroup.model.Result;
import com.fdmgroup.model.User;

public class ExamCollectionDao implements IStorage<Exam>{
	private List<Result> resultList;
	private Map<Exam,ArrayList<Result>> resultsToExam;
	private Map<User,ArrayList<Result>> resultsForUser;
	private static ExamCollectionDao examCollectionDao = null;
	private DbConnection connection = null;
	
	private ExamCollectionDao() {
		super();
		resultList = new ArrayList<>();
		resultsToExam = new HashMap<>();
		resultsForUser = new HashMap<>();
		connection = DbConnection.getInstance();
	}

	public static ExamCollectionDao getInstance(){
		if (examCollectionDao == null){
			examCollectionDao = new ExamCollectionDao();
		}
		return examCollectionDao;
	}
	
	public boolean isExamAccessibleToUser(int examID, int userID){
		//:TODO
		return false;
	}
	
	public ArrayList<Result> getExamResults(Exam exam){
		//:TODO
		return resultsToExam.get(exam);
	}
	
	public void submitResult(Exam exam, Result result){
		//:TODO
		ArrayList<Result> rslt = resultsToExam.get(exam);
		rslt.add(result);
		resultsToExam.put(exam, rslt);
	}
	
	public Result getUserResult(User user, Exam exam){
		//:TODO
		ArrayList<Result> rslt = resultsForUser.get(user);
		for (Result result : rslt) {
			if(result.getExam() == exam){
				return result;
			}
		}
		return null;
	}

	@Override
	public Exam findById(int id) {
		EntityManager em = connection.getEntityManager();
		Exam foundExam = em.find(Exam.class, id);
		em.close();
		if (foundExam.isDeleted()) return null;
		return foundExam;
	}

	@Override
	public List<Exam> findAll() {
		EntityManager em = connection.getEntityManager();
		TypedQuery<Exam> query = em.createNamedQuery("exam.findAll",Exam.class);
		return query.getResultList();
	}

	@Override
	public Exam create(Exam exam) {
		EntityManager em = connection.getEntityManager();
		em.getTransaction().begin();
		em.persist(exam);
		em.getTransaction().commit();
		em.close();
		return exam;
	}

	@Override
	public Exam update(Exam e) {
		EntityManager em = connection.getEntityManager();
		Exam exam = findById(e.getId());
		if(exam != null){
			em.getTransaction().begin();
			if (!exam.getTitle().equals("")){
				exam.setTitle(exam.getTitle());
			}
			if (exam.getQuestions() != null){
				exam.setQuestions(exam.getQuestions());
			}
			exam.setDeleted(exam.isDeleted());
			exam.setRandomized(exam.isRandomized());
			exam.setTimer(exam.getTimer());
			em.getTransaction().commit();
		}
		em.close();
		return exam;
	}

	@Override
	public boolean delete(Exam e) {
		EntityManager em = connection.getEntityManager();
		Exam exam = findById(e.getId());
		if(exam == null)
			return false;
		em.getTransaction().begin();
		exam.setDeleted(true);
		em.getTransaction().commit();
		em.close();
		return true;
	}

}