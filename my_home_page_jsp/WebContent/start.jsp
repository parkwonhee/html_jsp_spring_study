<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%    // 인코딩 post방식
    request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>my list</title>
</head>
<body>
my blog

how to contect JDBC
    
 <!--  	  <Resource auth="Container" 
          name="jdbc/Oracle11g" 
          driverClassName="oracle.jdbc.driver.OracleDriver" 
          type="javax.sql.DataSource" 
          url="jdbc:oracle:thin:@localhost:1521:xe" 
          username="scott"
          password="" 
          loginTimeout="10" 
          maxActive="50" 
          maxIdle="20"
          maxWait="5000" 
          testOnBorrow="true" />

</Context>-->

    auth : 컨테이너를 자원 관리자로 기술
    name : JDBC이름, 변경 가능
    driverClassName : JDBC 드라이버
    type : 웹에서 이 리소스를 사용할 때 DataSource로 리턴됨
    username : 접속계정
    password : 접속할 계정 비밀번호
    
    loginTimeout : 연결 끊어지는 시간
    maxActive : 최대 연결 가능한 Connection수 (기본 20개)
    maxIdle : Connection pool 유지를 위해 최대 대기 connection 숫자
    maxWait : 사용 가능한 커넥션이 없을 때 커넥션 회수를 기다리는 시간 (1000 = 1초)
    testOnBorrow : db에 test를 해볼 것인지
<!--   <resource-ref>
     <description>connection</description>
     <res-ref-name>jdbc/orcl</res-ref-name>
     <res-type>javax.sql.DataSource</res-type>
     <res-auth>Container</res-auth>
</resource-ref>
 -->
  description : 설명
    res-ref-name : JDBC 이름, <Resource>의 name 부분과 동일하게 입력
    res-type : <Resource>의 type 부분과 동일하게 입력
    res-auth : <Resource>의 auth 부분과 동일하게 입력


출처: https://all-record.tistory.com/104?category=733042 [세상의 모든 기록]


</body>
</html>