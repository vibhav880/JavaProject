package com;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.Student;


public class ProjectionTest {

 /**
  * @param args
  */
 public static void main(String[] args) 
 {
  SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
  Session session = sessionFactory.openSession();
  session.beginTransaction();
  
  Criteria criteria = session.createCriteria(Student.class);
 
  Projection projection1 = Projections.property("studentName"); 
  Projection projection2 = Projections.property("rollNumber"); 
  
  
  ProjectionList list= Projections.projectionList();
  
  list.add(projection1);
  list.add(projection2);
  criteria.setProjection(list); 
  
  
  List<Object[]> students  = criteria.list();
  
	
		 for(Object[] student : students) {
			 System.out.println(student[0]+"--"+student[1]);
			 
		 }
		 


  session.getTransaction().commit();
  session.close();
  sessionFactory.close();
 }

}
