<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원가입화면</title>
</head>
<body>

	<form action="joinProcess.jsp" method="post">
		<table border="2">
		    <tr>
		        <td>아이디</td>
		        <td><input type="text" name="id" /></td>
		    </tr>
		    <tr>
		        <td>비밀번호</td>
		        <td><input type="password" name="pw" /></td>
		    </tr>
		    <tr>
		        <td>이름</td>
		        <td><input type="text" size="20" name="name"/></td>
		    </tr>
		    <tr>
		        <td>이메일</td>
		        <td><input type="text" name="email"/></td>
		    </tr>
		    <tr>
		        <td>생일(생년월일19000101)</td>
		        <td><input type="text" name="birth"/></td>
		    </tr>
		</table>
		<br><br><input type="submit" value="회원가입">
	</form>    
</body>
</html>