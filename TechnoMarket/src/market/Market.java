package market;

import java.util.HashMap;
import java.util.HashSet;

import javax.jws.soap.SOAPBinding.Use;

import order.Order;
import product.Product;
import user.Admin;
import user.Customer;
import user.User;

public class Market {
	
	private static Market instance;
	private String name;
	private HashSet<Order> orders;
	private HashSet<User> users;
	private HashMap<Product.TYPES, HashMap<Product,Integer>> products;
	
	
	
	
	
	private Market() {
		
	}
	
	public static Market getInstance() {
		if(instance == null) {
			instance = new Market();
		}
		return instance;
		
	}

}
