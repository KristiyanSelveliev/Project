package dao;



import model.Product;

public interface IUserDAO {
	
	public void login(String name, String password) throws Exception;
	public void logout(String username, String password) throws Exception;
	public void changePassword(String username, String password) throws Exception;
	public void addProductAdmin(Product product, int quantity) throws Exception;
	public void addProductCustomer(Product product, int quantity) throws Exception;
	public void searchProduct() throws Exception;
	public void removeProductAdmin(Product product) throws Exception;
	public void removeProductCustomer(Product product) throws Exception;
	public void updateProductAdmin(Product product) throws Exception;
	public void createProductAdmin(Product product) throws Exception;
	public void rateProduct(Product product, int rating) throws Exception;
	public void addToFavorite(Product product) throws Exception;
	public void finishOrder() throws Exception;
	public boolean isAdmin();

}
