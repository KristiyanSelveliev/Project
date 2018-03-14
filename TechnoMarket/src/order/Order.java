package order;

import java.time.LocalDate;
import java.util.HashMap;

import product.Product;
import user.User;

public class Order {
	
	
	private String id;
	private User user;
	private HashMap<Product, Integer> listProduct;
	private LocalDate date;
	private String status;
	
	
	
	public String getId() {
		return id;
	}
	public User getUser() {
		return user;
	}
	
	public LocalDate getDate() {
		return date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
