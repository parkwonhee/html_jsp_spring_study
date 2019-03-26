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
		//jdbc 실행순서
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String bookid = request.getParameter("book_id");
		String bookName = request.getParameter("book_name");
		String bookLoc = request.getParameter("book_loc");
		
		String driver = "oracle.jdbc.driver.OracleDriver";//OracleDriver 로딩
		String url = "jdbc:oracle:thin:@localhost:1521:xe";//실제실무는 ip가 된다.
		String id = "scott";//아이디 비밀번호
		String pw = "tiger";
		
		Connection con = null;
		Statement stmt = null;
		
		try {//db는 trycatch문이 좋다
			Class.forName(driver);
			
			con = DriverManager.getConnection(url, id, pw);//Java와 Oracle 연결
			stmt = con.createStatement();//query 전송객체, 통신
			String sql = "INSERT INTO book(book_id, book_name, book_loc)";//query 작성
					sql += " VALUES ('" + bookid + "', '" + bookName + "', '" + bookLoc + "')";
			int result = stmt.executeUpdate(sql);//query 전송-수정할때 !!!
			
			if(result == 1) {
				out.print("INSERT success!!");
			} else {//0이면 어떤것도 반영되지 않았다라는 의미
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
