<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="DTO.UserDTO" %> 
<!-- DAO import --> 
<%@ page import="model.UserDAO" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ������ ó�� JSP</title>
</head>
<body>
        <%
        	// �ѱ� ���ڵ� ó��
        request.setCharacterEncoding("utf-8");
        %>
       
        <b>ȸ������ ������ Ȯ���ϼ���.</b>
        <br/><br/>
        
        <!-- �ڹٺ� �׼��±� ���--DTO -->
        <%-- <jsp:useBean id="userBean" type="DTO.userBean" /> --%>
        

 		<%
         			// ȸ�������� ó���� DAOŬ������ ��ü�� �����Ѵ�.
         		         		            UserDAO dao = UserDAO.getInstance();
         		         		        
         		         		 			// ȸ�������� ����ִ� memberBean ��ü�� DAOŬ������ �����Ѵ�.
         		         		 			UserDTO userbean = new UserDTO();
         		         		            dao.joinUser(userbean);
         		%>
        
        <b>ȸ�������� �Ǿ����ϴ�.</b><br>
        
        <b><%=userbean.getUid() %></b>���� ȸ�������Դϴ�. <br/><br/>
        
        <table border="2">
	        <tr>
	            <td>���̵�</td>
	            <td><%=userbean.getUid()%></td>
	        </tr>
	        <tr>
	            <td>��й�ȣ</td>
	            <td><%=userbean.getPw()%></td>
	        </tr>
	        <tr>
	            <td>�̸�</td>
	            <td><%=userbean.getName()%></td>
	        </tr>
	        <tr>
	            <td>�̸���</td>
	            <td><%=userbean.getEmail()%></td>
	        </tr>
	        <tr>
	            <td>����</td>
	            <td><%=userbean.getBirth()%></td>
	        </tr>
        </table>

</body>
</html>