<%@page import="java.util.HashMap"%>
<%@page import="kr.green.mybatis.service.TestService"%>
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
	 HashMap<String, Object> map1 = TestService.getInstance().testMaria();
	 HashMap<String, Object> map2 = TestService.getInstance().testOracle();
	 request.setAttribute("map1", map1);
	 request.setAttribute("map2", map2);
	%>
	<h2>MariaDB Test</h2>
	오늘날짜 : ${map1.today } <br />
	계산결과 : ${map1.calc } <br /><hr />
	VO : ${map1.testVO } <br />
	hashMap : ${map1.hashMap } <br /><hr />
	
	<h2>OracleDB Test</h2>
	오늘날짜 : ${map2.today } <br />
	계산결과 : ${map2.calc } <br /><hr />
	VO : ${map2.testVO } <br />
	hashMap : ${map2.hashMap } <br /><hr />
	
</body>
</html>