package com.gmu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.structure.DependentStructure;
import com.project.structure.EmployeeStructure;

public class Employee2 {
	static DatabaseConnection d = null;
	static Connection con = null;
	
	public Employee2() {
		d = new DatabaseConnection();
		con = d.mainDBConn();
	}

	public List<EmployeeStructure> list() throws SQLException {
		List<EmployeeStructure> listEmployee = new ArrayList<>();
		
		try {
	    	System.out.println("Getting all employee and department details");
	    	String sql = "select e.fname, e.lname, e.bdate, d.dname, e.ssn from employee e, department d where e.dno = d.dnumber";
	    	
	    	String dependent_sql = "select * from dependent where essn = ?";
	    	PreparedStatement statement = con.prepareStatement(sql);
	    	PreparedStatement dependent_statement = con.prepareStatement(dependent_sql);

	        ResultSet result = statement.executeQuery(sql);
	        
	        while (result.next()) {
	        	System.out.println(result.getString("fname"));
                String ssn = result.getString("ssn");
                String fname = result.getString("fname");
                String lname = result.getString("lname");
                String bdate = result.getString("bdate");
                String dname = result.getString("dname");
    	    	dependent_statement.setString(1, ssn);
    	        ResultSet rs = dependent_statement.executeQuery();
                ArrayList<DependentStructure> list = new ArrayList<DependentStructure>();
    	        while (rs.next()) {
                    String dependent_name = rs.getString("DEPENDENT_NAME");
                    String d_bdate = rs.getString("bdate");
                    String relationship = rs.getString("relationship");
                    String dsex = rs.getString("sex");
                    DependentStructure dependent = new DependentStructure(ssn, dependent_name, dsex, d_bdate, relationship);
                    list.add(dependent);
    	        }
                EmployeeStructure employee = new EmployeeStructure(ssn, fname, lname, bdate, dname, list);

                listEmployee.add(employee);
            }
	        result.close();
	        statement.close();
	    } catch(Exception e){
	       e.printStackTrace();
	    } finally {
	    	con.close();
	    	if (con.isClosed())
	            System.out.println("Connection is closed");
	        else
	            System.out.println("Connection is open");
	    }
		for (int i = 0; i < listEmployee.size(); i++) {
            System.out.println(listEmployee.get(i));
        }

		return listEmployee;
	}
	
	
	public EmployeeStructure getEmployee(String ssn) throws SQLException{
		EmployeeStructure employee = null;
		
		try {
	    	System.out.println("Getting employee and department details");
	    	String sql = "select e.fname, e.lname, e.bdate, d.dname, e.ssn from employee e, department d where e.dno = d.dnumber and ssn = ?";
	    	
	    	String dependent_sql = "select * from dependent where essn = ?";
	    	PreparedStatement statement = con.prepareStatement(sql);
	    	PreparedStatement dependent_statement = con.prepareStatement(dependent_sql);
	    	statement.setString(1, ssn);
	        ResultSet result = statement.executeQuery();
	        
	        while (result.next()) {
                String fname = result.getString("fname");
                String lname = result.getString("lname");
                String bdate = result.getString("bdate");
                String dname = result.getString("dname");
    	    	dependent_statement.setString(1, ssn);
    	        ResultSet rs = dependent_statement.executeQuery();
                ArrayList<DependentStructure> list = new ArrayList<DependentStructure>();
    	        while (rs.next()) {
                    String dependent_name = rs.getString("DEPENDENT_NAME");
                    String d_bdate = rs.getString("bdate");
                    String relationship = rs.getString("relationship");
                    String dsex = rs.getString("sex");
                    DependentStructure dependent = new DependentStructure(ssn, dependent_name, dsex, d_bdate, relationship);
                    list.add(dependent);
    	        }
                employee = new EmployeeStructure(ssn, fname, lname, bdate, dname, list);
                rs.close();
            }
	        result.close();
	        statement.close();
	        dependent_statement.close();
	    } catch(Exception e){
	       e.printStackTrace();
	    } finally {
	    	con.close();
	    	if (con.isClosed())
	            System.out.println("Connection is closed");
	        else
	            System.out.println("Connection is open");
	    }

		
		return employee;
	}
}
