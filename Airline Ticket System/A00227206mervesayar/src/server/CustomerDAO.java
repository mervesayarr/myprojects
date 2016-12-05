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

import javax.swing.JOptionPane;






public enum CustomerDAO {
	instance;


	public List<Customer> getCustomers() {
	      Connection connection = Utils.getConnection();

	      List<Customer> customerList = new ArrayList<Customer>();
	      try {
	         PreparedStatement psmt = connection
	               .prepareStatement("SELECT * FROM Customer");

	         ResultSet rs = psmt.executeQuery();

	         while (rs.next()) {
	        	 int flightId = rs.getInt("flightid");
	        	 Flight flight = FlightDAO.instance.getFlight(""+flightId);
	            Customer customer = new Customer(rs.getInt("id"),flight, rs.getString("fname"),
	            		rs.getString("lname"),rs.getString("passportno"),rs.getString("gender"),rs.getString("seatno"), rs.getString("cabintype"),rs.getInt("price"));
	            customerList.add(customer);
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return customerList;
	   }

	   public Customer getCustomer(int customerId) {
	      Customer customer = null;

	      Connection connection = Utils.getConnection();
	      try {
	         String sql = "SELECT * FROM Customer WHERE ID = ?";
	         PreparedStatement psmt = connection.prepareStatement(sql);
	         psmt.setInt(1, customerId);

	         ResultSet rs = psmt.executeQuery();
	         rs.next();

	         int flightId = rs.getInt("flightid");
	         int id=rs.getInt("id");
	         String fname =rs.getString("fname");
	         String lname =rs.getString("lname");
	         String passportno =rs.getString("passportno");
	         String gender =rs.getString("gender");
	     
	         String seat =rs.getString("seatno");
	         String cabintype =rs.getString("cabintype");
	         int price = rs.getInt("price");
	         
	         Flight flight = FlightDAO.instance.getFlight(""+flightId);
	         customer = new Customer(id,flight,fname,lname,passportno,gender,seat,cabintype,price);
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return customer;
	   }
	   
	   public List<Customer> getCustomerByNameFlight(String firstname,String lastname,int flightid) {
		   List<Customer> customerList = new ArrayList<Customer>();

		      Connection connection = Utils.getConnection();
		      try {
		         String sql = "SELECT * FROM Customer WHERE fname=? and lname=? and flightid=?;";
		         PreparedStatement psmt = connection.prepareStatement(sql);
		         psmt.setString(1, firstname);
		         psmt.setString(2, lastname);
		         psmt.setInt(3, flightid);

		         ResultSet rs = psmt.executeQuery();
		         while (rs.next()) {
				        

		         int id=rs.getInt("id");

		         int flightId = rs.getInt("flightid");
		         String fname =rs.getString("fname");
		         String lname =rs.getString("lname");
		         String passportno =rs.getString("passportno");
		         String gender =rs.getString("gender");
		     
		         String seat =rs.getString("seatno");
		         String cabintype =rs.getString("cabintype");
		         int price = rs.getInt("price");
		         
		         Flight flight = FlightDAO.instance.getFlight(""+flightId);
		        
		         Customer customer = new Customer(rs.getInt("id"),flight, rs.getString("fname"),
		            		rs.getString("lname"),rs.getString("passportno"),rs.getString("gender"),rs.getString("seatno"), rs.getString("cabintype"),rs.getInt("price"));
		            customerList.add(customer);
		         }
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		      return customerList;
		   }
	   
	  
	   public List<Customer> getCustomerByName(String firstname,String lastname) {
		   List<Customer> customerList = new ArrayList<Customer>();

		      Connection connection = Utils.getConnection();
		      try {
		         String sql = "SELECT * FROM Customer WHERE fname=? and lname=?;";
		         PreparedStatement psmt = connection.prepareStatement(sql);
		         psmt.setString(1, firstname);
		         psmt.setString(2, lastname);
		    

		         ResultSet rs = psmt.executeQuery();
		         while (rs.next()) {
				        

		         int id=rs.getInt("id");

		         int flightId = rs.getInt("flightid");
		         String fname =rs.getString("fname");
		         String lname =rs.getString("lname");
		         String passportno =rs.getString("passportno");
		         String gender =rs.getString("gender");
		     
		         String seat =rs.getString("seatno");
		         String cabintype =rs.getString("cabintype");
		         int price = rs.getInt("price");
		         
		         Flight flight = FlightDAO.instance.getFlight(""+flightId);
		        
		         Customer customer = new Customer(rs.getInt("id"),flight, rs.getString("fname"),
		            		rs.getString("lname"),rs.getString("passportno"),rs.getString("gender"),rs.getString("seatno"), rs.getString("cabintype"),rs.getInt("price"));
		            customerList.add(customer);
		         }
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		      return customerList;
		   }
	public Customer create(Customer customer) {
		Connection connection = Utils.getConnection();

	      try {
	    	 
	         PreparedStatement psmt = connection.prepareStatement(
	               "INSERT INTO Customer (flightid,fname,lname,passportno,gender,seatno,cabintype,price) VALUES (?, ?,?, ?,?,?,?,?)",
	               Statement.RETURN_GENERATED_KEYS);
	         
	        
	         
	         psmt.setInt(1, customer.getFlight().getFid());
	         psmt.setString(2, customer.getFname());
	         psmt.setString(3, customer.getLname());
	         psmt.setString(4, customer.getPassportno());
	         psmt.setString(5, customer.getGender());
	       
	         psmt.setString(6, customer.getSeatno());
	         psmt.setString(7, customer.getCabintype());
	         psmt.setInt(8, customer.getPrice());
	         
	         

	         psmt.executeUpdate();

	         ResultSet rs = psmt.getGeneratedKeys();
	         rs.next();
	         int id = rs.getInt(1);
	         customer.setId(id);
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return customer;
	}
	
	public void delete(Customer customer) {
	      Connection connection = Utils.getConnection();

	      try {
	         PreparedStatement psmt = connection
	               .prepareStatement("DELETE FROM Customer WHERE id=?;");
	         
	         psmt.setInt(1, customer.getId());
	         psmt.executeUpdate();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
 }


}
