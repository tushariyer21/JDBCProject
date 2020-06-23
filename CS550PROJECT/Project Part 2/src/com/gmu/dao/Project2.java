package com.gmu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.structure.ProjectStructure;
import com.project.structure.ProjectsModel;

public class Project2 {
	private static String SSN = null;
	static DatabaseConnection d = null;
	static Connection con = null;
	
	public Project2(String ssn) {
		SSN = ssn;
		d = new DatabaseConnection();
		con = d.mainDBConn();
	}
	
	public List<ProjectStructure> list() throws SQLException {
		
		List<ProjectStructure> listDependent = new ArrayList<>();
		
		try {
	    	System.out.println("Getting all Dependents");
	    	
	    	String sql1 = "SELECT p.*, w.hours, d.dname from project p, works_on w, employee e, department d where p.pnumber = w.pno and w.essn = e.ssn and p.dnum = d.dnumber and e.ssn = " + SSN;
	    	PreparedStatement statement1 = con.prepareStatement(sql1);
//	    	statement.setString(1, SSN);
	    	System.out.println(sql1);
	        ResultSet result = statement1.executeQuery(sql1);
	        
	        while (result.next()) {
	        	String pname = result.getString("pname");
                String plocation = result.getString("plocation");
                int hours = result.getInt("hours");
                int pnumber = result.getInt("pnumber");
                int dnum = result.getInt("dnum");
                String dname = result.getString("dname");
                ProjectStructure Dependent = new ProjectStructure(dnum, plocation, pname, pnumber, hours, dname);
                     
                listDependent.add(Dependent);
            }
	        result.close();
	        statement1.close();
	    }catch(Exception e){
	       e.printStackTrace();
	    } finally {
	    	con.close();
	    	if (con.isClosed())
	            System.out.println("no connection any more");
	        else
	            System.out.println("connection exists");
	    }
		return listDependent;
	}
	
	public List<ProjectsModel> projects() throws SQLException {
		
		List<ProjectsModel> listProjects = new ArrayList<>();
		
		try {
	    	System.out.println("Getting all new Projects");
	    	int count = 0;
	    	int dno = 0;
	    	
	    	String sql = "SELECT e.fname, e.lname, e.ssn, p.*, d.dname from project p, employee e, department d where p.pnumber not in (select pno from works_on where essn = "+ SSN +") and e.ssn = " + SSN + "and e.dno = d.dnumber";
	    	PreparedStatement statement = con.prepareStatement(sql);
	    	ResultSet result = statement.executeQuery(sql);
	    	
	    	String employeeProjectSql = "SELECT count(p.pnumber) as p_count from project p, works_on w, employee e where p.dnum = e.dno and w.pno = p.pnumber and e.ssn = w.essn and w.essn = " + SSN ;
	    	PreparedStatement empProjStatement = con.prepareStatement(employeeProjectSql);
	    	ResultSet empProjectResult = empProjStatement.executeQuery(employeeProjectSql);
	    	
	    	String getDnumberSql = "SELECT dno from employee where ssn =" + SSN;
	    	PreparedStatement dnoStatement = con.prepareStatement(getDnumberSql);
	    	ResultSet getDnumberResult = dnoStatement.executeQuery(getDnumberSql);
	    	
	    	
	    	System.out.println(sql);
	    	
	        
	        
	        
	        while (empProjectResult.next()) {
	        	count = empProjectResult.getInt("p_count");
	        }
	        
	        while (getDnumberResult.next()) {
	        	dno = getDnumberResult.getInt("dno");
	        }
	        
	        if(count == 0) {
	        	while (result.next()) {
		        	String pname = result.getString("pname");
	                String plocation = result.getString("plocation");
	                int pnumber = result.getInt("pnumber");
	                int dnum = result.getInt("dnum");
	                String dname = result.getString("dname");
	                String fname = result.getString("fname");
	                String lname = result.getString("lname");
	                ProjectsModel project = new ProjectsModel(dnum, plocation, pname, pnumber, dname, fname, lname);
	                
//	                An employee must work on at least one project controlled by his/her department.
	                if(dno == dnum) {
	                	listProjects.add(project);
	                }
	            }
	        } else if(count == 2) {
	        	while (result.next()) {
		        	String pname = result.getString("pname");
	                String plocation = result.getString("plocation");
	                int pnumber = result.getInt("pnumber");
	                int dnum = result.getInt("dnum");
	                String dname = result.getString("dname");
	                String fname = result.getString("fname");
	                String lname = result.getString("lname");
	                ProjectsModel project = new ProjectsModel(dnum, plocation, pname, pnumber, dname, fname, lname);
	                
//	                An employee may not work on more than two projects managed by his/her department.
	                if(dno != dnum) {
	                	listProjects.add(project);
	                }
	            }  
	        } else {
	        	while (result.next()) {
		        	String pname = result.getString("pname");
	                String plocation = result.getString("plocation");
	                int pnumber = result.getInt("pnumber");
	                int dnum = result.getInt("dnum");
	                String dname = result.getString("dname");
	                String fname = result.getString("fname");
	                String lname = result.getString("lname");
	                ProjectsModel project = new ProjectsModel(dnum, plocation, pname, pnumber, dname, fname, lname);
	                
	                listProjects.add(project);
	        	}
	        }
	        result.close();
	        statement.close();
	        empProjectResult.close();
	        empProjStatement.close();
	        getDnumberResult.close();
	        dnoStatement.close();
	    }catch(Exception e){
	       e.printStackTrace();
	    } finally {
	    	con.close();
	    	if (con.isClosed())
	            System.out.println("no connection any more");
	        else
	            System.out.println("connection exists");
	    }
		return listProjects;
	}
}
