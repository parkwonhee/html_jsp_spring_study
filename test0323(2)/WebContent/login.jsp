<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		//login이 이미 되어있나??

	 	Cookie[] cookies = request.getCookies();
		System.out.println("cookies : "+cookies);
		
		if(cookies != null){
			for(Cookie c : cookies){
				if(c.getName().equals("memberId")){
					response.sendRedirect("loginOK.jsp");
				}
			}
		}
		
	%>
	
	<form action="loginCon" metiod="post">
	ID <input type="text" name="id"><br>
	PW <input type="password" name="pw"><br>
	<input type="submit" value="login">
	</form>

</body>
</html>