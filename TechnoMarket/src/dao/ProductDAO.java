package dao;

public class ProductDAO {
	
private static ProductDAO instance;
	
	private ProductDAO() {
			
	}
	
	public static  synchronized ProductDAO getInstance() {
		
		if(instance == null) {
			instance = new ProductDAO();
		}
		return instance;	
	}

}
