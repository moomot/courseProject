package rest.admin;

import java.sql.SQLException;
import java.util.Iterator;
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

import tables.Cinema;
import tables.Hall;

@Path("/hall")
public class HallService {
	
	@Path("/add")
	@POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String add(@FormParam("name") String name,
            @FormParam("number_of_seats") String number_of_seats,
            @FormParam("cinemaId") String cinemaId)
	{
	
		Factory factory = Factory.getInstance();
		CinemaDAO cinemaDAO = factory.getCinemaDAO();
		Hall hall = null;
		try {
			hall = new Hall(name, Integer.parseInt(number_of_seats), cinemaDAO.getCinema(Integer.parseInt(cinemaId)));
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		HallDAO hallDAO = factory.getHallDAO();
		try {
			hallDAO.addHall(hall);
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
		HallDAO hallDAO = factory.getHallDAO();
		hallDAO.removeHallById(id);
		return "Успешно удалено!";
	}
	
	@Path("/getHalls/{cinemaID}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@GET
	public Set<Hall> getHalls(@PathParam("cinemaID") int cinemaID)
	{
		Factory factory = Factory.getInstance();
		CinemaDAO cinemaDAO = factory.getCinemaDAO();
		Set<Hall> halls = null;
		try {
			halls = cinemaDAO.getCinema(cinemaID).getHallSet();
			for (Iterator iterator = halls.iterator(); iterator.hasNext();) {
				Hall hall = (Hall) iterator.next();
				hall.setSeanses(null);
				hall.setCinema(null);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return halls;
	}
}
