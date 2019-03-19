package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HS")  //http://localhost:8080/test0319/HS�� ã�� ������ �̰��� ��Ÿ����!!
//1.���긴���� java annotation�� �̿��Ѵ�.
/*2.web.xml�� �����ϱ�
 *<servlet>
    <servlet-name>hellWorldServlet</servlet-name> <!-- �̸� ���� -->
    <servlet-class>com.java.ex.Helloworld</servlet-class> <!-- Servlet class ���� -->
  </servlet>
  <servlet-mapping>
    <servlet-name>hellWorldServlet</servlet-name>
    <url-pattern>/hw</url-pattern> <!-- http://localhost:80/ex/hw �� ���εȴ�. -> ���ؽ�Ʈ�н�/hw -->
  </servlet-mapping>
 */
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @param <PrintWriter>
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("</head>");
		out.print("<body>");
		out.print("Hello Servlet~java based serverside programe file<br>C:\\Users\\pinka\\eclipse-workspace\\test0319\\src\\com\\servlet<br>Write in here");//
		out.print("</body>");
		out.print("</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
