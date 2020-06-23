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
import com.gmu.dao.Project2;
import com.project.structure.ProjectsModel;

/**
 * Servlet implementation class ProjectsModel
 */
@WebServlet(description = "get all projects of an employee", urlPatterns = { "/Projects" })
public class Projects extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Projects() {
        super();

        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DatabaseConnection d = null;
		Connection con1 = null;
        d = new DatabaseConnection();
		con1 = d.mainDBConn();
		
		System.out.println("Inside Get Request");
		Project2 pdao = new Project2(request.getParameter("ssn"));
		List<ProjectsModel> listProjects = null;
        
		HttpSession session = request.getSession(false);
        if (session != null) {
            // a session exists
        	String ssn = (String) session.getAttribute("userssn");
        	if (ssn != null) {
        		try {
        			listProjects = pdao.projects();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new ServletException(e);
                }
        		System.out.println(listProjects.size());
        		request.setAttribute("listProjects", listProjects);
        		String sql = "SELECT sum(hours) as total_hours from works_on where essn = " + request.getParameter("ssn");
    	    	System.out.println(sql);
				int count = 0;
				try {
					PreparedStatement statement = con1.prepareStatement(sql);
					ResultSet result = statement.executeQuery(sql);
					while(result.next()) {
						count += result.getInt("total_hours"); 
					}
					
					request.setAttribute("totalHours", count);
	        		RequestDispatcher dispatcher = request.getRequestDispatcher("/addProject.jsp");
	                dispatcher.forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
			    	try {
						con1.close();
					} catch (SQLException e) {
						 System.out.println("Connection is open");
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			           
			    }
				
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
