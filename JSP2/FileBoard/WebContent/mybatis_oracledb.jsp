<%@page import="org.apache.ibatis.io.Resources"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Date"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="org.apache.ibatis.session.SqlSessionFactoryBuilder"%>
<%@page import="org.apache.ibatis.session.SqlSessionFactory"%>
<%@page import="java.io.InputStream"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/comm.js"></script>
<script>
	$(function(){
	
	});
</script>
</head>
<body>
	<%
	String resource = "mybatis-config.xml";
	InputStream inputStream = Resources.getResourceAsStream(resource);
	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);	
	
	SqlSession sqlSession = null;
	try{
		// false 는 autoCommit 하지 않겠다는 의미.
		sqlSession = sqlSessionFactory.openSession(false);
		out.println("연결 성공 : " + sqlSession + "<br>");
		// -----------------------------------------------------------------------
		Date today = sqlSession.selectOne("oracledb.test.today");
		out.println("서버 시간 : " + today + "<br>");
		HashMap<String, Integer> hashMap = new HashMap<>();
		hashMap.put("num1", 34);
		hashMap.put("num2", 3);
		hashMap.put("num3", 5);
		int result = sqlSession.selectOne("oracledb.test.calc", hashMap);
		out.println("(34 + 3) * 5 = " + result + "<br>");
		// -----------------------------------------------------------------------
		sqlSession.commit();
	}catch(Exception e){
		sqlSession.rollback();
		e.printStackTrace();
	}finally{
		try {
			if(sqlSession!=null) sqlSession.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	%>
</body>
</html>