
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
	static{
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gmail = request.getParameter("gmail");
//		if(gmail.equalsIgnoreCase("")){
//			gmail = "null";
//		}
		System.out.println(gmail);
		
		String keyword = request.getParameter("keyword");
		String stationID = request.getParameter("stationID");
		keyword = insertHTMLSpaces(keyword);
		request.setAttribute("stationName", stationID); //Why is this line necessary?
		String stationAddress = getStationAddress(stationID);		
		String stationLat = stationAddress.substring(0, 9);
		String stationLng = stationAddress.substring(10);
		String formattedCoords = stationLat + ", " + stationLng;
		request.setAttribute("stationCoords", formattedCoords);
//		System.out.println(formattedCoords);
//		System.out.println(stationAddress);
//		System.out.println(keyword);
		ArrayList<Location> locations; 
		try {
			String googlePlaces = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?keyword=" + keyword + "&location=" + stationAddress + "&radius=300&key=AIzaSyAxC5yolZSd5G-UiQc70px_8cX0T09mqNs";
			System.out.println(googlePlaces);
			locations = JsonObjectArray.getLocationArray(googlePlaces);
			request.setAttribute("location", locations);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/results.jsp").forward(request, response);
	}

	static String insertHTMLSpaces(String keyword) {
		keyword = keyword.trim();
		keyword = keyword.replaceAll("\\s+", "%20");
		return keyword;
	}

	static String getStationAddress(String stationId) {
			return stationAddresses.get(stationId);
	}

}
