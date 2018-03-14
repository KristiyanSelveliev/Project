package order;

import java.time.LocalDate;
import java.util.HashMap;

import product.Product;
import user.User;

public class Order {
	
	
	private static int CURRENT_ORDER = 0;
	private int id;
	private User user;
	private HashMap<Product, Integer> listProduct;
	private LocalDate date;
	private String status;
	
	public Order(User user, HashMap<Product, Integer> list) {
		this.user = user;
		this.listProduct.putAll(list);
		this.date = LocalDate.now();
		this.id = CURRENT_ORDER++;
		
	}
	
	
	
	public int getId() {
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
