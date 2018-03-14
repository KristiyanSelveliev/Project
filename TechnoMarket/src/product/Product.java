package product;

public class Product {
	public enum TYPES {
		PC, GSM, TV
	}
	
	
	private static int CURRENT_ID = 0;
	
	private int id;
	private double price;
	private TYPES type;
	private String model;
	private String description;
	
	

}
