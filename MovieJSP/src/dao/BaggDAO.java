package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.BagLinee;
import model.Bagg;



public enum BaggDAO {
   instance;

   public Bagg save(Bagg bag) {
      Connection connection = Utils.getConnection();

      try {
         PreparedStatement psmt = connection.prepareStatement(
               "INSERT INTO Bagg (NAME) VALUES (?)",
               Statement.RETURN_GENERATED_KEYS);
         psmt.setString(1, bag.getName());
         psmt.executeUpdate();
         ResultSet rs = psmt.getGeneratedKeys();
         rs.next();
         int id = rs.getInt(1);
         bag.setId(id);

      } catch (SQLException e) {
         e.printStackTrace();
      }
      return bag;
   }

   public Bagg get(int bagId) {
      Bagg bag = null;

      Connection connection = Utils.getConnection();
      try {
         String sql = "SELECT * FROM Bagg WHERE ID = ?";
         PreparedStatement psmt = connection.prepareStatement(sql);
         psmt.setInt(1, bagId);

         ResultSet rs = psmt.executeQuery();
         rs.next();
         String name = rs.getString("name");
         bag = new Bagg(bagId, name);
         List<BagLinee> lines = getLines(bagId);
         bag.setContents(lines);

      } catch (SQLException e) {
         e.printStackTrace();
      }
      return bag;
   }

   public List<BagLinee> getLines(int bagId) {
      List<BagLinee> lines = new ArrayList<BagLinee>();
      Connection connection = Utils.getConnection();
      try {
         String sql = "SELECT * FROM BAG_BAGLINEE WHERE BAG_ID = ?";
         PreparedStatement psmt = connection.prepareStatement(sql);
         psmt.setInt(1, bagId);

         ResultSet rs = psmt.executeQuery();
         while (rs.next()) {
            int bagLineId = rs.getInt("BAGLINE_ID");
            BagLinee line = BagLineeDAO.instance.get(bagLineId);
            lines.add(line);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return lines;
   }

   public Bagg getFromCustomerId(int customerId) {
      Bagg bag = null;

      Connection connection = Utils.getConnection();
      try {
         String sql = "SELECT * FROM CUSTOMER_BAGG WHERE CUSTOMER_ID = ?";
         PreparedStatement psmt = connection.prepareStatement(sql);
         psmt.setInt(1, customerId);

         ResultSet rs = psmt.executeQuery();
         rs.next();
         int bagId = rs.getInt("BAG_ID");
         bag = this.get(bagId);
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return bag;
   }
   
   public void addLine(Bagg bag, BagLinee line) {
      Connection connection = Utils.getConnection();

      try {
         PreparedStatement psmt = connection
               .prepareStatement("INSERT INTO BAG_BAGLINEE (BAG_ID, BAGLINE_ID) VALUES (?,?)");
         psmt.setInt(1, bag.getId());
         psmt.setInt(2, line.getId());
      
         psmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }


   public void removeAllLine(Bagg bagg) {
	      Connection connection = Utils.getConnection();

	      try {
	         PreparedStatement psmt = connection
	               .prepareStatement("DELETE FROM BAG_BAGLINEE WHERE BAG_ID=?;");
	         
	         psmt.setInt(1, bagg.getId());
	         psmt.executeUpdate();
	        
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	     

   }
   
	   public void removeLine(BagLinee line) {
		      Connection connection = Utils.getConnection();

		      try {
		         PreparedStatement psmt = connection
		               .prepareStatement("DELETE FROM BAGLINEE WHERE MOVIE_ID=?;");
		         
		         psmt.setInt(1, line.getId());
		       
		         psmt.executeUpdate();
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		   }


}


   

