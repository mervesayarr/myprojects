package server;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

class Utils {
   public static Connection getConnection() {
Statement stmt =null;
      Connection connection = null;
      try {
			// Load the JConnector Driver
			Class.forName("com.mysql.jdbc.Driver");
			// Specify the DB Name
			String url = "jdbc:mysql://localhost:3306/deneme";
			// Connect to DB using DB URL, Username and password
			connection = DriverManager.getConnection(url, "username", "password");
			// Create a generic statement which is passed to the
			// TestInternalFrame1
			stmt = connection.createStatement();
		} catch (Exception e) {
			System.out.println("Error: Failed to connect to database\n" + e.getMessage());
		}

      return connection;
   }

}
