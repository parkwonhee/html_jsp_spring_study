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

    //싱글톤 패턴 Thread safe Lazy initialization (게으른 초기화)
    public static synchronized userDao getInstance(){
        if(instance == null ) instance = new userDao();
        return instance;
    }
    
    
   
    // 회원가입 메서드
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
            // 쿼리
        	System.out.println("test7");
        	conn=DriverManager.getConnection(url,id,pw);
            StringBuffer query = new StringBuffer();
            query.append("INSERT INTO b_user VALUES(?,?,?,?,?)");
            // 커넥션 연결
            //conn = DBConnection.getConnection();
            // 쿼리생성
            pstm = conn.prepareStatement(query.toString());
            
            // MemberBean에 담긴 값을 가져와 쿼리문에 세팅한다.
            pstm.setString(1, bean.getUid());
            pstm.setString(2, bean.getPw());
            pstm.setString(3, bean.getName());
            pstm.setString(4, bean.getEmail());
            pstm.setString(5, bean.getBirth());

            // run
            pstm.executeUpdate();
            // 완료시 커밋
            conn.commit();  
        } catch (Exception ex) {
            try {
                conn.rollback(); // 오류시 롤백
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
