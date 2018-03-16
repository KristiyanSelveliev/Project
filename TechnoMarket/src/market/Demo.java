package market;

import java.util.HashSet;

import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

import org.omg.CORBA.PUBLIC_MEMBER;

import product.Product;
import product.Product.TYPES;
import user.Admin;
import user.Customer;

public class Demo {
		
	public static void main(String[] args) {
		
		Market market = Market.getInstance();
		
		
		//Customer customer = Market.getRandomCust();
		Admin admin = Market.getRandomAdmin();
		
		
		Product product2 = null;
		for (int i = 0; i < 5; i++) {
			
			Product product = new Product("model" + (i + 1), "descr"+ (i + 1), 100, TYPES.PC);
			product2 = product;
			admin.createProduct(product, 5);
			
			
		}
		
		for (int i = 0; i < 1; i++) {
			Customer customer = new Customer("Customer" + (i + 1), "Cus", "peshko" + (i + 1), "admin40@1A" + (i + 1), "admin@abv.bg");
			//Product product = new Product("model" + (i + 1), "descr"+ (i + 1), 100, TYPES.PC);
			customer.addProduct(product2, 2);
			customer.rate(product2, 300);
			customer.login();
			//customer.addToFavorites(product2);
			//customer.finishOrder();
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
