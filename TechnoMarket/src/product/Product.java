package product;

import java.util.ArrayList;

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
	
	
	
	public double checkRating() {
		double sum = 0;
		for (Integer r : ratings) {
			sum += r.intValue();
		}
		return sum/ratings.size();
	}
	
	
	

}
