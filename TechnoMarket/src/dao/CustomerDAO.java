package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.imageio.spi.RegisterableService;

import controller.DBManager;
import model.Customer;
import model.Product;

public class CustomerDAO implements IUserDAO{
	
	private static CustomerDAO instance;
	
	public static synchronized CustomerDAO getInstance(){
		if(instance == null) {
			instance = new CustomerDAO();
		}
		return instance;
	}
	
	private CustomerDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void addUser(Customer customer) throws SQLException{
		Connection connection = DBManager.getInstance().getConnection();
		PreparedStatement pStatement = connection.prepareStatement("INSERT INTO users (name, lastName, username, password, email) VALUES (?,?,?,?,?)");
		pStatement.setString(1, customer.getName());
		pStatement.setString(2, customer.getLastName());
		pStatement.setString(3, customer.getUsername());
		pStatement.setString(4, customer.getPassword());
		pStatement.setString(5, customer.getEmail());
		pStatement.executeUpdate();
		
	}
	
	

	@Override
	public void login() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePassword() {
		// TODO Auto-generated method stub
		
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
