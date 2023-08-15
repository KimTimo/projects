<%@page import="kr.green.mybatis.MybatisApp"%>
<%@page import="org.apache.log4j.Logger"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	SqlSession sqlSession = MybatisApp.getSessionjFactory().openSession();
	try {
	  
		String today = sqlSession.selectOne("test.today");
		out.println("현재 : " + today + "<br>");
		
		HashMap<String,Integer> map = new HashMap<>();
		map.put("num1", 100);
		map.put("num2", 200);
		map.put("num3", 300);
		out.println("합 : " + sqlSession.selectOne("test.sum", map) + "<br>");

		HashMap<String,Integer> map2 = new HashMap<>();
		map2.put("num1", 45);
		map2.put("num2", 67);
		out.println("곱 : " + sqlSession.selectOne("test.mul", map2) + "<br>");
		
	} finally {
		sqlSession.close();
	}
	
	%>
</body>
</html>