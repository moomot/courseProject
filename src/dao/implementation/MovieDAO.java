package dao.implementation;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import tables.Admin;
import tables.Cinema;
import tables.Hall;
import tables.Movie;
import util.HibernateUtil;
import dao.IMovieDAO;

public class MovieDAO implements IMovieDAO {

	@Override
	public void addMovie(Movie movie) throws SQLException {
		Session session = null;
		try {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(movie);
		session.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if ( session != null && session.isOpen() ) session.close();
		}
	}

	@Override
	public void removeMovie(Movie movie) throws SQLException {
		Session session = null;
		try {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(movie);
		session.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if ( session != null && session.isOpen() ) session.close();
		}

	}

	@Override
	public Movie getMovie(int id) throws SQLException {
		Movie movie = null;
		Session session = null;
		try {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		movie = (Movie) session.load(Movie.class, id);
		session.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if ( session != null && session.isOpen() ) session.close();
		}
		return movie;
	}

	@Override
	public List<Movie> getMovies() throws SQLException {
		List<Movie> movies = null;
		Session session = null;
		try {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		movies = session.createCriteria(Movie.class).list();
		session.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if ( session != null && session.isOpen() ) session.close();
		}
		return movies;
	}

	public void removeMovieById(int id) {
		Session session = null;
		try {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Movie movie = session.get(Movie.class, id);
		if (movie == null) {
			session.getTransaction().rollback();
			return;
		}
		session.delete(movie);
		session.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if ( session != null && session.isOpen() ) session.close();
		}
		
	}

}
