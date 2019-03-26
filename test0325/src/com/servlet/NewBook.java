package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewBook
 */
@WebServlet("/newBook")
public class NewBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub\
		//jdbc �������
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String bookid = request.getParameter("book_id");
		String bookName = request.getParameter("book_name");
		String bookLoc = request.getParameter("book_loc");
		
		String driver = "oracle.jdbc.driver.OracleDriver";//OracleDriver �ε�
		String url = "jdbc:oracle:thin:@localhost:1521:xe";//�����ǹ��� ip�� �ȴ�.
		String id = "scott";//���̵� ��й�ȣ
		String pw = "tiger";
		
		Connection con = null;
		Statement stmt = null;
		
		try {//db�� trycatch���� ����
			Class.forName(driver);
			
			con = DriverManager.getConnection(url, id, pw);//Java�� Oracle ����
			stmt = con.createStatement();//query ���۰�ü, ���
			String sql = "INSERT INTO book(book_id, book_name, book_loc)";//query �ۼ�
					sql += " VALUES ('" + bookid + "', '" + bookName + "', '" + bookLoc + "')";
			int result = stmt.executeUpdate(sql);//query ����-�����Ҷ� !!!
			
			if(result == 1) {
				out.print("INSERT success!!");
			} else {//0�̸� ��͵� �ݿ����� �ʾҴٶ�� �ǹ�
				out.print("INSERT fail!!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
