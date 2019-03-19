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
