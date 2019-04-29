package com.revature.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import com.revature.beans.User;
import com.revature.daos.UserDao;
import com.revature.util.ConnectionUtil;
import com.revature.util.ScannerUtil;

public class UserService {
	
	public UserDao userDao=new UserDao();
	
	public void setDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	/**
	 * Handles creation workflow for User bean
	 */
	public void createUserAccount() {
		System.out.println("Please enter your first name: ");
		String firstName = ScannerUtil.getLine();

		System.out.println("Please enter your last name: ");
		String lastName = ScannerUtil.getLine();

		System.out.println("Please enter your email address: ");
		String email = ScannerUtil.getLine();
		
		System.out.println("Please enter your password: ");
		String password = ScannerUtil.getLine();

		User user = new User(0, firstName, lastName, email, password);

		userDao.safeSaveUser(user);
		System.out.println(user);
	
	}
	
	public void userLogin() {
		Set<String> email = new HashSet<>();
		Set<String> passwords = new HashSet<>();
		boolean emailExists = false;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "select email, password from users";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				email.add(rs.getString(1));
				passwords.add(rs.getString(2));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		int i = 0;
		
		while(!emailExists) {
			
			if (i == 3) {
				System.out.println();
				System.out.println("Your account has been locked.");
				System.out.println("Please call RBS™, or try again tomorrow.");
				return;
			}
			System.out.println("==============================================================================================================================");
			System.out.println("LOGIN");
			System.out.println();
			System.out.println("Please enter your username:");
			String emails = ScannerUtil.getLine();
			System.out.println("Please enter your password:");
			String password = ScannerUtil.getLine();
			
			if (email.contains(emails) && passwords.contains(password)) {
				System.out.println("LOGIN SUCCESSFUL!");
				System.out.println();
				emailExists = true;
			}
			
			else {
				i++;
				System.out.println("LOGIN CREDENTIALS INVALID!");
				System.out.println();
				System.out.println("Please enter valid credentials. You have used " + i + " of 3 attempts.");
			}
		}
	}
}
