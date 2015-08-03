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
	public static final String URL = "jdbc:mysql://localhost:3306/userdb";
	public static final String USER = "root";
	public static final String PASSWORD = "DCKaug15";

	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			System.out.println("Error: Unable to Connect to Database.");
		}
		return conn;
	}
	public static void insertUser(String name, String address){
		try{
		Connection conn = getConnection();
		String query = " insert into user (LocationName, LocationAddress)"
				+ " values (?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, name);
		ps.setString(2, address);		
		ps.execute();
		conn.close();		
		}
		catch (Exception e){
			System.out.println("Got an exception!");
		}
	}

}
