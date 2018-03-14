package demo;

import product.Product;

public class Demo {
	
	public static void main(String[] args) {
		
		System.out.println("Hi");
		//Testing
		
		Product x=new Product("x", "x", 200, product.Product.TYPES.GSM);
		Product y=new Product("y","y",300,product.Product.TYPES.PC);
		System.out.println(Product.getCURRENT_ID());
		
	}

}
