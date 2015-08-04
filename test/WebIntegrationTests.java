import net.sourceforge.jwebunit.junit.*;

import org.junit.Before;
import org.junit.Test;

import net.sourceforge.jwebunit.junit.WebTester;

public class WebIntegrationTests {
	private WebTester tester;
	
	private WebTester setBaseUrl(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Before
	public void prepare() {
		tester = new WebTester();
		tester = setBaseUrl("http://localhost:8080/PizzaMoverGroupProject/");
	}

	@Test
	public void shouldGetTimesSquareCoordinates() {
		tester.beginAt("index.jsp");
		tester.selectOption("stationID", "Times Square");
		tester.submit();
		
		
	}

}
