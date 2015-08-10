package org.pm.tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.pm.services.*;
import org.pm.model.*;

public class ServicesTests {

	@Test
	public void iceSpaceCreamShouldReturnWithHTMLSpace() {
		assertEquals("ice%20cream", GoogleLocationServiceClient.insertHTMLSpaces("ice cream"));
	}
	@Test
	public void googleCoordsShouldReturnLeafletCoordsWithSpaceBetweenLatAndLng(){
		assertEquals("42.333665, -83.052125", GoogleLocationServiceClient.convertToLeafletCoordinates("42.333665,-83.052125"));
	}
	@Test
	public void shouldPutKeywordAndStationCoordsIntoURL(){
		String expected = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?keyword=pizza&location=42.333665,-83.052125&radius=300&key=AIzaSyAxC5yolZSd5G-UiQc70px_8cX0T09mqNs";
		assertEquals(expected, GoogleLocationServiceClient.googleLocationsURLBuilder("42.333665,-83.052125", "pizza"));
	}
	@Test
	public void shouldReturnNameOfFirstLocationObjectOfList() throws IOException, JSONException{
		ArrayList<Location> locations = GoogleResultsParser.getLocationResults("pizza", "42.333665,-83.052125");
		assertEquals("Bellacino's Pizza & Grinders", locations.get(0).getName());
	}
	
}
