package server;


import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "customer")
// Optional
@XmlType(propOrder = { "id","flight", "fname", "lname", "passportno","gender","seatno","cabintype","price" })
public class Customer {
	

	private int id;
	private String fname;
	private String lname;
	private String passportno;
    private String gender;
   
    private String seatno;
    private String cabintype;
    private int price;
     Flight flight;
  
    

	public Customer() {
	
	}


	

	public Customer(int id,Flight flight, String fname, String lname, String passportno, String gender, String seatno,
			String cabintype, int price) {
		
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.passportno = passportno;
		this.gender = gender;
		
		this.seatno = seatno;
		this.cabintype = cabintype;
		this.price = price;
		this.flight = flight;
	}




	public Customer(Flight flight,String fname, String lname, String passportno, String gender,  String seatno,
			String cabintype, int price ) {
		
		this.fname = fname;
		this.lname = lname;
		this.passportno = passportno;
		this.gender = gender;
		
		this.seatno = seatno;
		this.cabintype = cabintype;
		this.price = price;
		this.flight = flight;
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public String getPassportno() {
		return passportno;
	}


	public void setPassportno(String passportno) {
		this.passportno = passportno;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getSeatno() {
		return seatno;
	}


	public void setSeatno(String seatno) {
		this.seatno = seatno;
	}


	public String getCabintype() {
		return cabintype;
	}


	public void setCabintype(String cabintype) {
		this.cabintype = cabintype;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}




	public Flight getFlight() {
		return flight;
	}




	public void setFlight(Flight flight) {
		this.flight = flight;
	}
    

	


    
}
