package dao;

import java.sql.SQLException;

import model.Product;

public interface IUserDAO {
	
	public void login() throws Exception;
	public void logout() throws Exception;
	public void changePassword() throws Exception;
	public void addProduct(Product product, int quantity) throws Exception;
	public void removeProduct(Product product) throws Exception;
	public boolean isAdmin();

}
