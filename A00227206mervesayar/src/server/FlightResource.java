package server;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/flights")
public class FlightResource {

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
	public List<Flight> getFlights() {
		return FlightDAO.instance.getFlights();
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
	@Path("{flightId}")
	public Flight getFlight(@PathParam("flightId") String id) {
		return FlightDAO.instance.getFlight(id);
	}
	
	
	
	
	
	
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
	@Path("from"+"/{flightFrom}")
	public List<Flight> getFlightTo(@PathParam("flightFrom") String flight_from) {
		return FlightDAO.instance.getFlightTo(flight_from);
	}	

	
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
	@Path("{flightfrom}/{flightto}/{date}")
	public List<Flight> getFlightCustomer(@PathParam("flightfrom") String flightfrom,@PathParam("flightto") String flightto,@PathParam("date") String date) {
		return FlightDAO.instance.getFlightCustomer(flightfrom,flightto,date);
	}
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void postFlight(@FormParam("fid") String fid, @FormParam("flight_from") String from,
			@FormParam("flight_to") String to ,@FormParam("date") String date,
			@Context HttpServletResponse servletResponse) throws IOException {

		
		System.out.println("id = " + fid);
		System.out.println("from = " + from);
		Flight flight = new Flight(0, from, to,date);

		FlightDAO.instance.create(flight);
		servletResponse.sendRedirect("../flight.html");

	}

	@DELETE
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
	
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("{flightId}")
	public void deleteBook(@PathParam("flightId") String id, @Context HttpServletResponse servletResponse)
			throws IOException {
		
		Flight flight = FlightDAO.instance.getFlight(id);

		FlightDAO.instance.delete(flight);
	}

	

}