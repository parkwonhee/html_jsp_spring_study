package model;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnection {
	static DataSource dataSource;
	 public static Connection getConnection() throws SQLException, NamingException, ClassNotFoundException{
		 
		 Context context = new InitialContext(); 
		 dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
		/*
		 * Context initCtx = new InitialContext(); 
		 * Context envCtx = (Context)initCtx.lookup("java:comp/env");
		 * DataSource ds = (DataSource)envCtx.lookup("jdbc/orcl");
		 */
	     Connection conn = dataSource.getConnection();
	     return conn;
	    }

}
