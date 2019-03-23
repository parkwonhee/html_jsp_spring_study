<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page errorPage="errorPage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<%!
		String adminId;
		String adminPw;
		
		String imgDir;
		String testServerIP;
		
		String str;
	%>
	<!-- config 객체 -->
	<%
		adminId = config.getInitParameter("adminId");
		adminPw = config.getInitParameter("adminPw");
	%>
	
	<p>adminId : <%= adminId %></p>
	<p>adminPw : <%= adminPw %></p>
	
	<!-- application 객체 -->
	<%
		imgDir = application.getInitParameter("imgDir");
		testServerIP = application.getInitParameter("testServerIP");
	%>
	
	<p>imgDir : <%= imgDir %></p>
	<p>testServerIP : <%= testServerIP %></p>
	
	<%
		application.setAttribute("connectedIP", "165.62.58.23");
	//이것 먼저 실행하기--application 안에서 어디든 실행가능하다.
		application.setAttribute("connectedUser", "hong");
	%>
	<!-- out 객체 -->
	<%
		out.print("<h1>Hello JAVA World!!</h1>");
		out.print("<h2>Hello JSP World!!</h2>");
		out.print("<h3>Hello Servlet World!!</h3>");
	%>
	
	<!-- exception 객체 -->
	<%
		out.print(str.toString());
	//str초기화가 안되서 errpage로 간다.
	//errorPage.jsp로 가서 error message : null 이것을 띄운다.
	%>
</body>
</html>