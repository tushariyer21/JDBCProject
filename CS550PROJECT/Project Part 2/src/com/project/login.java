package com.project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gmu.dao.DatabaseConnection;
import com.gmu.dao.Department2;
import com.gmu.dao.Manager2;
import com.project.structure.Department;
import com.project.structure.ManagerStructure;

/**
 * Servlet implementation class login
 */
@WebServlet(description = "login servelet for manager", urlPatterns = { "/login" })
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DatabaseConnection d = new DatabaseConnection();
		Connection con1 = d.mainDBConn();
		
		System.out.println("inside the post request");
		Department2 ddao = new Department2();
		Manager2 mdao = new Manager2();
		
		List<Department> listDepartment = null;
		List<ManagerStructure> listManager = null;
		
		// TODO Auto-generated method stub
		doGet(request, response);
		String ssn = request.getParameter("SSN");
		try {
	    	System.out.println("Checking if the given SSN is a manager");
	    	PreparedStatement ps = con1.prepareStatement("SELECT * from DEPARTMENT WHERE MGRSSN= ?");
	        ps.setString(1, ssn);
	        ResultSet rs = ps.executeQuery();
	        
	        if (rs.next() != true) {
				response.getWriter().write("Invalid SSN, Not a manager");
				System.out.println("Invalid SSN, Not a manager");
				rs.close();
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("userssn", ssn);
				try {
		            listDepartment = ddao.list();
		            listManager = mdao.list();
		        } catch (SQLException e) {
		            e.printStackTrace();
		            throw new ServletException(e);
		        }
				
	            request.setAttribute("listDepartment", listDepartment);
	            request.setAttribute("listManager", listManager);
	            ps.close();
				RequestDispatcher dispatcher = request.getRequestDispatcher("addEmployee.jsp");
	            dispatcher.forward(request, response);
			}
	        ps.close();
	        rs.close();
	    }catch(Exception e){
	       e.printStackTrace();
	    } finally {
	    	try {
				con1.close();
			} catch (SQLException e) {
				 System.out.println("connection exists");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	           
	    }
		
	}

}
