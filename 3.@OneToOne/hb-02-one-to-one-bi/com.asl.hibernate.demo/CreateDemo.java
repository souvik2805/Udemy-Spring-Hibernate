package com.asl.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.asl.hibernate.demo.entity.Instructor;
import com.asl.hibernate.demo.entity.InstructorDetail;


public class CreateDemo {

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
			
			Instructor tempInstructor = new Instructor("Souvik","Biswas","souvik2805@gmail.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("www.youtube.com/souvik","Swiming");
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			
			//start a transaction
			session.beginTransaction();
			
			// Note : - This is will also save the Details Object
			// Because of CascadeType.ALL
			session.save(tempInstructor);
			
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("\n --- Done --- \n");
		}
		
		finally {
			factory.close();
		}
		

	}

}
