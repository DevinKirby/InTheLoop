package com.grandcircus.pizzamover;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
		System.out.println("do get method");
		
		response.getWriter().write("do get method");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		String stationID = request.getParameter("stationID");
		HashMap<String, String> searchAddress = getStationAddress();
		String stationAddress = searchAddress.get(stationID);
		System.out.println(stationAddress);
		System.out.println(keyword);
		ArrayList<Location> locations; 
		try {
			String googlePlaces = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?keyword=" + keyword + "&location=" + stationAddress + "&radius=300&key=AIzaSyAxC5yolZSd5G-UiQc70px_8cX0T09mqNs";
			locations = JsonObjectArray.getLocationArray(googlePlaces);
			System.out.println(googlePlaces);
			request.setAttribute("location", locations);
//			for (Location location : locations) {
//				request.setAttribute("name", location.getName());
//				request.setAttribute("address", location.getAddress());
//				request.setAttribute("id", location.getId());
//				request.setAttribute("lat", location.getLat());
//				request.setAttribute("lng", location.getLng());
//				
//				System.out.println(location.getAddress());
//				System.out.println(location.getId());
//				System.out.println(location.getLat());
//				System.out.println(location.getLng());
//				System.out.println();
//			}
		
			Location ourLocation = new Location();
			String newLocation = ourLocation.getName(); 
			request.setAttribute("newLocation", newLocation);
		} catch (JSONException e) {
			e.printStackTrace();
		}
				
		getServletContext().getRequestDispatcher("/results.jsp").forward(request, response);
	}

	private HashMap<String, String> getStationAddress() {
		HashMap<String, String> stationAddresses = new HashMap<>();
		stationAddresses.put("1", "42.333665,-83.052125");
		stationAddresses.put("2", "42.335855,-83.050510");
		stationAddresses.put("3", "42.335437,-83.048204");
		stationAddresses.put("4", "42.333766,-83.046394");
		stationAddresses.put("5", "42.334909,-83.042425");
		stationAddresses.put("6", "42.333282,-83.041168");
		stationAddresses.put("7", "42.330147,-83.040208");
		stationAddresses.put("8", "42.330250,-83.041995");
		stationAddresses.put("9", "42.328687,-83.046697");
		stationAddresses.put("10", "42.325211,-83.051361");
		stationAddresses.put("11", "42.327938,-83.049715");
		stationAddresses.put("12", "42.329550,-83.051051");
		stationAddresses.put("13", "42.331344,-83.052163");

//		 stationAddresses.put("1", "390 Grand River, Detroit, MI");
//		 stationAddresses.put("2", "9 Park Street, Detroit, MI");
//		 stationAddresses.put("3", "150 John R St, Detroit, MI");
//		 stationAddresses.put("4", "170 Gratiot Ave, Detroit, MI");
//		 stationAddresses.put("5", "1150 Beaubien St, Detroit, MI 48226");
//		 stationAddresses.put("6", "700 Beaubien St, Detroit, MI");
//		 stationAddresses.put("7", "400 East Jefferson Ave., Detroit, MI");
//		 stationAddresses.put("8", "333 E. Jefferson Ave., Detroit, MI");
//		 stationAddresses.put("9", "133 W.Larned, Detroit, MI");
//		 stationAddresses.put("10", "600 Civic Center Drive, Detroit, MI");
//		 stationAddresses.put("11", "1 Washington Blvd., Detroit, MI");
//		 stationAddresses.put("12", "711 Cass Ave., Detroit, MI");
//		 stationAddresses.put("13", "1220 Cass Ave., Detroit, MI");
		return stationAddresses;
	}

}
