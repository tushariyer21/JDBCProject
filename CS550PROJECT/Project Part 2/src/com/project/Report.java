package com.project;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gmu.dao.Employee2;
import com.gmu.dao.Project2;
import com.project.structure.EmployeeStructure;
import com.project.structure.ProjectStructure;

/**
 * Servlet implementation class Report
 */
@WebServlet("/Report")
public class Report extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Report() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee2 edao = new Employee2();
		System.out.println("Get Request");
		EmployeeStructure employee = null;
		String ssn = request.getParameter("ssn");
		Project2 pdao = new Project2(ssn);
		List<ProjectStructure> listProjects = null;
		
		
        HttpSession session = request.getSession(false);
        if (session != null) {
            // a session exists
        	if (ssn != null) {
        		try {
                    employee = edao.getEmployee(ssn);
                    listProjects = pdao.list();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new ServletException(e);
                }
        		request.setAttribute("employeeDetails", employee);
        		System.out.println(listProjects.size());
        		request.setAttribute("listProjects", listProjects);
        		
        		RequestDispatcher dispatcher = request.getRequestDispatcher("report.jsp");
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
