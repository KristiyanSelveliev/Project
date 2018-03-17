package order;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import product.Product;
import user.User;

public class Order {
	
	
	private static int CURRENT_ORDER = 0;
	private int id;
	private User user;
	private HashMap<Product, Integer> listProduct = new HashMap<>();
	private LocalDate date;
	private String status;
	private double totalSum;
	
	public Order(User user, HashMap<Product, Integer> list) {
		this.user = user;
		this.listProduct.putAll(list);
		this.date = LocalDate.now();
		this.id = CURRENT_ORDER++;
		for (Map.Entry<Product, Integer> e : list.entrySet()) {
			this.totalSum += e.getKey().getPrice()*e.getValue();
		}
		
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
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Product, Integer> e: this.listProduct.entrySet()) {
			sb.append(e.getKey().getModel() + " ");
			sb.append(e.getValue());
			sb.append("\n");
		}
		
		return "Order number # " + this.id + "\n" +
		"Placed on: " + date + "\n" + 
		sb.toString() + "\n" + 
		this.totalSum;
	}
	
	

}
