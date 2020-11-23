package com;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

public class SingleProjection {
	/**
	  * @param args
	  */
	 public static void main(String[] args) 
	 {
	  SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	  Session session = sessionFactory.openSession();
	  session.beginTransaction();
	  //Select Course from Student;
	  Criteria criteria = session.createCriteria(Student.class);
	  
	  Projection myProjection = Projections.property("course");
	  criteria.setProjection(myProjection);
	  
	  List list = criteria.list();
	 
	  for(Object student : list) {
			 System.out.println(student);
			 
		 }
	  
	  session.getTransaction().commit();
	  session.close();
	  sessionFactory.close();
	 }
}
