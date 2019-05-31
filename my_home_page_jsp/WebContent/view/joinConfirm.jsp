<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="DTO.UserDTO" %> 
<!-- DAO import --> 
<%@ page import="model.UserDAO" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원가입 처리 JSP</title>
</head>
<body>
        <%
        	// 한글 인코딩 처리
        request.setCharacterEncoding("utf-8");
        %>
       
        <b>회원가입 정보를 확인하세요.</b>
        <br/><br/>
        
        <!-- 자바빈 액션태그 사용--DTO -->
        <%-- <jsp:useBean id="userBean" type="DTO.userBean" /> --%>
        

 		<%
         			// 회원가입을 처리할 DAO클래스의 객체를 생성한다.
         		         		            UserDAO dao = UserDAO.getInstance();
         		         		        
         		         		 			// 회원정보를 담고있는 memberBean 객체를 DAO클래스로 전달한다.
         		         		 			UserDTO userbean = new UserDTO();
         		         		            dao.joinUser(userbean);
         		%>
        
        <b>회원가입이 되었습니다.</b><br>
        
        <b><%=userbean.getUid() %></b>님의 회원정보입니다. <br/><br/>
        
        <table border="2">
	        <tr>
	            <td>아이디</td>
	            <td><%=userbean.getUid()%></td>
	        </tr>
	        <tr>
	            <td>비밀번호</td>
	            <td><%=userbean.getPw()%></td>
	        </tr>
	        <tr>
	            <td>이름</td>
	            <td><%=userbean.getName()%></td>
	        </tr>
	        <tr>
	            <td>이메일</td>
	            <td><%=userbean.getEmail()%></td>
	        </tr>
	        <tr>
	            <td>생일</td>
	            <td><%=userbean.getBirth()%></td>
	        </tr>
        </table>

</body>
</html>