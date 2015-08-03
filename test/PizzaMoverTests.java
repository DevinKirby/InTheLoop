import net.sourceforge.jwebunit.junit.*;

import org.junit.Before;
import org.junit.Test;

import net.sourceforge.jwebunit.junit.WebTester;

public class PizzaMoverTests {
	private WebTester tester;
	
	private WebTester setBaseUrl(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Before
	public void prepare() {
		tester = new WebTester();
		tester = setBaseUrl("http://localhost:8080/test");
	}

	@Test
	public void shouldGetTimesSquareCoordinates() {
		
	}

}
