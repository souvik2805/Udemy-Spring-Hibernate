package com.asl.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.asl.hibernate.demo.entity.Course;
import com.asl.hibernate.demo.entity.Instructor;
import com.asl.hibernate.demo.entity.InstructorDetail;


public class DeleteCourseDemo {

	public static void main(String[] args) {
    
		// Create Session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		// Create Session 
		Session session = factory.getCurrentSession();
		 
		try {
			//start a transaction
			session.beginTransaction();
		    
			//get a course
			int theId = 1;
			Course tempCourse = session.get(Course.class, theId);
			System.out.println("Deleting course : "+tempCourse);
			
			session.delete(tempCourse);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("\n --- Done --- \n");
		}
		
		finally {
			factory.close();
		}
		

	}

}
