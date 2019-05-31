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

    //싱글톤 패턴 Thread safe Lazy initialization (게으른 초기화)
//    public static synchronized UserDAO getInstance(){
//        if(instance == null ) instance = new UserDAO();
//        return instance;
//    }
    
    private static UserDAO instance = new UserDAO();
	private UserDAO(){}
	public static UserDAO getInstance(){
		return instance;
	}

    // 회원가입 메서드
    public void joinUser(UserDTO bean){
    	String driver = "oracle.jdbc.driver.OracleDriver";
    	String url = "jdbc:oracle:thin:@localhost:1521:xe";
    	String id = "scott";
    	String pw = "tiger";

        Connection conn = null;
        PreparedStatement pstm = null;
      
        try {
        	// JDBC Driver 로딩
        	Class.forName(driver);
            // 쿼리Connection 객체 생성 / DB 연결(접속)
        	System.out.println("test7");
            StringBuffer query = new StringBuffer();
            query.append("INSERT INTO b_user VALUES(?,?,?,?,?)");
            // 커넥션 연결
            //conn = DBConnection.getConnection();
            conn=DriverManager.getConnection(url,id,pw);
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
                if (pstm != null) pstm.close();
                if (conn != null) conn.close();  
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    } // end joinUser()

    
}
