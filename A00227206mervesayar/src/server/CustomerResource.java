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

@Path("/customers")
public class CustomerResource {
	
	

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
	public List<Customer> getCustomers() {
		return CustomerDAO.instance.getCustomers();
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
	@Path("{customerId}")
	
	public Customer getCustomer(@PathParam("customerId") String id) {
		return CustomerDAO.instance.getCustomer(Integer.parseInt(id));
	}


	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
	@Path("{customerfname}/{customerlname}")
	
	public List<Customer> getCustomerByName(@PathParam("customerfname") String fname ,@PathParam("customerlname") String lname) {
		return CustomerDAO.instance.getCustomerByName(fname,lname);
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
	@Path("{customerfname}/{customerlname}/{flightid}")
	
	public List<Customer> getCustomerByNameFlight(@PathParam("customerfname") String fname ,@PathParam("customerlname") String lname,@PathParam("flightid") int flightid) {
		return CustomerDAO.instance.getCustomerByNameFlight(fname,lname,flightid);
	}
	
	

	      
	
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void postCustomer(@FormParam("id") String id, @FormParam("fid") String fid,
			@FormParam("fname") String fname ,@FormParam("lname") String lname,
			@FormParam("passportno") String passportno ,@FormParam("gender") String gender
		 ,@FormParam("seatno") String seatno,
			@FormParam("cabintype") String cabintype ,@FormParam("price") int price,
			
			
			@Context HttpServletResponse servletResponse) throws IOException {

		
		Flight flightid = FlightDAO.instance.getFlight(fid);
		Customer customer = new Customer(1,flightid,fname,lname,passportno,gender,seatno,cabintype,price);

		CustomerDAO.instance.create(customer);
		servletResponse.sendRedirect("../index.html");

	}

	@DELETE
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
	
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("{customerId}")
	public void deleteBook(@PathParam("customerId") String id, @Context HttpServletResponse servletResponse)
			throws IOException {
		
		Customer customer = CustomerDAO.instance.getCustomer(Integer.parseInt(id));

		CustomerDAO.instance.delete(customer);
		System.out.println("Deleted");
	}

	

}