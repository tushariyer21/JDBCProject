package com.project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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
import com.gmu.dao.Employee2;
import com.project.structure.EmployeeStructure;

/**
 * Servlet implementation class employee
 */
@WebServlet(description = "add or get all employees", urlPatterns = { "/employee" })
public class employee extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public employee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee2 edao = new Employee2();
		System.out.println("inside the get request");
		List<EmployeeStructure> listEmployee = null;
		
        HttpSession session = request.getSession(false);
        if (session != null) {
            // a session exists
        	String ssn = (String) session.getAttribute("userssn");
        	if (ssn != null) {
        		try {
                    listEmployee = edao.list();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new ServletException(e);
                }
        		System.out.println(listEmployee.size());
        		request.setAttribute("listEmployee", listEmployee);
        		
        		RequestDispatcher dispatcher = request.getRequestDispatcher("employee.jsp");
                dispatcher.forward(request, response);
        	}
             
        } else {
            // no session
        	RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
            dispatcher.forward(request, response);
        }
		
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DatabaseConnection d = new DatabaseConnection();
		Connection con = d.mainDBConn();
	       
		String fname = request.getParameter("fname");
    	String minit = request.getParameter("minit");
    	String lname = request.getParameter("lname");
    	String ssn = request.getParameter("ssn");
    	String bdate = request.getParameter("bdate");
    	String address = request.getParameter("address");
    	String sex = request.getParameter("sex");
    	int salary = Integer.parseInt(request.getParameter("salary"));
    	String mgrssn = request.getParameter("mgrssn");
    	int dno = Integer.parseInt(request.getParameter("dno"));
    	String email = request.getParameter("email");
    	String dname = request.getParameter("dependent_name");
    	String dbdate = request.getParameter("d_bdate");
    	String dsex = request.getParameter("d_sex");
    	String relationship = request.getParameter("relationship");
    	boolean checkbox = request.getParameter("dependent_present") != null;
    	System.out.println(fname+minit);
    	
    	try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO EMPLOYEE VALUES (?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, fname);
			ps.setString(2, minit);
			ps.setString(3, lname);
			ps.setString(4, ssn);
			ps.setDate(5, Date.valueOf(bdate));
			ps.setString(6, address);
			ps.setString(7, sex);
			ps.setInt(8, salary);
			ps.setString(9, mgrssn);
			ps.setInt(10, dno);
			ps.setString(11, email);
			
			int result = ps.executeUpdate();
			if(result==0) {
				System.out.println("Could Not add employee. Please try again.");
			}else {
				if (checkbox) {
					System.out.println("inserting dependent");
					ps = con.prepareStatement("INSERT INTO dependent VALUES (?,?,?,?,?)");
					ps.setString(1, ssn);
					ps.setString(2, dname);
					ps.setString(3, dsex);
					ps.setDate(4, Date.valueOf(dbdate));
					ps.setString(5, relationship);
					
					int dependent_result = ps.executeUpdate();
					if(dependent_result==0) {
						System.out.println("Could Not add employee. Please try again.");
					}
				}
				ps.close();
				doGet(request, response);
				RequestDispatcher dispatcher = request.getRequestDispatcher("employee.jsp");
				dispatcher.forward(request, response);
			}
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	    	try {
				con.close();
			} catch (SQLException e) {
				 System.out.println("connection exists");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	           
	    }
	}

}
