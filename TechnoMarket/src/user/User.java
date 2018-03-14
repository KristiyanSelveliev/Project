package user;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

import market.Market;
import product.Product;

abstract public class User {
	
	private String name;
	private String lastName;
	private String username;
	private String password;
	private String email;
	private LocalDateTime lastLogin;
	private LocalDate registrationDate;	
	private Market market = Market.getInstance();
	private boolean loginStatus;
	
	public User(String name, String lastName, String username, String password, String email) {
		this.setName(name);
		this.setLastName(lastName);
		this.username = username;
		this.password = password;
		this.email = email;
	}

	
	void login() {
		market.loginRequest(this);
		
	}
	void logout() {
		this.loginStatus = false;
	}
	
	void search() {
		market.search();
		
	}
	abstract void addProduct(Product product, int quantity);
	abstract void removeProduct();
	
	
	public boolean isLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(boolean loginStatus) {
		this.loginStatus = loginStatus;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public LocalDateTime getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}
	public LocalDate getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}


	public Market getMarket() {
		return market;
	}


	public void setMarket(Market market) {
		this.market = market;
	}
	
	
	
	
	
	

	
	
	
	
	

}
