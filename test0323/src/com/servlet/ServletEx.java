package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletEX
 */
public class ServletEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEx() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//  servlet데이터 공유 방법 3가지 servlet parameter
		String adminId = getServletConfig().getInitParameter("adminId");
		String adminPw = getServletConfig().getInitParameter("adminPw");
		
		PrintWriter out = response.getWriter();
		out.print("<p>adminId : "+adminId+"</p>");
		out.print("<p>adminPw : "+adminPw+"</p>");
		
		// context parameter
		String imgDir = getServletContext().getInitParameter("imgDir"); 
		String testServerIP = getServletContext().getInitParameter("testServerIP");
		
		out.print("<p>imgDir : "+imgDir+"</p>");
		out.print("<p>testServerIP : "+testServerIP+"</p>");
		//context attribute
		getServletContext().setAttribute("connectedIP", "165.62.58.23"); 
		getServletContext().setAttribute("connectedUser", "hong");
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
