package com.asl.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.asl.hibernate.demo.entity.Course;
import com.asl.hibernate.demo.entity.Instructor;
import com.asl.hibernate.demo.entity.InstructorDetail;


public class CreateCoursesDemo {

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
		    
			int theId = 5 ;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			//Create some courses
			Course tempCourse1 = new Course("JAVA Hiberneat - Ultimate Guide");
			Course tempCourse2 = new Course("PYTHON 2.7 Detpth");
			
			// Add course to the Instructor
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);
			
			// save the courses
			session.save(tempCourse1);
			session.save(tempCourse2);
			
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("\n --- Done --- \n");
		}
		
		finally {
			factory.close();
		}
		

	}

}
