package com.asl.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.asl.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
    
		// Create Session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		// Create Session
		Session session = factory.getCurrentSession();
		
		try {
			// Create  a student Object
			System.out.println("Creating new student Object ....");
			Student tempStudent = new Student("SOuvik ","Biswas2","souvik2805@gmail.com3");
			
			//start a transaction
			session.beginTransaction();
			
			// save the transaction
			System.out.println("Saving the daatat");
			session.save(tempStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("DOne");
		}
		
		finally {
			factory.close();
		}
		

	}

}
