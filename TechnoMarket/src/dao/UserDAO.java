package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.DBManager;
import model.Customer;
import model.Product;

public class UserDAO implements IUserDAO {

	private static UserDAO instance;
	private static Connection connection;

	public static synchronized UserDAO getInstance() {
		if (instance == null) {
			instance = new UserDAO();
		}
		return instance;
	}

	private UserDAO() {
		connection = DBManager.getInstance().getConnection();
	}

	public void addUser(Customer customer) throws SQLException {
		PreparedStatement pStatement = connection.prepareStatement(
				"INSERT INTO users (name, lastName, username, password, email, loginStatus) VALUES (?,?,?,?,?,?)");
		pStatement.setString(1, customer.getName());
		pStatement.setString(2, customer.getLastName());
		pStatement.setString(3, customer.getUsername());
		pStatement.setString(4, customer.getPassword());
		pStatement.setString(5, customer.getEmail());
		pStatement.setBoolean(6, true);
		pStatement.executeUpdate();
	}

	public boolean checkUsernameAndPass(String username, String password) throws SQLException { // ??? exception-a
		PreparedStatement pStatement = connection
				.prepareStatement("SELECT COUNT(*) FROM users WHERE username = ? AND password = ?");
		pStatement.setString(1, username);
		pStatement.setString(2, password);
		ResultSet resultSet = pStatement.executeQuery();
		if (resultSet.getInt(1) == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean login(String username, String password) throws SQLException {
		if (this.checkUsernameAndPass(username, password)) {
			PreparedStatement pStatement = connection
					.prepareStatement("UPDATE users SET loginStatus = " + 1 + " WHERE username = " + username + " ");
			pStatement.executeUpdate();
			return true;
		}
		return false;

	}

	@Override
	public void logout(String username, String password) throws SQLException {
		PreparedStatement pStatement = connection
				.prepareStatement("UPDATE users SET loginStatus = " + 0 + " WHERE username = " + username + " ");
		pStatement.executeUpdate();
	}

	@Override
	public void changePassword(String username, String password) throws SQLException {
		if (this.checkUsernameAndPass(username, password)) {
			PreparedStatement pStatement = connection
					.prepareStatement("UPDATE users SET password = ? WHERE username = ? ");
			pStatement.setString(1, password);
			pStatement.setString(2, username);
			pStatement.executeUpdate();
		}

	}

	

	@Override
	public void addProductCustomer(Product product, int quantity) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void searchProduct() throws Exception {
		// TODO Auto-generated method stub

	}

	

	@Override
	public void removeProductCustomer(Product product) throws Exception {
		// TODO Auto-generated method stub

	}

	

	@Override
	public void rateProduct(Product product, int rating) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void addToFavorite(Product product) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void finishOrder() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isAdmin(String username) {
		// TODO Auto-generated method stub
		// return false;
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("SELECT isAdmin FROM users WHERE username=? ");

			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int isAdmin = rs.getInt("isAdmin");
			if (isAdmin == 1) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

}
