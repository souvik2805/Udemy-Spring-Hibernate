package com.asl.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.asl.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
    
		// Create Session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		// Create Session
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 1;
			
			//start a transaction
			session.beginTransaction();
			Student myStudent = session.get(Student.class, studentId);
			myStudent.setFirstName("UPDATED FirstName");
		    //--------------------
			
            //change all email by HQL
			session.createQuery("update Student set email='souvik@gmail.com'").executeUpdate();
			
			
			// commit the transaction
			session.getTransaction().commit();
			
			// Read the Data
			
			System.out.println("DOne");
		}
		
		finally {
			factory.close();
		}
		

	}

}
