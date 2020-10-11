package com.asl.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.asl.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
    
		// Create Session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		// Create Session
		Session session = factory.getCurrentSession();
		
		try {
	
			//start a transaction
			session.beginTransaction();
		    
			List<Student> theStudents = session.createQuery("from Student").list();
			 
			displayStudents(theStudents);
			
			// commit the transaction
			theStudents = session.createQuery("from Student s where s.firstName = 'Nabadwip '").getResultList();
			System.out.println("\n\n Student who have first name Nabadwip");
			displayStudents(theStudents);
			
			session.getTransaction().commit();
			
			System.out.println("\nDone\n\n");
		}
		
		finally {
			factory.close();
		}
		

	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
