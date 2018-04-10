package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import controller.DBManager;
import model.Order;
import model.User;

public class OrderDAO {
	
private static OrderDAO instance;
private static Connection connection;
	
	private OrderDAO() {
		connection= DBManager.getInstance().getConnection();	
	}
	
	public static  synchronized OrderDAO getInstance() {
		
		if(instance == null) {
			instance = new OrderDAO();
		}
		return instance;	
	}
	
	public void addOrder(Order order) throws SQLException{
		
		String sql = "INSERT INTO orders(id_user, total_cost, date) VALUES (?,?,?)";
		PreparedStatement pStatement = connection.prepareStatement(sql);
		pStatement.setInt(1, order.getUser().getId());
		pStatement.setDouble(2, order.getTotalSum());
		java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        pStatement.setTimestamp(1, date);
        
       //TODO da se dobavi v order_has_products
		
		
		
	}

}
