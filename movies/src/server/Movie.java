package server;


import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "movie")
// Optional
@XmlType(propOrder = { "userId", "movieId", "rating","name","imdb","tmdb" })

public class Movie {

	int userId;
	int movieId;
	float rating;
	String name;
	String imdb;
	int tmdb;
	public Movie() {
	}

	public Movie(int userId, int movieId, float rating,String name,String imdb,int tmdb) {
		this.userId = userId;
		this.movieId = movieId;
		this.rating = rating;
		this.name=name;
		this.imdb=imdb;
		this.tmdb=tmdb;
	}
	
	

	public Movie(int movieId, String name,int tmdb) {
	
		this.movieId = movieId;
		this.name = name;
		this.tmdb=tmdb;
	}

	public int getTmdb() {
		return tmdb;
	}

	public void setTmdb(int tmdb) {
		this.tmdb = tmdb;
	}

	public String getImdb() {
		return imdb;
	}

	public void setImdb(String imdb) {
		this.imdb = imdb;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	
}
