package dao.implementation;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import tables.Admin;
import tables.Cinema;
import tables.Seans;
import util.HibernateUtil;
import dao.ISeansDAO;

public class SeansDAO implements ISeansDAO {

	@Override
	public void addSeans(Seans seans) throws SQLException {
		Session session = null;
		try {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(seans);
		session.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if ( session != null && session.isOpen() ) session.close();
		}
	}

	@Override
	public void removeSeans(Seans seans) throws SQLException {
		Session session = null;
		try {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(seans);
		session.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if ( session != null && session.isOpen() ) session.close();
		}
	}

	@Override
	public Seans getSeans(int id) throws SQLException {
		Seans seans = null;
		Session session = null;
		try {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		seans = (Seans) session.load(Seans.class, id);
		session.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if ( session != null && session.isOpen() ) session.close();
		}
		return seans;
	}

	@Override
	public List<Seans> getSeanses() throws SQLException {
		List<Seans> seanses = null;
		Session session = null;
		try {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		seanses = session.createCriteria(Seans.class).list();
		session.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if ( session != null && session.isOpen() ) session.close();
		}
		return seanses;
	}

}
