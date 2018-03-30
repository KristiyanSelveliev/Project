package controller;

import java.sql.Connection;

public class DBManager {
	
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
	}
	
	
	public Connection getConnection() {
		
		return connection;
		
	}

}
