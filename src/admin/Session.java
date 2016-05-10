package admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Session {
	
	public static boolean isAdmin(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String url = request.getRequestURL().toString();
	    String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "/";
		HttpSession session = request.getSession();
		if(session != null) {
			String authStatus = (String) session.getAttribute("authStatus");
			if(authStatus != null && authStatus.equals("logged")) {
				return true;
			} else {
				response.sendRedirect(baseURL+"admin");
			}
		} else {
			response.sendRedirect(baseURL+"admin");
		}
		return false;
	}
}
