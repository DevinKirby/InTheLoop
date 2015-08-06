import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

/**
 * Servlet implementation class DummyServlet
 */
@WebServlet("/PizzaServlet")
public class PizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String stationAddress = null;
	public static HashMap<String, String> stationAddresses = null;
	static {
		stationAddresses = new HashMap<>();
		stationAddresses.put("Times Square", "42.333665,-83.052125");
		stationAddresses.put("Grand Circus Park", "42.335855,-83.050510");
		stationAddresses.put("Broadway", "42.335437,-83.048204");
		stationAddresses.put("Cadillac Center", "42.333766,-83.046394");
		stationAddresses.put("Greektown", "42.334909,-83.042425");
		stationAddresses.put("Bricktown", "42.333282,-83.041168");
		stationAddresses.put("Renaissance Center", "42.330147,-83.040208");
		stationAddresses.put("Millender Center", "42.330250,-83.041995");
		stationAddresses.put("Financial District", "42.328687,-83.046697");
		stationAddresses.put("Joe Louis Arena", "42.325211,-83.051361");
		stationAddresses.put("Cobo Center", "42.327938,-83.049715");
		stationAddresses.put("Fort Cass", "42.329550,-83.051051");
		stationAddresses.put("Michigan Ave.", "42.331344,-83.052163");

	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PizzaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String gmail = request.getParameter("gmail");
		request.setAttribute("gmail", gmail);
		String keyword = request.getParameter("keyword");
		String stationID = request.getParameter("stationID");
		request.setAttribute("leafletStationName", stationID);
		String stationCoordinates = getHashMapCoordinates(stationID);
		request.setAttribute("leafletStationCoords", GoogleLocationServiceClient.convertToLeafletCoordinates(stationCoordinates));
		ArrayList<Location> locations;
		try {
			locations = GoogleResultsParser.getLocationResults(keyword, stationCoordinates);
			request.setAttribute("location", locations);
		} catch (JSONException e) {
			//redirect to broken page
		}
		String url = "/results.jsp";
		if (gmail.equals("")) {
			url = "/unsignedResults.jsp";
		}
		getServletContext().getRequestDispatcher(url)
				.forward(request, response);
	}
	static String getHashMapCoordinates(String stationId) {
		return stationAddresses.get(stationId);
	}

}
