package market;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

import order.Order;
import product.Product;
import product.Product.TYPES;
import user.Customer;
import user.User;
import validator.Validator;

public class Market {

	public static final int MIN_RATING = 1;
	public static final int MAX_RATING = 5;
	private static final int MAX_LOGIN_REQUEST = 5;
	private static Market instance;
	private String name;
	//TODO Customer orders
	private HashSet<Order> orders;
	private static HashMap<String, User> users;
	private static HashMap<Product.TYPES, HashMap<Product, Integer>> products;
	Scanner scanner = new Scanner(System.in);

	private Market() {

	}

	public static Market getInstance() {
		if (instance == null) {
			instance = new Market();
		}
		return instance;

	}

	public void loginRequest(User user) {
		int counter = MAX_LOGIN_REQUEST;
		boolean invalidLogin = false;

		while (counter > 0) {
			System.out.println("Enter a username: ");
			String username = scanner.nextLine();

			if (Validator.validUsername(username)) {
				if (users.containsKey(username)) {
					System.out.println("Enter a password: ");
					String password = scanner.nextLine();
					if (users.get(username).getPassword().equals(password)) {
						users.get(username).setLoginStatus(true);
						users.get(username).setLastLogin(LocalDateTime.now());
						return;
					} else {
						invalidLogin = true;
						System.out.println("Invalid password. Try again.");
					}
				} else {
					System.out.println("Not existing user! ");
					// TODO registration
				}

			} else {
				invalidLogin = true;
			}

			if (invalidLogin) {
				System.out.println("Invalid password or username");
			}
			counter--;
		}
		
		if(counter == 0) {
			System.out.println("Sorry, you weren't able to login. Try again later.");
		}

	}

	public void registrationRequest(User user) {
		System.out.println("Enter name and lastName");
		String name = scanner.nextLine();
		String lastName = scanner.nextLine();
		System.out.println("Enter username:");
		String username = scanner.nextLine();
		if(Validator.validUsername(username)) {
			if(!users.containsKey(username)) {
				System.out.println("Enter email: ");
				String email = scanner.nextLine();
				if(Validator.validEMail(email)) {
					System.out.println("Enter a password - password must be... ");
					String password = scanner.nextLine();
					System.out.println("Enter pass again:");
					String password1 = scanner.nextLine();
					if(password.equals(password1)) {					
						Customer customer = new Customer(name, lastName, username, password, email);
						customer.setRegistrationDate(LocalDate.now());
						this.users.put(username, customer);
					}
					else {
						System.out.println("DIfferent passwords");
					}
				}
				else {
					System.out.println("Invalid email");
				}
				
			}
			else {
				System.out.println("Enter a different username");
			}			
		}
		else {
			System.out.println("Enter a valid username");
		}
		
	}

	public void search() {
		String product = scanner.nextLine();
		HashSet<Product> searchedProducts = new HashSet<>();
		for (Map.Entry<Product.TYPES, HashMap<Product, Integer>> key : products.entrySet()) {
			for (Product pr : key.getValue().keySet()) {
				if(pr.getModel().contains(product)) {
					searchedProducts.add(pr);				
				}
			}
		}
		System.out.println(searchedProducts);
		
	}
	
	public void sellProducts(HashMap<Product, Integer> products) {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*public HashSet<Order> getOrders() {
		return orders;
	}*/

	/*public void setOrders(HashSet<Order> orders) {
		this.orders = orders;
	}*/

	/*public static HashMap<String, User> getUsers() {
		return users;
	}*/

	/*public static void setUsers(HashMap<String, User> users) {
		Market.users = users;
	}*/

	public static HashMap<Product.TYPES, HashMap<Product, Integer>> getProducts() {
		return (HashMap<TYPES, HashMap<Product, Integer>>) Collections.unmodifiableMap(products);
	}

	public static void setProducts(HashMap<Product.TYPES, HashMap<Product, Integer>> products) {
		Market.products = products;
	}


	

	public boolean checkQuantity(Product product, int quantity) {
		if(this.products.containsKey(product.getType())) {
			
			for (Map.Entry<Product, Integer> entry : products.get(product.getType()).entrySet()) {
				if(entry.getKey().equals(product) && entry.getValue() >= quantity) {
					return true;
				}
			}
			
		}
		return false;
	}

	public void removeProducts(HashMap<Product, Integer> products) {
		for (Product product : products.keySet()) {
			this.products.get(product.getType())
			.put(product, this.products.get(product.getType()).get(product) - products.get(product));
			// da se testva!!!			
		}
		
	}
	
	/*public void removeProduct(Product product) {
		if(this.products.ge) {
			
		}
	}*/
		
	

	
	

}
