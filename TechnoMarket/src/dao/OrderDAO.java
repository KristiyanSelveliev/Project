package dao;

public class OrderDAO {
	
private static OrderDAO instance;
	
	private OrderDAO() {
			
	}
	
	public static  synchronized OrderDAO getInstance() {
		
		if(instance == null) {
			instance = new OrderDAO();
		}
		return instance;	
	}

}
