import static org.junit.Assert.*;

import org.junit.Test;

public class UnitTests {

	@Test
	public void shouldConvertSpacesToHTMLSpaces() {
		String expected = "ice%20cream";
		String actual = PizzaServlet.insertHTMLSpaces("ice cream");
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldReturnTimesSquareCoordinates() {
		String expected = "42.333665,-83.052125";
		String actual = PizzaServlet.getStationAddress("Times Square");
		assertEquals(expected, actual);
	}

	@Test
	public void shouldReturnGrandCircusParkCoordinates() {
		String expected = "42.335855,-83.050510";
		String actual = PizzaServlet.getStationAddress("Grand Circus Park");
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldReturnBroadwayCoordinates() {
		String expected = "42.335437,-83.048204";
		String actual = PizzaServlet.getStationAddress("Broadway");
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldReturnCadillacCenterCoordinates() {
		String expected = "42.333766,-83.046394";
		String actual = PizzaServlet.getStationAddress("Cadillac Center");
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldReturnGreektownCoordinates() {
		String expected = "42.334909,-83.042425";
		String actual = PizzaServlet.getStationAddress("Greektown");
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldReturnBricktownCoordinates() {
		String expected = "42.333282,-83.041168";
		String actual = PizzaServlet.getStationAddress("Bricktown");
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldReturnRenaissanceCenterCoordinates() {
		String expected = "42.330147,-83.040208";
		String actual = PizzaServlet.getStationAddress("Renaissance Center");
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldReturnMillenderCenterCoordinates() {
		String expected = "42.330250,-83.041995";
		String actual = PizzaServlet.getStationAddress("Millender Center");
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldReturnFinancialDistrictCoordinates() {
		String expected = "42.328687,-83.046697";
		String actual = PizzaServlet.getStationAddress("Financial District");
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldReturnJoeLouisArenaCoordinates() {
		String expected = "42.325211,-83.051361";
		String actual = PizzaServlet.getStationAddress("Joe Louis Arena");
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldReturnCoboCenterCoordinates() {
		String expected = "42.327938,-83.049715";
		String actual = PizzaServlet.getStationAddress("Cobo Center");
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldReturnFortCassCoordinates() {
		String expected = "42.329550,-83.051051";
		String actual = PizzaServlet.getStationAddress("Fort Cass");
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldReturnMichiganAveCoordinates() {
		String expected = "42.331344,-83.052163";
		String actual = PizzaServlet.getStationAddress("Michigan Ave.");
		assertEquals(expected, actual);
	}
}
