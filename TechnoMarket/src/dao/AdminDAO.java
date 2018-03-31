package dao;

import java.sql.SQLException;

import model.Product;

public class AdminDAO implements IUserDAO{
	
	private static AdminDAO instance;
	
	public static synchronized AdminDAO getInstance(){
		if(instance == null) {
			instance = new AdminDAO();
		}
		return instance;
	}
	
	private AdminDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void login(String username, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logout(String username, String password) throws SQLException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePassword(String username, String password) throws SQLException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addProduct(Product product, int quantity) throws SQLException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeProduct(Product product) throws SQLException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAdmin() {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
