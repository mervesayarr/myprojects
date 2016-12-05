package model;

import dao.BaggDAO;

public class Customer {
	 private int id;
	   private String name;
	   private String password;
	   private Bagg bag;
	public Customer(String name, String password) {
		
		this.name = name;
		this.password = password;
		
	}
	public Customer(int id, String name, String password) {
		
		this.id = id;
		this.name = name;
		this.password = password;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	 public Bagg getBag() {
	      Bagg loadedBag = null;
	      if (bag != null) {
	         return bag;
	      } else {
	         loadedBag = BaggDAO.instance.getFromCustomerId(this.id);
	      }
	      return loadedBag;
	   }
	 public void setBag(Bagg bag) {
	      this.bag = bag;
	   }

}
