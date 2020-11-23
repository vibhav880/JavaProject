package com;

import java.util.List;

import com.Student;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Projections;

public class AggregateFunction {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		 SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		  Session session = sessionFactory.openSession();
		  session.beginTransaction();

		Object object;

		try {
			// Max Projection
			
			//Select max(rollNumber) from Student
			Criteria criteria = session.createCriteria(Student.class);
			criteria.setProjection(Projections.max("rollNumber"));
			List list = criteria.list();
			System.out.println("Max Roll No is = " + list.get(0));

			// Min Projection
			Criteria criteriaMin = session.createCriteria(Student.class);
			criteriaMin.setProjection(Projections.min("rollNumber"));
			List minList = criteriaMin.list();
			System.out.println("Minimum Roll No is = " + minList.get(0));

			// rowCount Projection
			Criteria criteriaRowCount = session.createCriteria(Student.class);
			criteriaRowCount.setProjection(Projections.rowCount());
			List rowCountList = criteriaRowCount.list();
			System.out.println("Total No of Student is = " + rowCountList.get(0));

			session.getTransaction().commit();
		} catch (HibernateException e) {

			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}

	}
}
