package model;

public class BagLinee {
	 int id;
	   Movies movies;
	   
	   String review;

	public BagLinee(Movies movies, String review) {
	
		this.movies = movies;
		this.review = review;
	}

	public BagLinee(int id, Movies movies, String review) {
		
		this.id = id;
		this.movies = movies;
		this.review = review;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Movies getMovies() {
		return movies;
	}

	public void setMovies(Movies movies) {
		this.movies = movies;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}
	   

	   

	
}
