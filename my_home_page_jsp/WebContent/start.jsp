<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%    // ���ڵ� post���
    request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>my list</title>
</head>
<body>
my blog

how to contect JDBC
    
 <!--  	  <Resource auth="Container" 
          name="jdbc/Oracle11g" 
          driverClassName="oracle.jdbc.driver.OracleDriver" 
          type="javax.sql.DataSource" 
          url="jdbc:oracle:thin:@localhost:1521:xe" 
          username="scott"
          password="" 
          loginTimeout="10" 
          maxActive="50" 
          maxIdle="20"
          maxWait="5000" 
          testOnBorrow="true" />

</Context>-->

    auth : �����̳ʸ� �ڿ� �����ڷ� ���
    name : JDBC�̸�, ���� ����
    driverClassName : JDBC ����̹�
    type : ������ �� ���ҽ��� ����� �� DataSource�� ���ϵ�
    username : ���Ӱ���
    password : ������ ���� ��й�ȣ
    
    loginTimeout : ���� �������� �ð�
    maxActive : �ִ� ���� ������ Connection�� (�⺻ 20��)
    maxIdle : Connection pool ������ ���� �ִ� ��� connection ����
    maxWait : ��� ������ Ŀ�ؼ��� ���� �� Ŀ�ؼ� ȸ���� ��ٸ��� �ð� (1000 = 1��)
    testOnBorrow : db�� test�� �غ� ������
<!--   <resource-ref>
     <description>connection</description>
     <res-ref-name>jdbc/orcl</res-ref-name>
     <res-type>javax.sql.DataSource</res-type>
     <res-auth>Container</res-auth>
</resource-ref>
 -->
  description : ����
    res-ref-name : JDBC �̸�, <Resource>�� name �κа� �����ϰ� �Է�
    res-type : <Resource>�� type �κа� �����ϰ� �Է�
    res-auth : <Resource>�� auth �κа� �����ϰ� �Է�


��ó: https://all-record.tistory.com/104?category=733042 [������ ��� ���]


</body>
</html>