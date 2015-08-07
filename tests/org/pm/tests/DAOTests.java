package org.pm.tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.pm.DAO.FavoritesDAO;
import org.pm.model.Location;

public class DAOTests {
	
	

	@Before
	public void insertLocationEntryIntoDB(){
		FavoritesDAO.insertFavorite("devinckirby@gmail.com", "Slices Pizza", "1043 Woodward Avenue, Detroit", "42.332543", "-83.04777", "82acbcd8fc57eae1f52c7564a685e158f1ab1627");
	}
	@Test
	public void shouldReturnNameOfFirstLocationInDB() throws Exception{
		List<Location> locations = FavoritesDAO.getFavorites("pizzalover@pizza.com");
		assertEquals("Pizza Place", locations.get(0).getName());
	}
	@Test
	public void shouldReturnNameOf() throws Exception {
		Connection conn = mock(Connection.class);
		String preparedStatement = "insert into User (UserEmail, LocationName, LocationAddress, LocationLat, LocationLng, LocationID) values ('devinckirby@gmail.com', 'Slices Pizza', '1043 Woodward Avenue, Detroit', '42.332543', '-83.04777', '82acbcd8fc57eae1f52c7564a685e158f1ab1627')";
		assertEquals(preparedStatement, FavoritesDAO.generatePreparedStatement("devinckirby@gmail.com", "Slices Pizza", "1043 Woodward Avenue, Detroit", "42.332543", "-83.04777", "82acbcd8fc57eae1f52c7564a685e158f1ab1627", conn));
	}

}
