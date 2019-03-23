package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Loginse
 */
@WebServlet("/loginse")
public class loginse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginse() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("test/html;charset=UTF-8");

		PrintWriter out = response.getWriter();

		String name = request.getParameter("name"); 
		String id = request.getParameter("id"); 
		String pw = request.getParameter("pw");
				
		out.print("<p>name : "+name+"</p>");
		out.print("<p>id : "+id+"</p>");
		out.print("<p>pw : "+pw+"</p>");
		
		HttpSession session = request.getSession();
		session.setAttribute("memberId", id);
		
		response.sendRedirect("loginOk2.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

}
