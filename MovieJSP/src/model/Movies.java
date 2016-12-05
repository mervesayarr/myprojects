package model;

public class Movies {
	private int id;
	private String movieName;
	private String writerName ;
	private String directorName ;
	private double imdbRating ;
	private String genre;
	public Movies(String movieName, String writerName, String directorName, double imdbRating, String genre) {
		
		this.movieName = movieName;
		this.writerName = writerName;
		this.directorName = directorName;
		this.imdbRating = imdbRating;
		this.genre = genre;
	}
	public Movies(int id, String movieName, String writerName, String directorName, double imdbRating, String genre) {
		
		this.id = id;
		this.movieName = movieName;
		this.writerName = writerName;
		this.directorName = directorName;
		this.imdbRating = imdbRating;
		this.genre = genre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getWriterName() {
		return writerName;
	}
	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}
	public String getDirectorName() {
		return directorName;
	}
	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}
	public double getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(double imdbRating) {
		this.imdbRating = imdbRating;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}

}
