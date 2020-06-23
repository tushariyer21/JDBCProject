package com.gmu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.structure.ManagerStructure;

public class Manager2 {
	static DatabaseConnection d = null;
	static Connection con = null;
	
	
	public Manager2() {
		d = new DatabaseConnection();
		con = d.mainDBConn();
	}
	
	public List<ManagerStructure> list() throws SQLException {
		List<ManagerStructure> listManager = new ArrayList<>();
		
		try {
	    	System.out.println("Getting all Managers");
	    	String sql = "SELECT mgrssn, fname, lname from employee, department where employee.ssn = department.mgrssn";
	    	PreparedStatement statement = con.prepareStatement(sql);

	        ResultSet result = statement.executeQuery(sql);
	        
	        while (result.next()) {
                int ssn = result.getInt("mgrssn");
                String fname = result.getString("fname");
                String lname = result.getString("lname");
                ManagerStructure manager = new ManagerStructure(ssn, fname, lname);
                     
                listManager.add(manager);
            }
	        result.close();
	        statement.close();
	    } catch(Exception e){
	       e.printStackTrace();
	    } finally {
	    	con.close();
	    	if (con.isClosed())
	            System.out.println("no connection any more");
	        else
	            System.out.println("connection exists");
	    }
		return listManager;
	}

}
