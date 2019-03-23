<% request.setCharacterEncoding("utf-8"); %>
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
		session = request.getSession(); 
		out.print("memberId : " + session.getAttribute("memberId") + "</br>");

	%>
		<form action="logout" method="post">
		<input type="submit" value="logout">
		</form>
</body>
</html>