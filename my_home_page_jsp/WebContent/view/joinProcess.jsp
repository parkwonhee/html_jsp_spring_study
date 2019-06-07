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
        <% 
        // form으로 넘어온 값을 변수에 저장
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String birth = request.getParameter("birth");
		
		// DTO 객체에 값을 저장
		UserDTO data = new UserDTO();
		data.setUid(id);
		data.setPw(pw);
		data.setName(name);
		data.setEmail(email);
		data.setBirth(birth);
		
		// DAO의 insert 메서드 호출 / DTO 객체(data) 전달
		UserDAO manager = UserDAO.getInstance();
		manager.joinUser(data);
		
		%>
		<%-- memberList.jsp로 이동 --%>
		<script>
			alert("회원가입 성공");
			location.href="memberList.jsp";
		</script>
        <b>회원가입이 되었습니다.</b><br>
        

</body>
</html>