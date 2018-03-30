package dao;

public class UserDAO implements IUserDAO {
	
	private static UserDAO instance;
	
	private UserDAO() {
			
	}
	
	public static  synchronized UserDAO getInstance() {
		
		if(instance==null) {
			instance=new UserDAO();
		}
		return instance;	
	}
	

}
