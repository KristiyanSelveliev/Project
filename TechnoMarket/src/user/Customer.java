package user;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.HashMap;

import order.Order;
import product.Product;

public class Customer extends User{
	
	private String address;
	private String phone;
	private LocalDate registrationDate;	
	HashMap<Product, Integer> cart = new HashMap<>();
	HashSet<Product> favoritesProduct = new HashSet<>();
	HashSet<Order> orders = new HashSet<>();
	Scanner scanner = new Scanner(System.in);
	
	public Customer(String name, String lastName, String username, String password, String email) {
		super(name, lastName, username, password, email);
		this.registrationDate = LocalDate.now();
	}
	

	@Override
	public void login() {
		super.login();
		//TODO tozi metod da se iznese v Market
		
	}

	
	public void register() {
		this.getMarket().registrationRequest(this);
		
	}

	@Override
	public void search() {
		
		
	}

	@Override
	public void addProduct(Product product, int quantity) {
		if(getMarket().checkQuantity(product, quantity)) {
			if(!cart.containsKey(product.getModel())) {
				cart.put(product, quantity);
			}
			else {
				cart.put(product, cart.get(product) + quantity);
			}	
		}
			
		
	}	
	
	public void addToFavorites(Product product) {
		if(this.isLoginStatus()) {
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
	
	public void finishOrder() {
		//proba
		if(this.isLoginStatus()) {
			Order order = new Order(this, cart);
			orders.add(order);
			getMarket().removeProducts(this.cart);
			this.cart.clear();
			System.out.println("Please enter delivery address: ");
			this.address = scanner.nextLine();
			System.out.println("Your order is finished");
			
		}
		else {
			System.out.println("Please log in");
			//TODO exception
		}
		
	}
	
	
	
	public void rate(Product product, int rating) {
		if(this.isLoginStatus()) {
			if(this.getMarket().getProducts().containsKey(product.getType()) && 
					this.getMarket().getProducts().get(product.getType()).containsKey(product)) {
				for (Product p : this.getMarket().getProducts().get(product.getType()).keySet()) {

					if(p.equals(product)) {
						p.addRating(rating);
						
					}
				}			
			}			
		}
		else {
			System.out.println("Can't rate! Please log in");
		}
		
	}

	@Override
	public void removeProduct(Product product) {
		if(this.cart.containsKey(product)) {
			this.cart.remove(product);
		}
		
	}

	@Override
	public void logout() {
		super.logout();
		//TODO da se iznese v Market tozi metod
		
	}
	
	public void subscribe() {
		getMarket().subscribeUser(this);
	}
	
	//TODO unsubscribe method
	//TODO Recently Viewed Products
	
	

}
