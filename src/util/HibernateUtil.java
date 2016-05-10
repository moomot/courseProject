package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import tables.Admin;
import tables.Cinema;
import tables.Hall;
import tables.Movie;
import tables.Seans;



@SuppressWarnings("deprecation")
public class HibernateUtil {
	private static SessionFactory sessionFactory = 
		new Configuration()
		.configure()
		.addAnnotatedClass(Cinema.class)
		.addAnnotatedClass(Movie.class)
		.addAnnotatedClass(Seans.class)
		.addAnnotatedClass(Hall.class)
		.addAnnotatedClass(Admin.class)
		.buildSessionFactory();
	
	private HibernateUtil() {}
	
	
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
