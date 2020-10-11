package com.asl.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.asl.hibernate.demo.entity.Instructor;
import com.asl.hibernate.demo.entity.InstructorDetail;


public class DeleteDemo {

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
			
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			if(tempInstructor != null) {
				System.out.println("DELETING :  "+tempInstructor);
				// Note :- Will also delete associated "delete obj"
				// Beacuse of cascadeType.All
				session.delete(tempInstructor);
			}
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("\n --- Done --- \n");
		}
		
		finally {
			factory.close();
		}
		

	}

}
