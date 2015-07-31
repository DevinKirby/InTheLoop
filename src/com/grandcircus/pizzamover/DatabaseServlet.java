package com.grandcircus.pizzamover;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DatabaseServlet
 */
@WebServlet("/DatabaseServlet")
public class DatabaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DatabaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String email = request.getParameter("email");
		String name = request.getParameter("name"); 
		String x = " ";
		name = " " + name + " "; 
		request.setAttribute("name", name);
		
		try{
			String dbURL = "jdbc:mysql://localhost:3306/murach";
			String username = "root";
			String password = "rocketshi1"; 
			Connection connection = DriverManager.getConnection(dbURL, username, password); 
			Statement stmt = connection.createStatement(); 
			ResultSet rs = stmt.executeQuery("SELECT User FROM table"); 
			while (rs.next()){
				 x = rs.getString(0);
			}
			
		}
		catch(SQLException e){
			for(Throwable t : e)
				t.printStackTrace();
		}
		
		HttpSession session = request.getSession(); 
		session.setAttribute("x", x);
		String url = "/results.jsp"; 
		//getServletContext().getRequestDispatcher(url)
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

	}

}
