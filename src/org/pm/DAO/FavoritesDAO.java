package org.pm.DAO;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.pm.model.Location;

public class FavoritesDAO {
	public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/pizzauser";
	public static final String USER = "root";
	public static final String PASSWORD = "DCKaug15";

	public static Connection getConnection() throws Exception {
		Connection conn = null;
		Class.forName(DRIVER_CLASS).newInstance();
		conn = DriverManager.getConnection(URL, USER, PASSWORD);
		return conn;
	}

	public static void insertFavorite(String email, String name,
			String address, String locLat, String locLng, String locationID) {
		String correctedName = fixPlaceName(name);
		Connection conn = null;
		try {
			conn = getConnection();
			PreparedStatement ps = generatePreparedStatement(email, correctedName,
					address, locLat, locLng, locationID, conn);
			ps.execute();
		} catch (Exception e) {
			System.out.println("Got an exception!");
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static String fixPlaceName(String placeName) {
		String newPlaceName = placeName;
		if (newPlaceName.contains("&amp;")) {
			newPlaceName = newPlaceName.replaceAll("&amp;", "&");
		}
		if (newPlaceName.contains("&#039;")) {
			newPlaceName = newPlaceName.replaceAll("&#039;", "'");
		}
		return newPlaceName;
	}

	public static PreparedStatement generatePreparedStatement(String email,
			String name, String address, String locLat, String locLng,
			String locationID, Connection conn) throws SQLException {
		String query = " insert into User (UserEmail, LocationName, LocationAddress, LocationLat, LocationLng, LocationID)"
				+ " values (?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, email);
		ps.setString(2, name);
		ps.setString(3, address);
		ps.setString(4, locLat);
		ps.setString(5, locLng);
		ps.setString(6, locationID);
		return ps;
	}

	public static List<Location> getFavorites(String email) throws Exception {
		Connection conn = null;
		List<Location> locations = new ArrayList<Location>();
		String query = "SELECT * from pizzauser.user where UserEmail = '"
				+ email + "'";
		try {
			conn = getConnection();
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				Location location = new Location();
				location.setName(rs.getString("LocationName"));
				location.setAddress(rs.getString("LocationAddress"));
				location.setLat(rs.getDouble("LocationLat"));
				location.setLng(rs.getDouble("LocationLng"));
				location.setId(rs.getString("LocationID"));
				locations.add(location);
			}
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Error: Unable to Connect to Database.");
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return locations;
	}
}
