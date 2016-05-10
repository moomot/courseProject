package dao.implementation;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import tables.Admin;
import tables.Cinema;
import util.HibernateUtil;
import dao.ICinemaDAO;

public class CinemaDAO implements ICinemaDAO {

	@Override
	public void addCinema(Cinema cinema) throws SQLException {
		Session session = null;
		try {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(cinema);
		session.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if ( session != null && session.isOpen() ) session.close();
		}
	}

	@Override
	public void removeCinema(Cinema cinema) throws SQLException {
		Session session = null;
		try {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(cinema);
		session.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if ( session != null && session.isOpen() ) session.close();
		}

	}

	@Override
	public Cinema getCinema(int id) throws SQLException {
		Cinema cinema = null;
		Session session = null;
		try {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		cinema = (Cinema) session.load(Cinema.class, id);
		session.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if ( session != null && session.isOpen() ) session.close();
		}
		return cinema;
	}

	@Override
	public List<Cinema> getCinemas() throws SQLException {
		List<Cinema> cinemas = null;
		Session session = null;
		try {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		cinemas = session.createCriteria(Cinema.class).list();
		session.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if ( session != null && session.isOpen() ) session.close();
		}
		return cinemas;
	}

	public void removeCinemaById(int id) {
		Session session = null;
		try {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Cinema cinema = session.get(Cinema.class, id);
		if (cinema == null) {
			session.getTransaction().rollback();
			return;
		}
		session.delete(cinema);
		session.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if ( session != null && session.isOpen() ) session.close();
		}
		
	}

}
