package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.BagLinee;
import model.Movies;

public enum BagLineeDAO {
   instance;

   public BagLinee save(BagLinee line) {
      Connection connection = Utils.getConnection();
      int id = 0;

      try {
         PreparedStatement psmt = connection.prepareStatement(
               "INSERT INTO BAGLINEE (MOVIE_ID,REVIEW) VALUES (?,?)",
               Statement.RETURN_GENERATED_KEYS);
         psmt.setInt(1, line.getMovies().getId());
         psmt.setString(2, line.getReview());
       
         psmt.executeUpdate();
         ResultSet rs = psmt.getGeneratedKeys();
         rs.next();
         id = rs.getInt(1);
         line.setId(id);

      } catch (SQLException e) {
         e.printStackTrace();
      }
      return line;
   }

   public BagLinee get(int id) {
      BagLinee bagLine = null;

      Connection connection = Utils.getConnection();
      try {
         String sql = "SELECT * FROM BagLinee WHERE ID = ?";
         PreparedStatement psmt = connection.prepareStatement(sql);
         psmt.setInt(1, id);

         ResultSet rs = psmt.executeQuery();
         rs.next();
         int moviesId = rs.getInt("MOVIE_ID");
         String review = rs.getString("REVIEW");
         
         Movies movies  = MoviesDAO.instance.get(moviesId);
         bagLine = new BagLinee(movies,review);
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return bagLine;
   }
   
}
