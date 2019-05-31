package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DTO.UserDTO;

public class UserDAO {
//	private static userDao instance;
//    private UserDAO(){}
    
    /*private static class LazyHolder {
        public static final UserDAO INSTANCE = new userDao();
    }
 
    public static UserDAO getInstance() {
        return LazyHolder.INSTANCE;
    }*/

    //�̱��� ���� Thread safe Lazy initialization (������ �ʱ�ȭ)
//    public static synchronized UserDAO getInstance(){
//        if(instance == null ) instance = new UserDAO();
//        return instance;
//    }
    
    private static UserDAO instance = new UserDAO();
	private UserDAO(){}
	public static UserDAO getInstance(){
		return instance;
	}

    // ȸ������ �޼���
    public void joinUser(UserDTO bean){
    	String driver = "oracle.jdbc.driver.OracleDriver";
    	String url = "jdbc:oracle:thin:@localhost:1521:xe";
    	String id = "scott";
    	String pw = "tiger";

        Connection conn = null;
        PreparedStatement pstm = null;
      
        try {
        	// JDBC Driver �ε�
        	Class.forName(driver);
            // ����Connection ��ü ���� / DB ����(����)
        	System.out.println("test7");
            StringBuffer query = new StringBuffer();
            query.append("INSERT INTO b_user VALUES(?,?,?,?,?)");
            // Ŀ�ؼ� ����
            //conn = DBConnection.getConnection();
            conn=DriverManager.getConnection(url,id,pw);
            // ��������
            pstm = conn.prepareStatement(query.toString());
            
            // MemberBean�� ��� ���� ������ �������� �����Ѵ�.
            pstm.setString(1, bean.getUid());
            pstm.setString(2, bean.getPw());
            pstm.setString(3, bean.getName());
            pstm.setString(4, bean.getEmail());
            pstm.setString(5, bean.getBirth());

            // run
            pstm.executeUpdate();
            // �Ϸ�� Ŀ��
            conn.commit();  
        } catch (Exception ex) {
            try {
                conn.rollback(); // ������ �ѹ�
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throw new RuntimeException(ex.getMessage());
        } finally {
            try {
                if (pstm != null) pstm.close();
                if (conn != null) conn.close();  
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    } // end joinUser()

    
}
