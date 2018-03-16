package market;



import myExceptions.InvalidFormatInput;
import product.Product;
import product.Product.TYPES;
import user.User;
import validator.Validator;

public class Admin extends User{
	
	

	public Admin(String name, String lastName, String username, String password, String email) {
		super(name, lastName, username, password, email);
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
		//TODO validate quantity
	}
	
	void editProductQuantity(Product product, int quantity) {		
		if(getMarket().getProducts().get(product.getType()).containsKey(product)) {
			getMarket().getProducts().get(product.getType())
			.put(product, quantity);
		
		}
		//TODO validate quantity
	}
	
	
	
	void createProduct(String model, String description, double price, Product.TYPES type, int quantity) {
		try {
		if(Validator.validateString(model) && Validator.validateString(description) &&
				Validator.checkForPositiveNum(price) && Validator.checkForPositiveNum(quantity)) {
			if(this.getMarket().getTypes().contains(type)) {
				Product product = new Product(model, description, price, type);
				getMarket().getProducts().get(product.getType()).put(product, quantity);
			}
			else {
				this.getMarket().getTypes().add(type.toString());
				Product product = new Product(model, description, price, type);
				getMarket().getProducts().get(product.getType()).put(product, quantity);				
			}			
		}
		else {
			String cause;
			if(!Validator.validateString(model) || !Validator.validateString(description)) {
				cause = "Please enter a valid string";
			}
			else {
				cause = "Please enter a positive number";
			}
			throw new InvalidFormatInput(cause);
		}
		}catch(InvalidFormatInput e) {
			// TODO ??????????
		}
		
		
		
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
