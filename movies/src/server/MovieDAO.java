package server;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericBooleanPrefItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.SamplingCandidateItemsStrategy;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.CandidateItemsStrategy;
import org.apache.mahout.cf.taste.recommender.ItemBasedRecommender;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;


public enum MovieDAO {
instance;
	
	public  List<Movie> getRecommender(int userId) throws Exception  {
	      List<Movie> movieList = new ArrayList<Movie>();

//		  MysqlDataSource dataSource = new MysqlDataSource();
//		  dataSource.setServerName("localhost");
//		  dataSource.setUser("root");
//		  dataSource.setPassword("123456");
//		  dataSource.setDatabaseName("movies");
//
//		  MySQLJDBCDataModel model = new MySQLJDBCDataModel(dataSource,
//		    "merve", "userId", "movieId", "rating", null);
	      
			DataModel model = new FileDataModel(new File(getClass().getResource("/movies.csv").toURI()));

		  

	UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
	UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);
	UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
	List<RecommendedItem> recommendations = recommender.recommend(userId,10);
	for (RecommendedItem recommendation : recommendations) {
		String name =getMovieName((int) recommendation.getItemID());
		String imdb =getMovieIMDB((int) recommendation.getItemID());
		int tmdb =getTmdbId(((int) recommendation.getItemID()));

		Movie movie = new Movie(userId,(int) recommendation.getItemID(),recommendation.getValue(),name,imdb,tmdb);
		
		movieList.add(movie);
		 }
	
	return movieList;
	}
	public  String getMovieName(int movieId) throws Exception  {
		String movie = null;

	      Connection connection = Utils.getConnection();
	      try {
	         String sql = "SELECT * FROM movies WHERE movieId = ?";
	         PreparedStatement psmt = connection.prepareStatement(sql);
	         psmt.setFloat(1, movieId);

	         ResultSet rs = psmt.executeQuery();
	         rs.next();

	         int id=rs.getInt("movieId");
	         String title =rs.getString("title");
	         String genres =rs.getString("genres");
	        movie=title;;
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
		return movie;
	}
	public  String getMovieIMDB(int movieId) throws Exception  {
		String imdb = null;

	      Connection connection = Utils.getConnection();
	      try {
	         String sql = "SELECT * FROM links WHERE movieId = ?";
	         PreparedStatement psmt = connection.prepareStatement(sql);
	         psmt.setFloat(1, movieId);

	         ResultSet rs = psmt.executeQuery();
	         rs.next();

	         int id=rs.getInt("movieId");
	         String imdbid =rs.getString("imdbId");
	         int tmbdid =rs.getInt("tmdbId");
	        imdb=imdbid;
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
		return imdb;
	}
	public  int getTmdbId(int tmdbId) throws Exception  {
		int tmdb = 0 ;

	      Connection connection = Utils.getConnection();
	      try {
	         String sql = "SELECT * FROM links WHERE movieId = ?";
	         PreparedStatement psmt = connection.prepareStatement(sql);
	         psmt.setFloat(1, tmdbId);

	         ResultSet rs = psmt.executeQuery();
	         rs.next();

	         int id=rs.getInt("movieId");
	         String imdbid =rs.getString("imdbId");
	         int tmbdid =rs.getInt("tmdbId");
	        tmdb=tmbdid;
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
		return tmdb;
	}
	public  List<Movie> getMovieTitle(String t) throws Exception  {
	      List<Movie> movieList = new ArrayList<Movie>();

	      Connection connection = Utils.getConnection();
	      try {
	    	  
	         String sql = "SELECT * FROM movies WHERE title like ? ";
	         PreparedStatement psmt = connection.prepareStatement(sql);
	         psmt.setString(1,"%"+t+"%");

	         ResultSet rs = psmt.executeQuery();
	         while (rs.next()) {

	         int id=rs.getInt("movieId");
	         String title =rs.getString("title");
	         String genres =rs.getString("genres");
	 		int tmdb =getTmdbId(id);

	         
	         Movie movie = new Movie(id,title,tmdb);
	         movieList.add(movie);
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
		return movieList;
	}
	
}
