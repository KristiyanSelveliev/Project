package user;

import java.util.HashMap;
import java.util.HashSet;
import java.util.HashMap;

import order.Order;
import product.Product;

public class Customer extends User{
	
	private String address;
	private String phone;
	HashMap<Product, Integer> cart;
	HashSet<Product> favoritesProduct;
	HashSet<Order> orders;	
	
	public Customer(String name, String lastName, String username, String password, String email) {
		super(name, lastName, username, password, email);
	}
	

	@Override
	void login() {
		super.login();;
		
	}

	
	void register() {
		this.getMarket().registrationRequest(this);
		
	}

	@Override
	void search() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void addProduct(Product product, int quantity) {
		if(getMarket().checkQuantity(product, quantity)) {
			if(!cart.containsKey(product.getModel())) {
				cart.put(product, quantity);
			}
			else {
				cart.put(product, cart.get(product) + quantity);
			}	
		}
			
		
	}	
	
	void addToFavorites(Product product) {
		if(isLoginStatus()) {
			if(!favoritesProduct.contains(product)) {
				favoritesProduct.add(product);
			}
		}
		else {
			System.out.println("Please login");
		}
		
	}
	
	void pay() {
		if(isLoginStatus()) {
			Order order = new Order(this, cart);
			orders.add(order);
			getMarket().removeProducts(this.cart);
			this.cart.clear();
			
		}
		else {
			System.out.println("Please log in");
		}
		
	}
	
	void refuseOrder() {
		
	}
	
	void rate() {
		
	}

	@Override
	void removeProduct() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void logout() {
		// TODO Auto-generated method stub
		
	}

}
