package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DTO.userBean;

public class userDao {
	private static userDao instance;
    private userDao(){}
    
    /*private static class LazyHolder {
        public static final userDao INSTANCE = new userDao();
    }
 
    public static userDao getInstance() {
        return LazyHolder.INSTANCE;
    }*/

    //�̱��� ���� Thread safe Lazy initialization (������ �ʱ�ȭ)
    public static synchronized userDao getInstance(){
        if(instance == null ) instance = new userDao();
        return instance;
    }
    
    
   
    // ȸ������ �޼���
    public void joinUser(userBean bean){
    	String driver = "oracle.jdbc.driver.OracleDriver";
    	String url = "jdbc:oracle:thin:@localhost:1521:xe";
    	String id = "scott";
    	String pw = "tiger";
    	 try {
    			Class.forName(driver);
    		} catch (Exception e) {
    			e.printStackTrace();		
    		}
        Connection conn = null;
        PreparedStatement pstm = null;
 
        try {
            // ����
        	System.out.println("test7");
        	conn=DriverManager.getConnection(url,id,pw);
            StringBuffer query = new StringBuffer();
            query.append("INSERT INTO b_user VALUES(?,?,?,?,?)");
            // Ŀ�ؼ� ����
            //conn = DBConnection.getConnection();
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
                if (pstm != null) {
                    pstm.close();
                    pstm = null;
                }
                if (conn != null) {
                    conn.close();
                    conn = null;
                }
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    } // end joinUser()

}
