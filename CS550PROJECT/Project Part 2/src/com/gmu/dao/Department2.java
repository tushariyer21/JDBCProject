package com.gmu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.structure.Department;

public class Department2 {
	static DatabaseConnection d = null;
	static Connection con = null;
			
	public Department2() {
		d = new DatabaseConnection();
		con = d.mainDBConn();
	}
	
	public List<Department> list() throws SQLException {
		
		
		List<Department> listDepartment = new ArrayList<>();
		
		try {
	    	System.out.println("Getting all the departments");
	    	String sql = "SELECT * from DEPARTMENT";
	    	PreparedStatement statement = con.prepareStatement(sql);

	        ResultSet result = statement.executeQuery(sql);
	        
	        while (result.next()) {
                int id = result.getInt("dnumber");
                String name = result.getString("dname");
                Department department = new Department(id, name);
                     
                listDepartment.add(department);
            }
	        result.close();
	        statement.close();
	    }catch(Exception e){
	       e.printStackTrace();
	    } finally {
	    	con.close();
	    	if (con.isClosed())
	            System.out.println("Connection is closed");
	        else
	            System.out.println("Connection is open");
	    }
		return listDepartment;
	}
}
