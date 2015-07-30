import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONException;

public class URLJSONString {
	public static String parseJSON(String url) throws IOException,
			JSONException {
		StringBuilder jsonResult = null;
		try {
			URL google = new URL(url);
			URLConnection yc = google.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					yc.getInputStream()));
			String inputLine;
			jsonResult = new StringBuilder();
			while ((inputLine = in.readLine()) != null) {
				jsonResult.append(inputLine);
			}
		} catch (MalformedURLException e) {
			System.out.println("MalformedURL");
		}
		return jsonResult.toString();
	}
}
