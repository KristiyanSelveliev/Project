package user;

import java.time.LocalDate;
import java.time.LocalDateTime;



import market.Market;

abstract public class User {
	
	private String name;
	private String lastName;
	private String username;
	private String password;
	private String email;
	private String phone;
	private LocalDateTime lastLogin;
	private LocalDate registrationDate;	
	private Market market = Market.getInstance();
	private boolean loginStatus;

	
	void login() {
		market.loginRequest(this);
		
	}
	void logout() {
		this.loginStatus = false;
	}
	abstract void register();
	abstract void search();
	abstract void addProduct();
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
	

	
	
	
	
	

}
