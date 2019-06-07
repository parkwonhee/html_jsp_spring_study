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
        <% 
        // form���� �Ѿ�� ���� ������ ����
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String birth = request.getParameter("birth");
		
		// DTO ��ü�� ���� ����
		UserDTO data = new UserDTO();
		data.setUid(id);
		data.setPw(pw);
		data.setName(name);
		data.setEmail(email);
		data.setBirth(birth);
		
		// DAO�� insert �޼��� ȣ�� / DTO ��ü(data) ����
		UserDAO manager = UserDAO.getInstance();
		manager.joinUser(data);
		
		%>
		<%-- memberList.jsp�� �̵� --%>
		<script>
			alert("ȸ������ ����");
			location.href="memberList.jsp";
		</script>
        <b>ȸ�������� �Ǿ����ϴ�.</b><br>
        

</body>
</html>