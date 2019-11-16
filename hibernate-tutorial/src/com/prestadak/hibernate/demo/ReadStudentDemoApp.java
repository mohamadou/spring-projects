package com.prestadak.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.prestadak.hibernate.demo.entity.Student;

/**
 * @author Mohammed Ndiaye
 *
 */
public class ReadStudentDemoApp {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Student.class)
											.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		Student student = new Student("Mohamadou", "Ndiaye", "mohamadou@prestadak.com");
		Student student2 = new Student("John", "Doe", "john@prestadak.com");
		Student student3 = new Student("Mathie", "Vallic", "mathie@prestadak.com");
		
		try {
			session.beginTransaction();
			
			session.save(student);
			session.save(student2);
			session.save(student3);
			
			session.getTransaction().commit();
			
			
			// Read Data from DB
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			Student studentInfos = session.get(Student.class, 2);
			System.out.println("Student Infos:"+ studentInfos);
			session.getTransaction().commit();
		
		} finally {
			sessionFactory.close();
		}
		
		
	}

}
