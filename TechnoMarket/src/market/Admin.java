package market;

import product.Product;
import product.Product.TYPES;
import user.User;

public class Admin extends User{
	
	

	public Admin(String name, String lastName, String username, String password, String email) {
		super(name, lastName, username, password, email);
		// TODO Auto-generated constructor stub
	}



	@Override
	protected
	void login() {
		super.login();
		
	}



	@Override
	protected
	void search() {
		super.search();
		
	}

	@Override
	protected void addProduct(Product product, int quantity) {
		if(getMarket().getProducts().get(product.getType()).containsKey(product)) {
			getMarket().getProducts().get(product.getType())
			.put(product, getMarket().getProducts().get(product.getType()).get(product) + quantity);
		
		}	
		
		
	}
	
	void editProductQuantity(Product product, int quantity) {
		if(getMarket().getProducts().get(product.getType()).containsKey(product)) {
			getMarket().getProducts().get(product.getType())
			.put(product, quantity);
		
		}		
		
	}
	
	
	
	void createProduct(String model, String description, double price, Product.TYPES type, int quantity) {
		Product product = new Product(model, description, price, type);
		getMarket().getProducts().get(product.getType()).put(product, quantity);
	}


	@Override
	protected
	void removeProduct(Product product) {
		if(getMarket().getProducts().get(product.getType()).containsKey(product)) {
			getMarket().getProducts().get(product.getType()).remove(product);
		}
		
	}

	@Override
	protected
	void logout() {
		super.logout();
		
	}
	
	

}
