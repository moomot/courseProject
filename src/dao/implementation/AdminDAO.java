package dao.implementation;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.sun.org.apache.xpath.internal.Expression;

import tables.Admin;
import util.HibernateUtil;
import dao.IAdminDAO;

public class AdminDAO implements IAdminDAO {

	@Override
	public void addAdmin(Admin admin) throws SQLException {
		Session session = null;
		try {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(admin);
		session.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if ( session != null && session.isOpen() ) session.close();
		}
	}

	@Override
	public void removeAdmin(Admin admin) throws SQLException {
		Session session = null;
		try {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(admin);
		session.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if ( session != null && session.isOpen() ) session.close();
		}
	}

	@Override
	public Admin getAdmin(int id) throws SQLException {
		Admin admin = null;
		Session session = null;
		try {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		admin = (Admin) session.load(Admin.class, id);
		session.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if ( session != null && session.isOpen() ) session.close();
		}
		return admin;
	}
	
	public Admin getAdminByLogin(String login) throws SQLException {
		Admin admin = null;
		Session session = null;
		try {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Admin.class);
		criteria.add(Restrictions.eq("login", login));
		List<Admin> list = criteria.list();
		System.out.println(list.toString());
		if(! list.isEmpty()) {
			admin = list.get(0);
		}
		session.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if ( session != null && session.isOpen() ) session.close();
		}
		return admin;
	}

	@Override
	public List<Admin> getAdmins() throws SQLException {
		List<Admin> admins = null;
		Session session = null;
		try {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		admins = session.createCriteria(Admin.class).list();
		session.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if ( session != null && session.isOpen() ) session.close();
		}
		return admins;
	}

}
