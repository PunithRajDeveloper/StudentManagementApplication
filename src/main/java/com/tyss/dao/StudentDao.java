package com.tyss.dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tyss.dto.Student;

public class StudentDao {

	public Student saveStudent(Student student) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("punith");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		return student;
	}

	public Student findStudentByEmail(String email) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("punith");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("Select s from Student s where s.email=?1");
		return (Student) query.setParameter(1, email).getSingleResult();

	}

	public List<Student> getAllStudents() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("punith");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("Select s from Student s");
		List<Student> students = query.getResultList();
		return students;
	}

	public Student findbyId(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("punith");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager.find(Student.class, id);
	}

	public void deleteStudentById(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("punith");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Student student = entityManager.find(Student.class, id);

		entityTransaction.begin();
		if (student != null) {
			entityManager.remove(student);
                             }
		entityTransaction.commit();

	}
}
