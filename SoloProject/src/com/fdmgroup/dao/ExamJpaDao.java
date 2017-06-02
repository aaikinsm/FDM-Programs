package com.fdmgroup.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fdmgroup.model.Exam;
import com.fdmgroup.model.Question;
import com.fdmgroup.model.Result;
import com.fdmgroup.model.User;

public class ExamJpaDao implements IStorage<Exam>{
	private static ExamJpaDao examJpaDao = null;
	private DbConnection connection = null;
	EntityManager em = null;
	
	public ExamJpaDao() {
		super();
		connection = DbConnection.getInstance();
		em = connection.getEntityManager();
	}

	public static ExamJpaDao getInstance(){
		if (examJpaDao == null){
			examJpaDao = new ExamJpaDao();
		}
		return examJpaDao;
	}

	public List<Result> getExamResults(User user){
		TypedQuery<Exam> queryE = em.createNamedQuery("exam.findAllByCreator",Exam.class);
		queryE.setParameter("ecreator", user);
		List<Exam> allCreatedExams = queryE.getResultList();
		List<Result> combinedResults = new ArrayList<>();
		for (Exam exam2 : allCreatedExams) {
			TypedQuery<Result> query = em.createNamedQuery("result.findExamResults",Result.class);
			query.setParameter("rexam", exam2);
			combinedResults.addAll(query.getResultList());			
		}
		return combinedResults;
	}	
	
	public List<Result> getUserResults(User user){
		TypedQuery<Result> query = em.createNamedQuery("result.findUserResults",Result.class);
		query.setParameter("ruser", user);
		return query.getResultList();
	}

	@Override
	public Exam findById(int id) {
		Exam foundExam = em.find(Exam.class, id);
		if (foundExam.isDeleted()==1) 
			return null;		
		return foundExam;
	}

	public List<Exam> findByAuthor(User user) {
		TypedQuery<Exam> queryE = em.createNamedQuery("exam.findAllByCreator",Exam.class);
		queryE.setParameter("ecreator", user);
		List<Exam> allCreatedExams = queryE.getResultList();
		return allCreatedExams;
	}
	
	
	@Override
	public List<Exam> findAll() {
		TypedQuery<Exam> query = em.createNamedQuery("exam.findAll",Exam.class);
		return query.getResultList();
	}

	@Override
	public Exam create(Exam exam) {
		if(!em.getTransaction().isActive())
			em.getTransaction().begin();
		em.persist(exam);
		for (Question q : exam.getQuestions()) {
			q.setExam(exam);
			em.persist(q);
		}
		em.getTransaction().commit();
		return exam;
	}

	@Override
	public Exam update(Exam e) {
		Exam exam = findById(e.getId());
		if(exam != null){
			if(!em.getTransaction().isActive())
				em.getTransaction().begin();
			if (!exam.getTitle().equals("")){
				exam.setTitle(exam.getTitle());
			}
			exam.setDeleted(exam.isDeleted());
			exam.setRandomized(exam.isRandomized());
			exam.setTimer(exam.getTimer());
			em.getTransaction().commit();
		}
		return exam;
	}

	@Override
	public boolean delete(Exam e) {
		Exam exam = findById(e.getId());
		if(exam == null)
			return false;
		if(!em.getTransaction().isActive())
			em.getTransaction().begin();
		exam.setDeleted(1);
		em.getTransaction().commit();
		return true;
	}
	
	public Result addResult(Result result) {
		if(!em.getTransaction().isActive())
			em.getTransaction().begin();
		em.persist(result);
		em.getTransaction().commit();
		return result;
	}


}
