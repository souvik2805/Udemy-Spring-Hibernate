package com.asl.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.asl.hibernate.demo.entity.Instructor;
import com.asl.hibernate.demo.entity.InstructorDetail;


public class GetInstructorDetailDemo {

	public static void main(String[] args) {
    
		// Create Session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		// Create Session
		Session session = factory.getCurrentSession();
		
		try {
			
			//start a transaction
			session.beginTransaction();
			int theId = 299;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			
			System.out.println("TempInstructorDetails = "+tempInstructorDetail);
			
			System.out.println("The associated instructor = "+tempInstructorDetail.getInstructor());
			
			session.getTransaction().commit();
			
			System.out.println("\n --- Done --- \n");
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		
		finally {
			session.close();
			factory.close();
		}
		

	}

}
