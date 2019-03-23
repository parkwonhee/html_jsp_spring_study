package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginCon
 */
@WebServlet("/loginCon")
public class loginCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginCon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String id = request.getParameter("id"); 
		String pw = request.getParameter("pw");
				
		PrintWriter out = response.getWriter();
		out.print("<p>id : "+id+"</p>");
		out.print("<p>pw : "+pw+"</p>");
		
		Cookie[] cookies = request.getCookies();
		Cookie cookie = null;
		//cookies를 조회
		for (Cookie c : cookies) {
			System.out.println ( "c.getName() : " + c.getName() + ", c.getValue() : " + c.getValue());
			
			if(c.getName().equals("memberId")) { 
				cookie = c; 
			}
		}
		if(cookie == null) { 
			System. out .println ( "cookie is null" ); 
			cookie = new Cookie("memberId", id); 
		}
		response.addCookie(cookie); 
		cookie.setMaxAge(60*60);//1시간의 완료 기간이다.
		
		response.sendRedirect("loginOk.jsp");

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
