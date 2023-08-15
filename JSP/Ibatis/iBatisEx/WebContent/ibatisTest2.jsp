<%@page import="kr.green.ibatis.vo.TestVO"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.HashMap"%>
<%@page import="kr.green.ibatis.IbatisApp"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
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
	SqlMapClient sqlMapClient = IbatisApp.getSqlMapClient();
	System.out.println("연결 성공 : " + sqlMapClient);
	
	HashMap<String, String> map = new HashMap<>();
	map.put("num1", "12");
	map.put("num2", "6");
	map.put("num3", "10");
	map.put("name", "한사람");
	// VO로 받기
	TestVO testVO = (TestVO)sqlMapClient.queryForObject("test2.calc", map);
	out.println(testVO + "<br>");
	out.println(testVO.getNow() + "<br>");
	out.println(testVO.getResult() + "<br>");
	out.println(testVO.getMessage() + "<br><hr>");
	
	// Map으로 받기
	HashMap<String, Object> map2 = (HashMap<String, Object>)sqlMapClient.queryForObject("test2.calcMap", map);
	out.println(map2 + "<br>");
	out.println(map2.get("now") + "<br>");
	out.println(map2.get("result") + "<br>");
	out.println(map2.get("message") + "<br><hr>");

	
	%>
</body>
</html>