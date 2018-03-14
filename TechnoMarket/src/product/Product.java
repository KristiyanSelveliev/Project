package product;

import java.util.ArrayList;

import market.Market;

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
	ArrayList<Integer> ratings;
	
	public Product(String model, String description, double price, TYPES type ) {
		this.model = model;
		this.description = description;
		this.price = price;
		this.type = type;
		//TODO id
		this.id=Product.CURRENT_ID;
		Product.CURRENT_ID++;
	}
	
	
	
	public double checkRating() {
		double sum = 0;
		for (Integer r : ratings) {
			sum += r.intValue();
		}
		return sum/ratings.size();
	}
	
	public void addRating(int rating) {
		if(rating > Market.MIN_RATING && rating <= Market.MAX_RATING) {
			this.ratings.add(rating);

		}
	}



	public static int getCURRENT_ID() {
		return CURRENT_ID;
	}



	public static void setCURRENT_ID(int cURRENT_ID) {
		CURRENT_ID = cURRENT_ID;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public TYPES getType() {
		return type;
	}



	public void setType(TYPES type) {
		this.type = type;
	}



	public String getModel() {
		return model;
	}



	public void setModel(String model) {
		this.model = model;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public ArrayList<Integer> getRatings() {
		return ratings;
	}



	public void setRatings(ArrayList<Integer> ratings) {
		this.ratings = ratings;
	}
	
	
	
	
	

}
