package server;


import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/movies")

public class MovieResource {

	

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
	@Path("{userId}")

	public List<Movie> getMovies(@PathParam("userId") String id) throws Exception {
		
		return MovieDAO.instance.getRecommender(Integer.parseInt(id));
		
	
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
	@Path("m"+"/{movieId}")

	public String getMovieName(@PathParam("movieId") String id) throws Exception {
		
		return MovieDAO.instance.getMovieName(Integer.parseInt(id));
		
	
	}
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
	@Path("title"+"/{movieid}")

	public List<Movie> getMovieTitle(@PathParam("movieid") String movieid) throws Exception {
		
		return MovieDAO.instance.getMovieTitle(movieid);
		
	
	}
}
