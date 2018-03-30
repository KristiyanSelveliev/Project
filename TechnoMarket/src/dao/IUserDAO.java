package dao;



import model.Product;

public interface IUserDAO {
	
	public void login(String name, String password) throws Exception;
	public void logout(String username, String password) throws Exception;
	public void changePassword(String username, String password) throws Exception;
	public void addProduct(Product product, int quantity) throws Exception;
	public void removeProduct(Product product) throws Exception;
	public boolean isAdmin();

}
