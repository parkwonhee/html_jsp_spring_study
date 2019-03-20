package com.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

}
