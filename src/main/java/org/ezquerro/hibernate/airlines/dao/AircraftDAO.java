/**
 * 
 */
package org.ezquerro.hibernate.airlines.dao;

import java.util.List;

import org.ezquerro.hibernate.airlines.HibernateSession;
import org.ezquerro.hibernate.airlines.models.Aircraft;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * implementation of countryDAOInterface
 * @author Eugenia Pérez
 * @email eugenia_perez@cuatrovientos.org
 */
public class AircraftDAO implements AircraftDAOInterface {

	
	public Aircraft selectById(Long id) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    Aircraft aircraft = (Aircraft) session.get(Aircraft.class, id);
	    
	    session.close();
	    return aircraft;
	}


	public List<Aircraft> selectAll() {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    List<Aircraft> aircrafts = session.createQuery("from Aircraft").list();
	    
	    session.close();
	    return aircrafts;
	}
	

	
	public void insert(Aircraft aircraft) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	 
	    session.persist(aircraft);    
	    
	    session.getTransaction().commit();	         
	    session.close();

	}

	public void update(Aircraft aircraft) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		    Session session = sessionFactory.openSession();	 
		    session.beginTransaction();
		 
		    session.merge(aircraft); 
		    
		    session.getTransaction().commit();		 
		    session.close();
	}
	

	public void delete(Aircraft aircraft) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();	    
	    session.beginTransaction();
	    
	    session.delete(aircraft);
	 
	    session.getTransaction().commit();
	    session.close();
	}

}
