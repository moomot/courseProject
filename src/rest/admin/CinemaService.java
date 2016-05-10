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

import tables.Cinema;

@Path("/cinema")
public class CinemaService {
	
	@Path("/add")
	@POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String add(@FormParam("title") String title,
            @FormParam("halls") String halls,
            @FormParam("address") String address)
	{
		Cinema cinema = new Cinema(title, Integer.parseInt(halls), address);
		Factory factory = Factory.getInstance();
		CinemaDAO cinemaDAO = factory.getCinemaDAO();
		try {
			cinemaDAO.addCinema(cinema);
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
		CinemaDAO cinemaDAO = factory.getCinemaDAO();
		cinemaDAO.removeCinemaById(id);
		return "Успешно удалено!";
	}
}
