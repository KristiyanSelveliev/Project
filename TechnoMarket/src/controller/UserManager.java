package controller;

import java.sql.SQLException;

import dao.CustomerDAO;
import model.Customer;

public class UserManager {
	
	private static UserManager instance;
	
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
			CustomerDAO.getInstance().addUser(customer);
		}catch (SQLException e) {
			System.out.println("Sorry! Unsuccessful registration." + e.getMessage());
		}
	}

}
