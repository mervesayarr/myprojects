package server;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;





public enum FlightDAO {
	instance;


	public List<Flight> getFlights() {
	      Connection connection = Utils.getConnection();

	      List<Flight> flightList = new ArrayList<Flight>();
	      try {
	         PreparedStatement psmt = connection
	               .prepareStatement("SELECT * FROM Flight");

	         ResultSet rs = psmt.executeQuery();

	         while (rs.next()) {
	            Flight flight = new Flight(rs.getInt("fid"), rs.getString("flight_from"),
	            		rs.getString("flight_to"), rs.getString("date"));
	            flightList.add(flight);
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return flightList;
	   }
	
	 public List <Flight> getFlightTo(String flightto) {
		   List<Flight> flightList = new ArrayList<Flight>();

		      Connection connection = Utils.getConnection();
		      try {
		    	  
		         String sql = "select * from flight where flight_from=? ";
		         PreparedStatement psmt = connection.prepareStatement(sql);
		         
		         psmt.setString(1, flightto);
		         

		         ResultSet rs = psmt.executeQuery();
		         while (rs.next()) {
		   

		         Flight flight = new Flight(rs.getInt("fid"), rs.getString("flight_from"),
		            		rs.getString("flight_to"), rs.getString("date"));
		         flightList.add(flight);
		         }
		         rs.close();
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		      return flightList;
		   }
	 
	 public List <Flight> getFlight_To() {
		   List<Flight> flightList = new ArrayList<Flight>();

		      Connection connection = Utils.getConnection();
		      try {
		    	  
		         String sql = "select flight_to from flight  ";
		         PreparedStatement psmt = connection.prepareStatement(sql);
		         
		         
		         

		         ResultSet rs = psmt.executeQuery();
		         while (rs.next()) {
		   

		         Flight flight = new Flight(rs.getInt("fid"), rs.getString("flight_from"),
		            		rs.getString("flight_to"), rs.getString("date"));
		         flightList.add(flight);
		         }
		         rs.close();
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		      return flightList;
		   }

	   public Flight getFlight(String fid) {
		   Flight flight = null;

	      Connection connection = Utils.getConnection();
	      try {
	         String sql = "SELECT * FROM Flight WHERE fID = ?";
	         PreparedStatement psmt = connection.prepareStatement(sql);
	         psmt.setInt(1,Integer.parseInt(fid) );

	         ResultSet rs = psmt.executeQuery();
	         rs.next();

	          flight = new Flight(rs.getInt("fid"), rs.getString("flight_from"),
	            		rs.getString("flight_to"), rs.getString("date"));
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return flight;
	   }
	   public List <Flight> getFlightCustomer(String flightfrom,String flightto,String date) {
		   List<Flight> flightList = new ArrayList<Flight>();
		   Flight flight = null;

		      Connection connection = Utils.getConnection();
		      try {
		         String sql = "select * from flight where flight_from=? and flight_to=? and date= ? ";
		         PreparedStatement psmt = connection.prepareStatement(sql);
		         psmt.setString(1, flightfrom);
		         psmt.setString(2, flightto);
		         psmt.setString(3, date);
		         

		         ResultSet rs = psmt.executeQuery();
		         while (rs.next()) {
		        

		          flight = new Flight(rs.getInt("fid"), rs.getString("flight_from"),
		            		rs.getString("flight_to"), rs.getString("date"));
		         flightList.add(flight);
		         }
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		      return flightList;
		   }

	public Flight create(Flight flight) {
		Connection connection = Utils.getConnection();

	      try {
	         PreparedStatement psmt = connection.prepareStatement(
	               "INSERT INTO Flight (flight_from, flight_to, date) VALUES ( ?, ?,?)",
	               Statement.RETURN_GENERATED_KEYS);
	         
	         psmt.setString(1, flight.getFrom());
	         psmt.setString(2, flight.getTo());
	         psmt.setString(3, flight.getDate());

	         psmt.executeUpdate();

	         ResultSet rs = psmt.getGeneratedKeys();
	         rs.next();
	         int id = rs.getInt(1);
	         flight.setFid(id);
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return flight;
	}
	
	public void delete(Flight flight) {
	      Connection connection = Utils.getConnection();

	      try {
	         PreparedStatement psmt = connection
	               .prepareStatement("DELETE FROM Flight WHERE fid=?;");
	         
	         psmt.setInt(1, flight.getFid());
	         psmt.executeUpdate();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
 }


}
