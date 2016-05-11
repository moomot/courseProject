package rest.admin;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import general.Factory;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.SessionFactory;

import dao.implementation.AdminDAO;
import dao.implementation.CinemaDAO;
import dao.implementation.HallDAO;
import dao.implementation.MovieDAO;

import tables.Cinema;
import tables.Hall;
import tables.Movie;

@Path("/movie")
public class MovieService {
	
	@Path("/add")
	@POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String add(@FormParam("name") String name,
            @FormParam("description") String description,
            @FormParam("duration") String duration,
            @FormParam("earned_money") String earned_money,
            @FormParam("producer") String producer,
            @FormParam("genres") String genres,
            @FormParam("rating") String rating)
	{
	
		Factory factory = Factory.getInstance();
		MovieDAO movieDAO = factory.getMovieDAO();
		Movie movie = null;
		try {
			movie = new Movie(name, description, duration, earned_money, producer, genres, Integer.parseInt(rating));
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			movieDAO.addMovie(movie);
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
		MovieDAO movieDAO = factory.getMovieDAO();
		movieDAO.removeMovieById(id);
		return "Успешно удалено!";
	}
	
	@Path("/getMovies")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@GET
	public List<Movie> getMovies()
	{
		Factory factory = Factory.getInstance();
		MovieDAO movieDAO = factory.getMovieDAO();
		List<Movie> movies = null;
		try {
			movies = movieDAO.getMovies();
			for (Iterator iterator = movies.iterator(); iterator.hasNext();) {
				Movie movie = (Movie) iterator.next();
				movie.setSeanses(null);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return movies;
	}
}
