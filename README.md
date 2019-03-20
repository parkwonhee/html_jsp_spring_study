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
