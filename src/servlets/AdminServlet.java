package servlets;

import general.Factory;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.util.MD5Encoder;

import sun.security.provider.MD5;
import tables.Admin;




import dao.IAdminDAO;
import dao.implementation.AdminDAO;

/**
 * Servlet implementation class BanksServlet
 */
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   public AdminServlet() {
	   super();
   }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session != null) {
			String authStatus = (String) session.getAttribute("authStatus");
			if(authStatus != null && authStatus.equals("logged")) {
				request.setAttribute("viewName", "dashboard.jsp");
				request.getRequestDispatcher("/admin/panel.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
			}
		} else {
			request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		Factory factory = Factory.getInstance();
		AdminDAO adminDAO = factory.getAdminDAO();
		try {
			Admin admin = adminDAO.getAdminByLogin(userName);
			String admin_password = "";
			if(admin != null) {
				admin_password = admin.getPassword();
			} else {
				request.setAttribute("errorMessage", "Ошибка при входе!");
				request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
			}
			String md5adminPassword = AdminServlet.md5Custom(password);
			if(admin_password.equals(md5adminPassword)) {
				HttpSession session = request.getSession();
				session.setAttribute("authStatus", "logged");
				request.setAttribute("viewName", "dashboard.jsp");
				request.getRequestDispatcher("/admin/panel.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static String md5Custom(String st) {
	    MessageDigest messageDigest = null;
	    byte[] digest = new byte[0];
	 
	    try {
	        messageDigest = MessageDigest.getInstance("MD5");
	        messageDigest.reset();
	        messageDigest.update(st.getBytes());
	        digest = messageDigest.digest();
	    } catch (NoSuchAlgorithmException e) {
	        // тут можно обработать ошибку
	        // возникает она если в передаваемый алгоритм в getInstance(,,,) не существует
	        e.printStackTrace();
	    }
	 
	    BigInteger bigInt = new BigInteger(1, digest);
	    String md5Hex = bigInt.toString(16);
	 
	    while( md5Hex.length() < 32 ){
	        md5Hex = "0" + md5Hex;
	    }
	 
	    return md5Hex;
	}

}
