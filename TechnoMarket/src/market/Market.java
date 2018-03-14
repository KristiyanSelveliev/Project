package market;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

import order.Order;
import product.Product;
import user.Admin;
import user.Customer;
import user.User;
import validator.Validator;

public class Market {

	private static final int MAX_RATING = 5;
	private static final int MAX_LOGIN_REQUEST = 5;
	private static Market instance;
	private String name;
	private HashSet<Order> orders;
	private static HashMap<String, User> users;
	private static HashMap<Product.TYPES, HashMap<Product, Integer>> products;
	private double money;
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

}
