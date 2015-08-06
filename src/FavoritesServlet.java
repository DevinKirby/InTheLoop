import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FavoritesServlet
 */
@WebServlet("/FavoritesServlet")
public class FavoritesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FavoritesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			String email = request.getParameter("gmail");
			List<Location> locations = FavoritesDB.getFavorites(email);
			for (Location location : locations) {
				System.out.println(location.getName());
				System.out.println(location.getId());
			}
			request.setAttribute("location", locations);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			getServletContext().getRequestDispatcher("/oops.jsp").forward(
					request, response);
			System.out
					.println("Oops! You broke it, or the database is unavailable.");
		}
		getServletContext().getRequestDispatcher("/favorites.jsp").forward(
				request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String locName = request.getParameter("name");
		String locAddress = request.getParameter("address");
		String locLat = request.getParameter("lat");
		String locLng = request.getParameter("lng");
		String locID = request.getParameter("id");
		String userEmail = request.getParameter("gmail");
		FavoritesDB.insertFavorite(userEmail, locName, locAddress, locLat, locLng,
				locID);
		System.out.println(locName);
		System.out.println(locAddress);
		String text = "Your user was Added!";

		response.setContentType("text/plain"); // Set content type of the
												// response so that jQuery knows
												// what it can expect.
		response.setCharacterEncoding("UTF-8"); // You want world domination,
												// huh?
		response.getWriter().write(text); // Write response body.
	}

}
