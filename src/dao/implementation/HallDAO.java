package dao.implementation;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import tables.Admin;
import tables.Cinema;
import tables.Hall;
import util.HibernateUtil;
import dao.IHallDAO;

public class HallDAO implements IHallDAO {

	@Override
	public void addHall(Hall hall) throws SQLException {
		Session session = null;
		try {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(hall);
		session.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if ( session != null && session.isOpen() ) session.close();
		}
	}

	@Override
	public void removeHall(Hall hall) throws SQLException {
		Session session = null;
		try {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(hall);
		session.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if ( session != null && session.isOpen() ) session.close();
		}

	}

	@Override
	public Hall getHall(int id) throws SQLException {
		Hall hall = null;
		Session session = null;
		try {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		hall = (Hall) session.load(Hall.class, id);
		session.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if ( session != null && session.isOpen() ) session.close();
		}
		return hall;
	}

	@Override
	public List<Hall> getHalls() throws SQLException {
		List<Hall> halls = null;
		Session session = null;
		try {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		halls = session.createCriteria(Hall.class).list();
		session.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if ( session != null && session.isOpen() ) session.close();
		}
		return halls;
	}

}
