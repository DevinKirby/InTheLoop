import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonObjectArray {
	public static ArrayList<Location> getLocationArray(String url) throws IOException, JSONException {
		ArrayList<Location> locations = new ArrayList<Location>();
		JSONObject jsonObj = new JSONObject(URLJSONString.parseJSON(url));
		JSONArray jsonMainArr = jsonObj.getJSONArray("results");
		for (int i = 0; i < jsonMainArr.length(); i++) {
			JSONObject childJSONObject = jsonMainArr.getJSONObject(i);
			JSONObject jsonGeoObj = childJSONObject.getJSONObject("geometry");
			JSONObject jsonLocObj = jsonGeoObj.getJSONObject("location");
			Location location = new Location();
			location.setName(childJSONObject.getString("name"));
			location.setAddress(childJSONObject.getString("vicinity"));
			location.setPlaceId(childJSONObject.getString("place_id"));
			location.setLat(jsonLocObj.getDouble("lat"));
			location.setLng(jsonLocObj.getDouble("lng"));
			locations.add(location);
		}
		return locations;

//		 for (Location location : locations) {
//		 System.out.println(location.getName());
//		 System.out.println(location.getAddress());
//		 System.out.println(location.getId());
//		 System.out.println(location.getLat());
//		 System.out.println(location.getLng());
//		 System.out.println();
//		 }

	}

}
