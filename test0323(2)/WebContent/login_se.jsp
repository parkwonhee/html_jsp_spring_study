<% request.setCharacterEncoding("utf-8"); //get방식은<Connector URIEncoding="UTF-8" /> 추가%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<%
		if(session.getAttribute("memberId") != null)
			response.sendRedirect("loginOk2.jsp");
	%>
	<form action="loginse" metiod="post">
		이름 <input type="text" name="name"><br>
		ID <input type="text" name="id"><br>
		PW <input type="password" name="pw"><br>
		<input type="submit" value="login">
	</form>
</body>
</html>