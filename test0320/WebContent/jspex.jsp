<%@page import="java.util.ArrayList"%>
<%-- 지시어 서버에서jsp페이지를처리하는방법에대한정의
세가지 page,include,taglib : 외부라이브러리태그설정 taglib uri=“uri” prefix=“네임스페이스명”  --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	
	<%! 
		//선언테그 -- JSP 페이지에서Java의멤버변수또는메서드를선언
		int num = 10; 
		String str = "jsp"; 
		ArrayList<String> list = new ArrayList<String>(); //ctrl+space
		public void jspMethod() { 
			System.out.println(" -- jspMethod() -- "); 
		}
	%>
	
	<!-- html 주석 태그 입니다. --> 
	<%-- JSP 주석코드 Hello JSP World!! --%>
	
	<%-- 스크립드릿 태그 JSP 페이지에서Java 코드를넣기위한태그 --%>
	<%
		if(num > 0) {
	%>
	<p> num > 0 </p>
	<% 
		} else {
	%> 
	<p> num <= 0 </p> 
	<% 
		} 
	%>
	
	<%-- 표현식 태그 Java의 변수 및 메서드의 반환값을 출력하는 태그 --%>
	num is <%= num %> 
	
	<!-- 
		<!DOCTYPE html>
		<html>
		<head>
		<meta charset="EUC-KR">
		<title>Insert title here</title>
		</head>
		<body>
			<p>header file</p>
			<!-- html 주석 태그 입니다. -- html주석태그만 남고 java태그는 사라진다.
			<p> num > 0 </p>
			um is 10 
		</body>
		</html> 
	-->
	
	
	
</body>
</html>