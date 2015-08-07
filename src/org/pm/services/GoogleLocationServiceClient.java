package org.pm.services;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONException;

public class GoogleLocationServiceClient {
	public static String convertJSONResultsToString(String keyword, String stationAddress) throws IOException,
			JSONException {
		String revisedKeyword = insertHTMLSpaces(keyword);
		String googlePlaces = googleLocationsURLBuilder(stationAddress,
				revisedKeyword);
		System.out.println(googlePlaces);
		StringBuilder jsonResult = buildJSONString(googlePlaces);
		return jsonResult.toString();
	}

	public static StringBuilder buildJSONString(String googlePlaces)
			throws IOException {
		StringBuilder jsonResult = null;
		try {
			BufferedReader in = createBufferedReaderFromGoogleURL(googlePlaces);
			String inputLine;
			jsonResult = new StringBuilder();
			while ((inputLine = in.readLine()) != null) {
				jsonResult.append(inputLine);
			}
		} catch (MalformedURLException e) {
			System.out.println("MalformedURL");
		}
		return jsonResult;
	}

	public static BufferedReader createBufferedReaderFromGoogleURL(
			String googlePlaces) throws MalformedURLException, IOException {
		URL google = new URL(googlePlaces);
		URLConnection yc = google.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				yc.getInputStream()));
		return in;
	}

	public static String googleLocationsURLBuilder(String stationAddress,
			String revisedKeyword) {
		String googlePlaces = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?keyword="
				+ revisedKeyword
				+ "&location="
				+ stationAddress
				+ "&radius=300&key=AIzaSyAxC5yolZSd5G-UiQc70px_8cX0T09mqNs";
		return googlePlaces;
	}
	
	public static String insertHTMLSpaces(String keyword) {
		keyword = keyword.trim();
		keyword = keyword.replaceAll("\\s+", "%20");
		return keyword;
	}
	public static String convertToLeafletCoordinates(String stationAddress){
		String stationLat = stationAddress.substring(0, 9);
		String stationLng = stationAddress.substring(10);
		String leafletCoords = stationLat + ", " + stationLng;
		return leafletCoords;
	}
}
