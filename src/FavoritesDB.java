import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Driver;

public class FavoritesDB {
	public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:8889/pizzauser";
	public static final String USER = "root";
	public static final String PASSWORD = "root";

	public static Connection getConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection conn = null;
		try {
			Class.forName(DRIVER_CLASS).newInstance();
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error: Unable to Connect to Database.");
		}
		return conn;
	}
	public static void insertUser(String name, String address, String locLat, String locLng, String locationID){
		try{
		Connection conn = getConnection();
		String query = " insert into User (LocationName, LocationAddress, LocationLat, LocationLng, LocationID)"
				+ " values (?, ?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, name);
		ps.setString(2, address);
		ps.setString(3, locLat);
		ps.setString(4, locLng);
		ps.setString(5, locationID);
		
		ps.execute();
		conn.close();		
		}
		catch (Exception e){
			System.out.println("Got an exception!");
		}
	}

}
