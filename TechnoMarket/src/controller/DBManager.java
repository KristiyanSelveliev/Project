package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
	
	private static final String DB_PASS = "user1";
	private static final String DB_USER = "User";
	private static final String DB_PORT = "3306";
	private static final String DB_IP = "192.168.1.4";
	private static final String DB_NAME = "legit";
	
	
	private static Connection connection;
	private static DBManager instance;
	
	public synchronized static DBManager getInstance() {
		
		if(instance==null) {
			instance=new DBManager();
		}
		return instance;
			
	}
	
	
	private DBManager() {
		//connection here
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Srry driver not loaded or does not exist");
			e.printStackTrace();
		}
		
		System.out.println("Driver loaded");
		
		
		try {
			connection=DriverManager.getConnection("jdbc:mysql://"+DB_IP+":"+DB_PORT+"/" + DB_NAME, DB_USER, DB_PASS);	
			
		} catch (SQLException e) {
			System.out.println("Srry connection failed");
		}
		
		
	}
	
	
	public Connection getConnection() {
		
		return connection;
		
	}
	
	

}
