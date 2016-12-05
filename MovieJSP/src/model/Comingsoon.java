package model;

public class Comingsoon {
	int id;
	String moviename;
	String genre;
	String detail;
	public Comingsoon(int id, String moviename, String genre, String detail) {
		
		this.id = id;
		this.moviename = moviename;
		this.genre = genre;
		this.detail = detail;
	}
	public Comingsoon(String moviename, String genre, String detail) {
		
		this.moviename = moviename;
		this.genre = genre;
		this.detail = detail;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}

	
}
