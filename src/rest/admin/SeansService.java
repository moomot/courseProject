package rest.admin;

import java.sql.SQLException;

import general.Factory;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.SessionFactory;

import dao.implementation.AdminDAO;
import dao.implementation.CinemaDAO;
import dao.implementation.HallDAO;
import dao.implementation.MovieDAO;
import dao.implementation.SeansDAO;

import tables.Cinema;
import tables.Hall;
import tables.Movie;
import tables.Seans;

@Path("/seans")
public class SeansService {
	
	@Path("/add")
	@POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String add(@FormParam("cinemaId") String cinemaId,
            @FormParam("hallId") String hallId,
            @FormParam("movieId") String movieId,
            @FormParam("datetime") String datetime,
            @FormParam("price") String price,
            @FormParam("free_seats") String free_seats,
            @FormParam("occupied_seats") String occupied_seats) throws NumberFormatException, SQLException
	{
	
		Factory factory = Factory.getInstance();
		CinemaDAO cinemaDAO = factory.getCinemaDAO();
		HallDAO hallDAO = factory.getHallDAO();
		MovieDAO movieDAO = factory.getMovieDAO();
		
		Cinema cinema = cinemaDAO.getCinema(Integer.parseInt(cinemaId));
		Hall hall = hallDAO.getHall(Integer.parseInt(hallId));
		Movie movie = movieDAO.getMovie(Integer.parseInt(movieId));
		
		SeansDAO seansDAO = factory.getSeansDAO();
		Seans seans = null;
		try {
			seans = new Seans(hall, cinema, movie, datetime, price, Integer.parseInt(free_seats), Integer.parseInt(occupied_seats));
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			seansDAO.addSeans(seans);
		} catch (SQLException e) {
			e.printStackTrace();
			return "Ошибка при добавлении";
		}
		return "Успешно добавлено";
	}
	
	@Path("/remove/{id}")
	@GET
	public String remove(@PathParam("id") int id)
	{
		Factory factory = Factory.getInstance();
		SeansDAO seansDAO = factory.getSeansDAO();
		try {
			seansDAO.removeSeans(seansDAO.getSeans(id));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Успешно удалено!";
	}
}
