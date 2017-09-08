package com.mysql.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
		//static reference to itself
		private static MySQLConnection instance = new MySQLConnection();
		public static String URL = "jdbc:mysql://localhost/";
		public static String USER = "";
		public static String PASSWORD = "";
		public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver"; 
		
		//private constructor
		private MySQLConnection() {
			try {
				//Step 2: Load MySQL Java driver
				Class.forName(DRIVER_CLASS);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		public static void set(String library,String user,String password){
			URL += library;
			USER +=user;
			PASSWORD += password;
		}
		
		private Connection createConnection() {

			Connection connection = null;
			try {
				//Step 3: Establish Java MySQL connection
				connection = DriverManager.getConnection(URL, USER, PASSWORD);
				//System.out.println("connectio established");
			} catch (SQLException e) {
				System.out.println("ERROR: Unable to Connect to Database.");
			}
			return connection;
		}	
		
		public static Connection getConnection() {
			return instance.createConnection();
		}
}
