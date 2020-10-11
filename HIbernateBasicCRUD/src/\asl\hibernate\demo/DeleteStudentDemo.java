package com.asl.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.asl.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
    
		// Create Session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		// Create Session
		Session session = factory.getCurrentSession();
		
		try {
			
			//start a transaction
			session.beginTransaction();
			
			int studentId = 3;
		
			Student myStudent = session.get(Student.class, studentId);
			session.delete(myStudent);
			
			//Delete method 2
			session.createQuery("delete from Student where id=1").executeUpdate();
			session.getTransaction().commit();
			
			System.out.println("DOne");
		}
		
		finally {
			factory.close();
		}
		

	}

}
