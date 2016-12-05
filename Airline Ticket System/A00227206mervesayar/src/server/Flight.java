package server;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "flight")
// Optional
@XmlType(propOrder = { "fid", "from", "to", "date" })

public class Flight {

	private int fid;
	private String from;
	private String to;
	private String date;
	
	

	public Flight() {
		
	}

	public Flight(int id, String from, String to, String date) {

		this.fid = id;
		this.from = from;
		this.to = to;
		this.date = date;
	}

	public Flight(String from, String to, String date) {

		this.from = from;
		this.to = to;
		this.date = date;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int id) {
		this.fid = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}

