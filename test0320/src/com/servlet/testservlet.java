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
public class testservlet extends HttpServlet {//HttpServlet������ش�
	private static final long serialVersionUID = 1L;
   //get���
	//servlet ����ܰ� service
	//doGet��� �����Ͱ� ��������url�� ����Ǿ� ������ ����, ���ȿ� ������ �� �� �ִ�. url�� �Ѱ谡 �ִ�.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println(" -- doGet() -- ");
		
		String m_name = request.getParameter("m_name");//�Ӽ� name�� ������ �̴�.
		String m_pass = request.getParameter("m_pass");
		String m_gender = request.getParameter("m_gender");
		String[] m_hobbys = request.getParameterValues("m_hobby");//values�� �迭�� �̿��Ѵ�.
		String m_residence = request.getParameter("m_residence");
		
		System.out.println("m_name : " + m_name);
		System.out.println("m_pass : " + m_pass);
		System.out.println("m_gender : " + m_gender);
		System.out.println("m_hobbys : " + Arrays.toString(m_hobbys));
		System.out.println("m_residence : " + m_residence);
		
		Enumeration<String> names = request.getParameterNames();//�Ӽ����� �´�.//enumeration�� ��ü�� �ٷ�� class��.
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			System.out.println("name : " + name);
		}
		//request ����ڰ� �ִ� ��, ������ �޴°�
		//response ������ ������ ��
	}

	//�������������� ���������� �����Ͱ� httprequest ������Ͽ� ��ȣȭ �Ǿ� ����ȴ�. ���Ȱ�ȭ
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" -- doPost() -- ");

		doGet(request, response);//doGet���� ����.
	}
	
	/* 
	 * -- postConstruct() -- 
		 -- init() -- 
		 -- doPost() --  ���� post�� ����,method�� get���� �ϸ� ������ ������ �ʴ´�.
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

	//servlet ����--�α��� ���̵� ���
	@Override
		public void init(ServletConfig config) throws ServletException {
			// TODO Auto-generated method stub
			System.out.println(" -- init() -- ");
		}
	//servlet ����--�ڿ� ȸ��, ��� ȸ�� ��
	@Override
		public void destroy() {
			// TODO Auto-generated method stub
			System.out.println(" -- Destory() -- ");
		}

	@PreDestroy
	public void preDestory() {
		System.out.println(" -- preDestory() -- ");
		
	}
	//��� : 3�� 20, 2019 2:38:01 ���� org.apache.coyote.AbstractProtocol start
	//����: Starting ProtocolHandler ["ajp-nio-8009"]
	//		3�� 20, 2019 2:38:01 ���� org.apache.catalina.startup.Catalina start
	//		����: Server startup in 402 ms
	//		 -- init() -- 
	//		 -- doGet() -- 
	// 		 -- Destory() -- 

}
