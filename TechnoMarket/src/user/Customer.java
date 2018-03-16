package user;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.HashMap;

import order.Order;
import product.Product;

public class Customer extends User{
	
	private String address;
	private String phone;
	private LocalDate registrationDate;	
	HashMap<Product, Integer> cart;
	HashSet<Product> favoritesProduct;
	HashSet<Order> orders;	
	
	public Customer(String name, String lastName, String username, String password, String email) {
		super(name, lastName, username, password, email);
		this.registrationDate = LocalDate.now();
	}
	

	@Override
	protected
	void login() {
		super.login();;
		
	}

	
	void register() {
		this.getMarket().registrationRequest(this);
		
	}

	@Override
	protected
	void search() {
		
		
	}

	@Override
	protected
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
			else {
				System.out.println("This product is already in your favorite list");
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
	
	
	
	void rate(Product product, int rating) {
		if(this.getMarket().getProducts().containsKey(product.getType()) && 
				this.getMarket().getProducts().get(product.getType()).containsKey(product)) {
			for (Product p : this.getMarket().getProducts().get(product.getType()).keySet()) {
				if(p.equals(product)) {
					p.addRating(rating);
				}
			}
			
		}
	}

	@Override
	protected
	void removeProduct(Product product) {
		if(this.cart.containsKey(product)) {
			this.cart.remove(product);
		}
		
	}

	@Override
	protected
	void logout() {
		super.logout();
		
	}
	
	

}
