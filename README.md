# html_jsp_spring_study
--------


jsp와 servlet 사용법<br>
servlet
```
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("</head>");
		out.print("<body>");
		out.print("Hello Servlet~java based serverside programe file<br>
    C:\\Users\\pinka\\eclipse-workspace\\test0319\\src\\com\\servlet<br>
    Write in here");//
		out.print("</body>");
		out.print("</html>");
	}
  ```
  <br>
  <br>
  서블릿매핑<br>
  1.서브릿매핑 java annotation을 이용한다.
  
  ```
  @WebServlet("/HS")  //http://localhost:8080/test0319/HS을 찾아 들어오면 이것을 나타낸당!!
  ```
2.web.xml에 설정하기

```
 <servlet>
    <servlet-name>hellWorldServlet</servlet-name> <!-- 이름 지정 -->
    <servlet-class>com.java.ex.Helloworld</servlet-class> <!-- Servlet class 지정 -->
  </servlet>
  <servlet-mapping>
    <servlet-name>hellWorldServlet</servlet-name>
    <url-pattern>/hw</url-pattern> <!-- http://localhost:80/ex/hw 로 맵핑된다. -> 컨텍스트패스/hw -->
  </servlet-mapping>
 ```
 
 servlet circle cycle 4단계

```
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" -- doPost() -- ");

		doGet(request, response);//doGet으로 간다.
	}
	
	@PostConstruct
	public void postConstruct() {
		System.out.println(" -- postConstruct() -- ");
	}

	//servlet 생성--로그인 아이디 등등
	@Override
		public void init(ServletConfig config) throws ServletException {
			// TODO Auto-generated method stub
			System.out.println(" -- init() -- ");
		}
	//servlet 종료--자원 회수, 디비 회수 등
	@Override
		public void destroy() {
			// TODO Auto-generated method stub
			System.out.println(" -- Destory() -- ");
		}

	@PreDestroy
	public void preDestory() {
		System.out.println(" -- preDestory() -- ");
		
	}
	//결과 : 3월 20, 2019 2:38:01 오후 org.apache.coyote.AbstractProtocol start
	//정보: Starting ProtocolHandler ["ajp-nio-8009"]
	//		3월 20, 2019 2:38:01 오후 org.apache.catalina.startup.Catalina start
	//		정보: Server startup in 402 ms
	//		 -- init() -- 
	//		 -- doGet() -- 
	// 		 -- Destory() -- 
```

<br><br><br>
예시
html example<br>

```
<form action="mSignUp" method="post">
		name : <input type="text" name="m_name"> </br>
		password : <input type="password" name="m_pass"></br>
		gender : Man<input type="radio" name="m_gender" value="M" checked="checked">, Woman<input type="radio" name="m_gender" value="W"></br>
		hobby : Sport<input type="checkbox" name="m_hobby" value="sport">, 
				Cooking<input type="checkbox" name="m_hobby" value="cooking">, 
				Reading<input type="checkbox" name="m_hobby" value="reading">,
				Travel<input type="checkbox" name="m_hobby" value="travel"></br>
		residence : <select name="m_residence">
						<option value="seoul" selected="selected">Seoul</option>
						<option value="gyeonggi">Gyeonggi</option>
						<option value="chungcheong">Chungcheong</option>
						<option value="jeonra">Jeonra</option>
						<option value="jeju">Jeju</option>
						<option value="gyeongsang">Gyeongsang</option>
						<option value="gangwon">Gangwon</option>
					</select></br>
					<input type="submit" value="sign up">
	</form>
```

get post 방식 차이점과 servlet 사용하기

```
@WebServlet("/mSignUp")
public class testservlet extends HttpServlet {//HttpServlet상속해준다
	private static final long serialVersionUID = 1L;
   //get방식
	//servlet 실행단계 service
	//doGet방식 데이터가 웹브라우저url에 노출되어 서버로 전송, 보안에 문제가 될 수 있다. url에 한계가 있다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println(" -- doGet() -- ");
		
		String m_name = request.getParameter("m_name");//속성 name의 데이터 이다.
		String m_pass = request.getParameter("m_pass");
		String m_gender = request.getParameter("m_gender");
		String[] m_hobbys = request.getParameterValues("m_hobby");//values는 배열을 이용한다.
		String m_residence = request.getParameter("m_residence");
		
		System.out.println("m_name : " + m_name);
		System.out.println("m_pass : " + m_pass);
		System.out.println("m_gender : " + m_gender);
		System.out.println("m_hobbys : " + Arrays.toString(m_hobbys));
		System.out.println("m_residence : " + m_residence);
		
		Enumeration<String> names = request.getParameterNames();//속성값이 온다.//enumeration은 객체를 다루는 class다.
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			System.out.println("name : " + name);
		}
		//request 사용자가 주는 것, 서버가 받는것
		//response 서버가 응답할 때
	}

	//매핑정보만노출 매핑정보가 데이터가 httprequest 헤더파일에 암호화 되어 저장된다. 보안강화
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" -- doPost() -- ");

		doGet(request, response);//doGet으로 간다.
	}
	
	/* 
	 * -- postConstruct() -- 
		 -- init() -- 
		 -- doPost() --  먼저 post로 간다,method를 get으로 하면 이줄이 나오지 않는다.
		 -- doGet() -- 
		m_name : 12313
		m_pass : 12
		m_gender : M
		m_hobbys : [cooking, reading, travel]
		m_residence : seoul
		name : m_name
		name : m_pass
		name : m_gender
		name : m_hobby
		name : m_residence
		*/
```
JSP태그 방식

```
<%@page import="java.util.ArrayList"%>
<%-- 지시어 서버에서jsp페이지를처리하는방법에대한정의
세가지 page,include,taglib : 외부라이브러리태그설정 taglib uri=“uri” prefix=“네임스페이스명”  --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
	
<%! 
	//선언테그 -- JSP 페이지에서Java의멤버변수또는메서드를선언
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

<%-- 표현식 태그 Java의 변수 및 메서드의 반환값을 출력하는 태그 --%>
num is <%= num %> 
```
<br><br>
jsp request and response 사용법

```
<% 
	m_name = request.getParameter("m_name"); 
	m_pass = request.getParameter("m_pass"); 
	m_gender = request.getParameter("m_gender"); 
	m_hobby = request.getParameterValues("m_hobby"); 
	m_residence = request.getParameter("m_residence"); 
%> 


<p>firstpage</p><br>
<% response.sendRedirect("secondpage.jsp"); %>
```
<br><br>
jsp내장객체

web.xml
사진
![webjsp](https://user-images.githubusercontent.com/38245863/54889266-177d2480-4ee7-11e9-9954-8d8e9019c7e2.PNG)

jspEx.jsp

```
<%@ page errorPage="errorPage.jsp"%>//에러페이지로 가기
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

```

jspGet.jsp
```
<%!
			String connectedIP;
			String connectedUser;
			
		%>
		
		<!-- application 객체 -->
		<%
			connectedIP = (String)application.getAttribute("connectedIP");
		//무조건 string이여야 한다.!!!!
			connectedUser = (String)application.getAttribute("connectedUser");
		%>
		
		<p>connectedIP : <%= connectedIP %></p>
		<p>connectedUser : <%= connectedUser %></p>
```

<br><br>
servlet의 데이터 공유

web.xml
설정 사진

![webservlet](https://user-images.githubusercontent.com/38245863/54889270-1b10ab80-4ee7-11e9-8d8f-ab71355a6f63.PNG)

servletEx.java
```
		//  servlet데이터 공유 방법 3가지 servlet parameter
		String adminId = getServletConfig().getInitParameter("adminId");
		String adminPw = getServletConfig().getInitParameter("adminPw");
		
		PrintWriter out = response.getWriter();
		out.print("<p>adminId : "+adminId+"</p>");
		out.print("<p>adminPw : "+adminPw+"</p>");
		
		// context parameter
		String imgDir = getServletContext().getInitParameter("imgDir"); 
		String testServerIP = getServletContext().getInitParameter("testServerIP");
		
		out.print("<p>imgDir : "+imgDir+"</p>");
		out.print("<p>testServerIP : "+testServerIP+"</p>");
		//context attribute
		getServletContext().setAttribute("connectedIP", "165.62.58.23"); 
		getServletContext().setAttribute("connectedUser", "hong");
```

servletGet.java
```
		String connectedIP = (String)getServletContext().getAttribute("connectedIP"); 
		String connectedUser = (String)getServletContext().getAttribute("connectedUser");

		PrintWriter out = response.getWriter();
		out.print("<p>connectedIP : "+connectedIP+"</p>");
		out.print("<p>connectedUser : "+connectedUser+"</p>");
```
<br><br>
cookie의 과정(클라이언트에 저장하기)

login.jsp

```
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

```
loginCon.java

```
		String id = request.getParameter("id"); 
		String pw = request.getParameter("pw");
				
		PrintWriter out = response.getWriter();
		out.print("<p>id : "+id+"</p>");
		out.print("<p>pw : "+pw+"</p>");
		
		Cookie[] cookies = request.getCookies();
		Cookie cookie = null;
		//cookies를 조회
		for (Cookie c : cookies) {
			System.out.println ( "c.getName() : " + c.getName() + ", c.getValue() : " + c.getValue());
			
			if(c.getName().equals("memberId")) { 
				cookie = c; 
			}
		}
		if(cookie == null) { 
			System. out .println ( "cookie is null" ); 
			cookie = new Cookie("memberId", id); 
		}
		response.addCookie(cookie); 
		cookie.setMaxAge(60*60);//1시간의 완료 기간이다.
		
		response.sendRedirect("loginOk.jsp");

```

loginOk.jsp

```
	<%
	 	Cookie[] cookies = request.getCookies();
		for(Cookie c : cookies){
			out.print("name : "+c.getName()+"<br>");
			out.print("value : "+c.getValue()+"<br>");
			out.print("-------------------------");
		}
	%>
```

<br><br>
session의 과정(서버에 저장하기)

login_se.jsp

```
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
```

loginse.java

```
		request.setCharacterEncoding("UTF-8");//한글처리
		
		response.setContentType("test/html;charset=UTF-8");

		PrintWriter out = response.getWriter();

		String name = request.getParameter("name"); 
		String id = request.getParameter("id"); 
		String pw = request.getParameter("pw");
				
		out.print("<p>name : "+name+"</p>");
		out.print("<p>id : "+id+"</p>");
		out.print("<p>pw : "+pw+"</p>");
		
		HttpSession session = request.getSession();
		session.setAttribute("memberId", id);
		
		response.sendRedirect("loginOk2.jsp");
```
loginOK2.jsp

```
	<%
		session = request.getSession(); 
		out.print("memberId : " + session.getAttribute("memberId") + "</br>");

	%>
		<form action="logout" method="post">
		<input type="submit" value="logout">
		</form>
```

logoutse.java

```
		HttpSession session = request.getSession();
		session.invalidate();//세션 날리기
		
		response.sendRedirect("login_se.jsp");

```

한글처리 및 필터

```
 		jsp에서
		<% request.setCharacterEncoding("utf-8"); %>
		servlet에서
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("test/html;charset=UTF-8");
```
filter.java

```
public class TempFilter implements Filter {

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println(" -- filter init() --");
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println(" -- filter doFilter() --");
		
		// reqeust filter
		req.setCharacterEncoding("UTF-8");
		
		chain.doFilter(req, res);
		
		// response filter
		
	}
	
	@Override
	public void destroy() {
		System.out.println(" -- filter destroy() --");
	}

}
```
