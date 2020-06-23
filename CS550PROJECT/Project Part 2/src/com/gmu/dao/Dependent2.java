package com.gmu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.structure.DependentStructure;

public class Dependent2 {
	private static String SSN = null;
	static DatabaseConnection d = null;
	static Connection con = null;
			
	
	public Dependent2(String ssn) {
		// TODO Auto-generated constructor stub
		SSN = ssn;
		d = new DatabaseConnection();
		con = d.mainDBConn();
	}
	
	public List<DependentStructure> list() throws SQLException {
		
		List<DependentStructure> listDependent = new ArrayList<>();
		
		try {
	    	System.out.println("Getting all Dependents");
	    	
	    	String sql = "SELECT * from Dependent where ESSN = " + SSN;
	    	PreparedStatement statement = con.prepareStatement(sql);
//	    	statement.setString(1, SSN);
	    	System.out.println(sql);
	        ResultSet result = statement.executeQuery(sql);
	        
	        while (result.next()) {
	        	String dependent_name = result.getString("DEPENDENT_NAME");
                String d_bdate = result.getString("bdate");
                String relationship = result.getString("relationship");
                String dsex = result.getString("sex");
                DependentStructure Dependent = new DependentStructure(SSN, dsex, dependent_name, d_bdate, relationship);
                     
                listDependent.add(Dependent);
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
	            System.out.println("Connection is Open");
	    }
		return listDependent;
	}

}
