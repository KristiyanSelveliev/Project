package market;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;

import controller.AdminManager;
import controller.DBManager;
import controller.ProductManager;
import controller.UserManager;
import dao.AdminDAO;
import dao.ProductDAO;
import dao.UserDAO;
import model.Admin;
import model.Customer;
import model.Product;
import model.Product.TYPES;

public class Demo {
	
	public static void main(String[] args) {
		Connection c=DBManager.getInstance().getConnection();
		
		
		//UserManager.getInstance().register("Pesho3","Gosho2","Peshko14","Pesheca001", "pesho3@abv.bg");
		Product p=new Product("tvmaika","mnogo qk",200,Product.TYPES.GSM);
		AdminManager.getInstance().addProduct(p, 20);
		
		
		/*try {
			UserDAO.getInstance().checkUsernameAndPass("Goshko", "Peshko");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//UserManager.getInstance().login("Peshko1", "Pesheca00");
		
	
	}
}
