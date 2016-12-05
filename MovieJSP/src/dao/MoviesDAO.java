package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Comingsoon;
import model.Movies;

public enum MoviesDAO {
instance;
	public Movies save(Movies movies) {
	      Connection connection = Utils.getConnection();

	      try {
	         PreparedStatement psmt = connection.prepareStatement(
	               "INSERT INTO MOVIE (movieName, writerName,directorName,imdbRating,genre) VALUES (?,?,?,?,?)",
	               Statement.RETURN_GENERATED_KEYS);
	         psmt.setString(1, movies.getMovieName());
	         psmt.setString(2, movies.getWriterName());
	         psmt.setString(3, movies.getDirectorName());
	         psmt.setDouble(4, movies.getImdbRating());
	         psmt.setString(5, movies.getGenre());
	         psmt.executeUpdate();

	         ResultSet rs = psmt.getGeneratedKeys();
	         rs.next();
	         int id = rs.getInt(1);
	         movies.setId(id);
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return movies;
	   }

	   public List<Movies> list() {
	      Connection connection = Utils.getConnection();

	      List<Movies> moviesList = new ArrayList<Movies>();
	      try {
	         PreparedStatement psmt = connection
	               .prepareStatement("SELECT * FROM MOVIE");

	         ResultSet rs = psmt.executeQuery();

	         while (rs.next()) {
	        	 Movies p = new Movies(rs.getInt("id"), rs.getString("movieName"),rs.getString("writerName"),
	        			 rs.getString("directorName"),rs.getDouble("imdbRating"),rs.getString("genre"));
	        	 moviesList.add(p);
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return moviesList;
	   }

	 
	   public List<Comingsoon> listcomingsoon() {
		      Connection connection = Utils.getConnection();

		      List<Comingsoon> moviesList = new ArrayList<Comingsoon>();
		      try {
		         PreparedStatement psmt = connection
		               .prepareStatement("SELECT * FROM COMINGSOON");

		         ResultSet rs = psmt.executeQuery();

		         while (rs.next()) {
		        	 Comingsoon p = new Comingsoon(rs.getInt("id"), rs.getString("moviename"),rs.getString("genre"),
		        			 rs.getString("detail"));
		        	 moviesList.add(p);
		         }
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		      return moviesList;
		   }
	   
	   public List<Movies> sort() {
		      Connection connection = Utils.getConnection();

		      List<Movies> moviesList = new ArrayList<Movies>();
		      try {
		         PreparedStatement psmt = connection
		               .prepareStatement("SELECT TOP 10 * FROM MOVIE order by imdbRating desc");

		         ResultSet rs = psmt.executeQuery();

		         while (rs.next()) {
		        	 Movies p = new Movies(rs.getInt("id"), rs.getString("movieName"),rs.getString("writerName"),
		        			 rs.getString("directorName"),rs.getDouble("imdbRating"),rs.getString("genre"));
		        	 moviesList.add(p);
		         }
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		      return moviesList;
		   }
	   

	   public int delete(String id) {
		      Connection connection = Utils.getConnection();

		      try {
		         PreparedStatement psmt = connection.prepareStatement(
		               "DELETE FROM movie where id=?",
		               Statement.RETURN_GENERATED_KEYS);
		         psmt.setString(1, id);
		         
		         psmt.executeUpdate();

		     
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		      return 0;
		   }
		   
		 
		  
	   

	   public Movies get(int moviesId) {
		   Movies movies = null;

	      Connection connection = Utils.getConnection();
	      try {
	         String sql = "SELECT * FROM MOVIE WHERE ID = ?";
	         PreparedStatement psmt = connection.prepareStatement(sql);
	         psmt.setInt(1, moviesId);

	         ResultSet rs = psmt.executeQuery();
	         rs.next();

	         String movieName = rs.getString("MOVIENAME");
	         String writerName = rs.getString("WRITERNAME");
	         String directorName = rs.getString("DIRECTORNAME");
	         Double imdbRating = rs.getDouble("IMDBRATING");
	         String genre = rs.getString("GENRE");
	         movies = new Movies(moviesId, movieName, writerName,directorName,imdbRating,genre);
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return movies;
	   }
	   public Comingsoon get1(int moviesId) {
		   Comingsoon movies = null;

	      Connection connection = Utils.getConnection();
	      try {
	         String sql = "SELECT * FROM COMINGSOON WHERE ID = ?";
	         PreparedStatement psmt = connection.prepareStatement(sql);
	         psmt.setInt(1, moviesId);

	         ResultSet rs = psmt.executeQuery();
	         rs.next();

	         String moviename = rs.getString("MOVIENAME");
	         
	         String genre = rs.getString("GENRE");
	         String detail = rs.getString("DETAIL");
	         movies = new Comingsoon(moviesId, moviename,genre,detail);
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return movies;
	   }
}
