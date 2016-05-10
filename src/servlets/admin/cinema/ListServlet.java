package servlets.admin.cinema;

import general.Factory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tables.Cinema;

import dao.implementation.CinemaDAO;

import admin.Session;

public class ListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(Session.isAdmin(request, response)) {
			Factory factory = Factory.getInstance();
			CinemaDAO cinemaDAO = factory.getCinemaDAO();
			try {
				List<Cinema> list = cinemaDAO.getCinemas();
				request.setAttribute("list", list);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("viewName", "cinema/index.jsp");
			request.getRequestDispatcher("/admin/panel.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}

}
