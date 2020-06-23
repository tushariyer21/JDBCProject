package com.gmu.dao;

import java.sql.Connection;
import java.sql.ResultSet;

public class EmployeeDetails {

		// TODO Auto-generated constructor stub
	static DatabaseConnection d = null;
	static Connection con = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		d = new DatabaseConnection();
		con = (Connection) d.mainDBConn();
		
		GetDepartEmployee();
		GetEmployee();
	}
	
	public static void GetDepartEmployee() {
	    try {
	    	System.out.println("List of employees with the department Research");
	    	java.sql.PreparedStatement ps = con.prepareStatement("select Lname,Ssn from EMPLOYEE,DEPARTMENT where Dno = Dnumber and Dname = ?");
	        ps.setString(1, "Research");
	        ResultSet rs = ps.executeQuery();
	        
	        while(rs.next()){
	            String lname=rs.getString("Lname");
	            String ssn=rs.getString("Ssn");
	            System.out.println(lname +" " + ssn);
	            System.out.println("\n");
	        }
	        rs.close();
	        ps.close();
	    }catch(Exception e){
	       e.printStackTrace();
	    }
	}
	
	public static void GetEmployee() {
		try {
			System.out.println("List ofemployee  who work in the department located in Houston on the project 'ProductZ'");
	    	java.sql.PreparedStatement ps = con.prepareStatement("select Lname,Ssn,Hours from EMPLOYEE,DEPT_LOCATIONS,PROJECT,WORKS_ON where Dno = Dnumber and Dnumber = Dnum and Pnumber = Pno and Dlocation = ? and Pname = ?");
	    	ps.setString(1, "Houston");
	        ps.setString(2, "ProductZ");
	        ResultSet rs = ps.executeQuery();
	        
	        while(rs.next()){
	            String lname=rs.getString("Lname");
	            String ssn=rs.getString("Ssn");
	            float hours=rs.getFloat("Hours");
	            
	            System.out.println(lname +" " + ssn+" "+hours);
	            System.out.println("\n");
	        }
	        rs.close();
	        ps.close();
	    }catch(Exception e){
	       e.printStackTrace();
	    }
	}
}
