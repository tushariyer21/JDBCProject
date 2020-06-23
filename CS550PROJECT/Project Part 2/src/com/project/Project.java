package com.project;

import java.io.IOException;
import java.sql.Connection;
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
import com.gmu.dao.Project2;
import com.project.structure.ProjectStructure;

/**
 * Servlet implementation class Project
 */
@WebServlet("/Project")
public class Project extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Project() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Get Request");
		Project2 pdao = new Project2(request.getParameter("ssn"));
		List<ProjectStructure> listProjects = null;
        
		HttpSession session = request.getSession(false);
        if (session != null) {
            // a session exists
        	String ssn = (String) session.getAttribute("userssn");
        	if (ssn != null) {
        		try {
        			listProjects = pdao.list();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new ServletException(e);
                }
        		System.out.println(listProjects.size());
        		request.setAttribute("listProjects", listProjects);
        		
        		RequestDispatcher dispatcher = request.getRequestDispatcher("/project.jsp");
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
	       
		int pnumber = Integer.parseInt(request.getParameter("pnumber"));
		int hours = Integer.parseInt(request.getParameter("hours"));
		String ssn = request.getParameter("ssn");
		System.out.println(ssn);
		System.out.println(hours);
		System.out.println(pnumber);
    	
    	try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO works_on VALUES (?,?,?)");
			ps.setString(1, ssn);
			ps.setInt(2, pnumber);
			ps.setInt(3, hours);
			
			int result = ps.executeUpdate();
			if(result==0) {
				System.out.println("Could Not add employee. Please try again.");
			}else {
				doGet(request, response);
			}
			ps.close();
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
