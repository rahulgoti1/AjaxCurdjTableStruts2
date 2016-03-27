package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataAccessObject {
	private static Connection connection = null;

	public static Connection getConnection() {
		if (connection != null)
			return connection;
		else {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/struts_curd", "root", "");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return connection;
		}
	}
}