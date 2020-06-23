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
import com.gmu.dao.Dependent2;
import com.project.structure.DependentStructure;

/**
 * Servlet implementation class Dependent
 */
@WebServlet("/Dependent")
public class Dependent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dependent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside get request");
		Dependent2 ddao = new Dependent2(request.getParameter("ssn"));
		List<DependentStructure> listDependent = null;
        
		HttpSession session = request.getSession(false);
        if (session != null) {
            // a session exists
        	String ssn = (String) session.getAttribute("userssn");
        	if (ssn != null) {
        		try {
        			listDependent = ddao.list();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new ServletException(e);
                }
        		System.out.println(listDependent.size());
        		request.setAttribute("listDependent", listDependent);
        		
        		RequestDispatcher dispatcher = request.getRequestDispatcher("/dependent.jsp");
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
	       
    	String dname = request.getParameter("dependent_name");
    	String dbdate = request.getParameter("d_bdate");
    	String dsex = request.getParameter("d_sex");
    	String relationship = request.getParameter("relationship");
		String ssn = request.getParameter("ssn");
		
    	
    	try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO dependent VALUES (?,?,?,?,?)");
			ps.setString(1, ssn);
			ps.setString(2, dname);
			ps.setString(3, dsex);
			ps.setDate(4, Date.valueOf(dbdate));
			ps.setString(5, relationship);
			
			int result = ps.executeUpdate();
			if(result==0) {
				System.out.println("Could Not add dependent. Please try again.");
			}else {
				doGet(request, response);
			}
			ps.close();
			
    		RequestDispatcher dispatcher = request.getRequestDispatcher("/dependent.jsp");
            dispatcher.forward(request, response);
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
