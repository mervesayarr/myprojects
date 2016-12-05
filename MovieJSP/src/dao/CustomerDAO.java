package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Bagg;
import model.Customer;



public enum CustomerDAO {
instance;
	public Customer save(Customer customer) {
	      Connection connection = Utils.getConnection();

	      try {
	         PreparedStatement psmt = connection.prepareStatement(
	               "INSERT INTO CUSTOMER(name, password) VALUES (?, ?)",
	               Statement.RETURN_GENERATED_KEYS);
	         psmt.setString(1, customer.getName());
	         psmt.setString(2, customer.getPassword());
	       

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

	   public Customer checkLogin(String name, String password) {
	      Connection connection = Utils.getConnection();
	      Customer customer = null;

	      try {
	         PreparedStatement psmt = connection
	               .prepareStatement("SELECT * FROM CUSTOMER WHERE NAME = ? AND PASSWORD = ?");
	         psmt.setString(1, name);
	         psmt.setString(2, password);
	         ResultSet rs = psmt.executeQuery();
	         if (rs.next()) {
	        	 customer = new Customer(rs.getInt("id"), rs.getString("name"),
	                  rs.getString("password"));
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return customer;
	   }
	   public Customer linkBag(Customer customer, Bagg bag) {
		      customer.setBag(bag);

		      Connection connection = Utils.getConnection();
		      try {
		         PreparedStatement psmt = connection.prepareStatement(
		               "INSERT INTO CUSTOMER_BAGG (CUSTOMER_ID, BAG_ID) VALUES (?, ?)",
		               Statement.RETURN_GENERATED_KEYS);
		         psmt.setInt(1, customer.getId());
		         psmt.setInt(2, bag.getId());

		         psmt.executeUpdate();

		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		      return customer;
		   }
}
