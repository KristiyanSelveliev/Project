package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserPojo {
	
	
	private String name;
	private String lastName;
	private String username;
	private String password;
	private String email;
	private LocalDateTime lastLogin;
	protected LocalDate registrationDate;	
	private boolean loginStatus;
	
	public UserPojo(String name, String lastName, String username, String password, String email,
			 LocalDateTime lastLogin, LocalDate registrationDate, boolean loginStatus) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		
		this.lastLogin = lastLogin;
		this.registrationDate = registrationDate;
		this.loginStatus = loginStatus;
	}
	
	public UserPojo(String name, String lastName, String username, String password, String email) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
	
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

	public boolean isLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(boolean loginStatus) {
		this.loginStatus = loginStatus;
	}
	
	
	
	
}
