package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ss")
public class searchservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public searchservlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url= "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "scott";
		String pw = "tiger";
		
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,id,pw);
			stmt = con.createStatement();
			String sql = "SELECT * FROM book";
			res=stmt.executeQuery(sql);
			
			while(res.next()) {
				int bookid = res.getInt("book_id");
				String bookname = res.getString("book_name");
				String bookloc = res.getString("book_loc");
				
				out.println("bookId : "+ bookid + " , ");
				out.println("bookName : "+ bookname + " , ");
				out.println("bookLoc : "+ bookloc + " , <br> ");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(res!= null)res.close();
				if(stmt!=null)stmt.close();
				if(con!=null)con.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();			
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
