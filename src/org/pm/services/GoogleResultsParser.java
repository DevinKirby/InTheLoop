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
		ArrayList<Location> locations = new ArrayList<Location>();
		JSONObject jsonObj = new JSONObject(GoogleLocationServiceClient.convertJSONResultsToString(keyword, stationAddress));
		JSONArray jsonMainArr = jsonObj.getJSONArray("results");
		for (int i = 0; i < jsonMainArr.length(); i++) {
			JSONObject childJSONObject = jsonMainArr.getJSONObject(i);
			JSONObject jsonGeoObj = childJSONObject.getJSONObject("geometry");
			JSONObject jsonLocObj = jsonGeoObj.getJSONObject("location");
			Location location = new Location();
			location.setName(childJSONObject.getString("name"));
			location.setAddress(childJSONObject.getString("vicinity"));
			checkIfOpen(childJSONObject, location);
			location.setId(childJSONObject.getString("id"));
			location.setLat(jsonLocObj.getDouble("lat"));
			location.setLng(jsonLocObj.getDouble("lng"));
			locations.add(location);
		}
		return locations;
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
