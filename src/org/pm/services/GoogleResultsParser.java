package org.pm.services;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.pm.model.Location;

public class GoogleResultsParser {
	public static ArrayList<Location> getLocationResults(String keyword, String stationAddress)
			throws IOException, JSONException {
		JSONObject jsonObj = new JSONObject(GoogleLocationServiceClient.convertJSONResultsToString(keyword, stationAddress));
		ArrayList<Location> locations = parseLocationsList(jsonObj);
		return locations;
	}

	public static ArrayList<Location> parseLocationsList(JSONObject jsonObj)
			throws JSONException {
		ArrayList<Location> locations = new ArrayList<Location>();
		JSONArray jsonMainArr = jsonObj.getJSONArray("results");
		for (int i = 0; i < jsonMainArr.length(); i++) {
			Location location = new Location();
			JSONObject childJSONObject = jsonMainArr.getJSONObject(i);
			parseLocationCoordinates(location, childJSONObject);
			parseBasicInfo(location, childJSONObject);
			checkIfOpen(childJSONObject, location);
			locations.add(location);
		}
		return locations;
	}

	public static void parseBasicInfo(Location location,
			JSONObject childJSONObject) throws JSONException {
		location.setName(childJSONObject.getString("name"));
		location.setAddress(childJSONObject.getString("vicinity"));
		location.setId(childJSONObject.getString("id"));
	}

	public static void parseLocationCoordinates(Location location,
			JSONObject childJSONObject) throws JSONException {
		JSONObject jsonGeoObj = childJSONObject.getJSONObject("geometry");
		JSONObject jsonLocObj = jsonGeoObj.getJSONObject("location");
		location.setLat(jsonLocObj.getDouble("lat"));
		location.setLng(jsonLocObj.getDouble("lng"));
	}

	private static void checkIfOpen(JSONObject childJSONObject,
			Location location) throws JSONException {
		if (!childJSONObject.has("opening_hours")) {
			location.setOpenStatus("Unknown");
		} else {
			JSONObject jsonOpeningHours = childJSONObject
					.getJSONObject("opening_hours");
			if (jsonOpeningHours.getBoolean("open_now") == true) {
				location.setOpenStatus("Yes!");
			} else if (jsonOpeningHours.getBoolean("open_now") == false) {
				location.setOpenStatus("No");
			}
		}
	}

}
