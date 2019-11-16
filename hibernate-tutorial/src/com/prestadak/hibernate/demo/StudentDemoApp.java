package com.prestadak.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.prestadak.hibernate.demo.entity.Student;

/**
 * @author Mohammed Ndiaye
 *
 */
public class StudentDemoApp {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Student.class)
											.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		Student student = new Student("Mohamadou", "Ndiaye", "mohamadou@prestadak.com");
		
		try {
			session.beginTransaction();
			
			session.save(student);
			
			session.getTransaction().commit();
		
		} finally {
			sessionFactory.close();
		}
		
		
	}

}
