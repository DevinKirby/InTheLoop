import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import com.mysql.jdbc.PreparedStatement;

public class FavoritesDB {
	public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/pizzauser";
	public static final String USER = "root";
	public static final String PASSWORD = "canal";

	public static Connection getConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection conn = null;
		try {
			Class.forName(DRIVER_CLASS).newInstance();
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			System.out.println("Error: Unable to Connect to Database.");
		}
		return conn;
	}
	public static void insertUser(String name, String address){
		try{
		Connection conn = getConnection();
		String query = " insert into User (LocationName, LocationAddress)"
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
