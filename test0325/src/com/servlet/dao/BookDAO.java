package com.servlet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.servlet.dto.BookDTO;//import«ÿ¡‡æﬂ «—¥Ÿ!!!!

public class BookDAO{
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "scott";
	String pw = "tiger";
	
	public BookDAO() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();		
		}
	}
	
	public ArrayList<BookDAO> select(){
		ArrayList<BookDAO> list = new ArrayList<BookDAO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
		try {
			con=DriverManager.getConnection(url,id,pw);
			String sql = "select * from book";
			pstmt = con.prepareStatement(sql);
			res = pstmt.executeQuery();
			
			while(res.next()) {
				int bookid = res.getInt("book_id");
				String bookname = res.getString("book_name");
				String bookloc = res.getString("book_loc");
				
				BookDTO bookdto = new BookDTO(bookid, bookname, bookloc); 
				list.add(bookdto);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(res != null) res.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
}