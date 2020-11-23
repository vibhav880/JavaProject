package com;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;

import com.Student;


public class CriteriaTest {

 /**
  * @param args
  */
 public static void main(String[] args) 
 {
  SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
  Session session = sessionFactory.openSession();
  session.beginTransaction();
  // session.createCriteria -- Select * from 
  Criteria criteria = session.createCriteria(Student.class);
 // criteria.add(Restrictions.eq("studentName", "Vibhav"));
  
 // criteria.add(Restrictions.lt("rollNumber", 55));
//criteria.add(Restrictions.gt("rollNumber", 55));

//criteria.add(Restrictions.le("rollNumber", 56));
//criteria.add(Restrictions.ge("rollNumber", 56));
//criteria.add(Restrictions.ne("rollNumber", 56));
  
  //in clause
  //criteria.add(Restrictions.in("rollNumber", new Integer[]{99,56,7}));
  
  
  //or clause combining two or more criteria
  //criteria.add(Restrictions.or(Restrictions.gt("rollNumber", 60), Restrictions.eq("course", "PCBM")));
  
  
  //not in  SELECT * FROM student WHERE rollNumber NOT IN (4,99,56);
  //criteria.add(Restrictions.not(Restrictions.in("rollNumber", new Integer[]{4,99,56})));
  
  //between
  //criteria.add(Restrictions.between("rollNumber", 3, 90));
  
  // SELECT * FROM student WHERE studentName IS NULL;
  
  //criteria.add(Restrictions.isNotNull("studentName"));
  
  List<Student> students  = criteria.list();
  
  for(Student student : students)
  {
   System.out.println(student);
  }
  session.getTransaction().commit();
  session.close();
  sessionFactory.close();
 }

}