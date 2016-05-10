package general;

import dao.IAdminDAO;
import dao.implementation.*;

public class Factory {
	public static Factory instance = new Factory();
	public CinemaDAO cinemaDAO;
	public HallDAO hallDAO;
	public MovieDAO movieDAO;
	public SeansDAO seansDAO;
	public AdminDAO adminDAO;
	
	private Factory() {}
	
	public static Factory getInstance() {
		return instance;
	}
	
	public CinemaDAO getCinemaDAO()
	{
		if (cinemaDAO == null) cinemaDAO = new CinemaDAO();
		return cinemaDAO;
	}

	public HallDAO getHallDAO() {
		if (hallDAO == null) hallDAO = new HallDAO();
		return hallDAO;
	}
	
	public MovieDAO getMovieDAO() {
		if (movieDAO == null) movieDAO = new MovieDAO();
		return movieDAO;
	}
	
	public SeansDAO getSeansDAO() {
		if (seansDAO == null) seansDAO = new SeansDAO();
		return seansDAO;
	}
	
	public AdminDAO getAdminDAO() {
		if (adminDAO == null) adminDAO = new AdminDAO();
		return adminDAO;
	}
	
}
