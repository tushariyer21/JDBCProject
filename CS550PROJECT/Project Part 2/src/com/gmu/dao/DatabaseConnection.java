package com.gmu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
    public Connection mainDBConn() {
    	Connection conn = null;
    	
    	String dbURL = "jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu";
		String username = "tiyer";
		String password = "shomsoal";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(dbURL, username, password);
			System.out.println("Connected to Oracle JDBC ");
			return conn;
		} catch(SQLException | ClassNotFoundException e){
			System.out.println("Oops, error:");
			e.printStackTrace();
		}

		return conn;
	}

	public static void main(String[] args) {
    
	}

}
