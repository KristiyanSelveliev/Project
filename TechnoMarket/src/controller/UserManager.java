package controller;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;

import dao.CustomerDAO;
import model.Customer;
import model.User;
import myExceptions.InvalidFormatInput;
import validator.Validator;

public class UserManager {
	
	private static UserManager instance;
	private static HashMap<String, User> users = new HashMap<>();

	
	public synchronized static UserManager getInstance() {
		
		if(instance == null) {
			instance = new UserManager();
		}
		return instance;
			
	}
	
	private UserManager() {
		
	}
	
	public void register(String name, String lastName, String username, String password, String email) {
		Customer customer = new Customer(name, lastName, username, password, email);
		try {			
			
			if(Validator.validUsername(username) && Validator.validateString(name)&& Validator.validPassword(password) &&
					Validator.validateString(lastName) && Validator.validEMail(email)) {
				if(!CustomerDAO.getInstance().checkUsernameAndPass(username, password)) {
					CustomerDAO.getInstance().addUser(customer);
					return;
				}
				throw new InvalidFormatInput("The username is already taken. Choose another username.");				
			}
			else {
				if(!Validator.validateString(name) && !Validator.validateString(lastName)) {
					throw new InvalidFormatInput("Invalid name format.");
				}
				else if(!Validator.validUsername(username)) {
					throw new InvalidFormatInput("Enter a valid username - al least 4 characters, without spaces.");
				}
				else if(!Validator.validEMail(email)) {
					throw new InvalidFormatInput("Invalid email format.");
				}
				else if(!Validator.validPassword(password)) {
					throw new InvalidFormatInput("Invalid password - password must contain at 8 characters, at least 1 lower case letter,"
							+ " at least 1 upper case letter at least 1 numeric character, without spaces ");
				}				
			}
			
		}catch (Exception e) {
			System.out.println("Sorry! Unsuccessful registration." + e.getMessage());
		}
	}
	
	public void login(String username, String password) {
		// TODO add max_login_request
		try {
			if(Validator.validUsername(username) && Validator.validPassword(password)) {
				if(CustomerDAO.getInstance().checkUsernameAndPass(username, password)) {
					users.get(username).setLoginStatus(true);					
					users.get(username).setLastLogin(LocalDateTime.now());
					System.out.println("Successful login");
					CustomerDAO.getInstance().login(username, password);
					return;
				}
				throw new InvalidFormatInput("Not existing user!");
			}
			throw new InvalidFormatInput("Invalid username or password!");			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void logout(String username, String password)  {
		try {
			CustomerDAO.getInstance().logout(username, password);
		} catch (SQLException e) {
			System.out.println("Invalid operation" + e.getMessage());
		}	
		
	}
	
	public void changePassword(String username, String password) {
		try {
			CustomerDAO.getInstance().changePassword(username, password);
		}catch (SQLException e) {
			System.out.println("Invalid operation" + e.getMessage());
		}
	}
	
	public void search(String product) {
		
		
	}

}
