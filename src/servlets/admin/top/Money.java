package servlets.admin.top;

import general.Factory;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.Session;
import dao.implementation.MovieDAO;

public class Money extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(Session.isAdmin(request, response)) {
			Factory factory = Factory.getInstance();
			MovieDAO dao = factory.getMovieDAO();
			List<String> list = dao.top10money();
			
			request.setAttribute("list", list);
			request.setAttribute("viewName", "top/money.jsp");
			request.getRequestDispatcher("/admin/panel.jsp").forward(request, response);
		}
	}
	
}
