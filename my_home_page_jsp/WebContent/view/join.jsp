<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ������ȭ��</title>
</head>
<body>

	<form action="joinProcess.jsp" method="post">
		<table border="2">
		    <tr>
		        <td>���̵�</td>
		        <td><input type="text" name="id" /></td>
		    </tr>
		    <tr>
		        <td>��й�ȣ</td>
		        <td><input type="password" name="pw" /></td>
		    </tr>
		    <tr>
		        <td>�̸�</td>
		        <td><input type="text" size="20" name="name"/></td>
		    </tr>
		    <tr>
		        <td>�̸���</td>
		        <td><input type="text" name="email"/></td>
		    </tr>
		    <tr>
		        <td>����(�������19000101)</td>
		        <td><input type="text" name="birth"/></td>
		    </tr>
		</table>
		<br><br><input type="submit" value="ȸ������">
	</form>    
</body>
</html>