package dao;



import model.Product;

public interface IUserDAO {
	
	 boolean login(String name, String password) throws Exception;
	
	 void logout(String username, String password) throws Exception;
	
	 void changePassword(String username, String password) throws Exception;
	
	 void addProductCustomer(Product product, int quantity) throws Exception;
	
	 void searchProduct() throws Exception;
	
	 void removeProductCustomer(Product product) throws Exception;
	
	 void rateProduct(Product product, int rating) throws Exception;
	
	 void addToFavorite(Product product) throws Exception;
	
     void finishOrder() throws Exception;
	
	 boolean isAdmin(String username);
	
	
	
	

}
