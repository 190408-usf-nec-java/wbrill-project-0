package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class: DriverManager -> Older way of getting a Connection object to the database
 * Class: DataSource -> Newer way of getting a Connection object to the database
 * Interface: Connection -> Represents an open connection to the database
 *
 */
public class ConnectionUtil {
	
	public static Connection getConnection() throws SQLException {
		// JDBC has it's own URL syntax that we will need to use
		// jdbc:postgresql://localhost:5432/postgres

		/*
		 * Why should we use environment variables for these details?
		 * 
		 * Code is shared with many people and is pushed to a repository,
		 * and these connection details could be accessed and abused
		 * if they are pushed into any kind of public space. By using
		 * environment variables, these values stay private even if the
		 * code becomes public, preventing our credentials from becoming
		 * public which would violate the security of our database.
		 */
		
		String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "wbrill23";
        String password = "p4ssw0rd";
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
	}
}
