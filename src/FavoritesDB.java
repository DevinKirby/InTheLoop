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
	public static final String URL = "jdbc:mysql://localhost:3306/pizzauser";
	public static final String USER = "root";
	public static final String PASSWORD = "DCKaug15";

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
	public static void insertUser(String email, String name, String address, String locLat, String locLng, String locationID){
		try{
		Connection conn = getConnection();
		String query = " insert into User (UserEmail, LocationName, LocationAddress, LocationLat, LocationLng, LocationID)"
				+ " values (?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, email);
		ps.setString(2, name);
		ps.setString(3, address);
		ps.setString(4, locLat);
		ps.setString(5, locLng);
		ps.setString(6, locationID);
		
		ps.execute();
		conn.close();		
		}
		catch (Exception e){
			System.out.println("Got an exception!");
		}
	}
	public static List<Location> getFavorites(String email) throws InstantiationException, IllegalAccessException {
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		Location location = null;
		List<Location> locations = new ArrayList<Location>();
		String query = "SELECT * from pizzauser.user where UserEmail = '" + email + "'";
		try{
			conn = getConnection();
			statement = conn.createStatement();
			rs = statement.executeQuery(query);
			while(rs.next()){
				location = new Location();
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
		} finally{
			if(conn != null){
				try{
					conn.close();
				} catch (SQLException e){
					e.printStackTrace();
				}
			}
		}
		return locations;
	}

}
