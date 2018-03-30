package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import controller.DBManager;
import model.Customer;
import model.Product;

public class CustomerDAO implements IUserDAO{
	
	private static CustomerDAO instance;
	private static Connection connection;
	
	public static synchronized CustomerDAO getInstance(){
		if(instance == null) {
			instance = new CustomerDAO();
		}
		return instance;
	}
	
	private CustomerDAO() {
		connection = DBManager.getInstance().getConnection();
	}
	
	public void addUser(Customer customer) throws SQLException{
		PreparedStatement pStatement = connection.prepareStatement("INSERT INTO users (name, lastName, username, password, email, loginStatus) VALUES (?,?,?,?,?,?)");
		pStatement.setString(1, customer.getName());
		pStatement.setString(2, customer.getLastName());
		pStatement.setString(3, customer.getUsername());
		pStatement.setString(4, customer.getPassword());
		pStatement.setString(5, customer.getEmail());
		pStatement.setBoolean(6, true);
		pStatement.executeUpdate();		
	}
	
	public boolean checkUsernameAndPass(String username, String password) throws SQLException{ // ??? exception-a
		PreparedStatement pStatement = connection.prepareStatement("SELECT COUNT(*) FROM users WHERE username = ? AND password = ?");
		pStatement.setString(1, username);
		pStatement.setString(2, password);
		ResultSet resultSet = pStatement.executeQuery();
		if(resultSet.getInt(1) == 1 ) {
			return true;
		}
		return false;			
	}
	
	

	@Override
	public void login(String username, String password) throws SQLException{
		if(this.checkUsernameAndPass(username, password)) {
			PreparedStatement pStatement = connection.prepareStatement("UPDATE users SET loginStatus = "+1+" WHERE username = "+username+" ");
			pStatement.executeUpdate();
		}
		
		
	}

	@Override
	public void logout(String username, String password) throws SQLException{
			PreparedStatement pStatement = connection.prepareStatement("UPDATE users SET loginStatus = "+0+" WHERE username = "+username+" ");
			pStatement.executeUpdate();		
	}

	@Override
	public void changePassword(String username, String password) throws SQLException {
		if(this.checkUsernameAndPass(username, password)) {
			PreparedStatement pStatement = connection.prepareStatement("UPDATE users SET password = "+password+" WHERE username = "+username+" ");
			pStatement.executeUpdate();
		}
		
	}

	@Override
	public void addProduct(Product product, int quantity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAdmin() {
		// TODO Auto-generated method stub
		return false;
	}

}
