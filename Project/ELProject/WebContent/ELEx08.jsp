<%@page import="java.util.Enumeration"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<script>
	$(function(){
		
	});
</script>
</head>
<body>
	<h1>쿠키 정보를 출력해보자 : 표현식 사용</h1>
	<%
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies){
			out.println(cookie.getName() + " : " + cookie.getValue() + "<br>");
		}
	%>
	
	<h1>쿠키 정보를 출력해보자 : EL사용</h1>
	<%-- JSTL과 EL을 같이 사용하면 다음과같이 모든 헤더를 출력 가능하다. --%>
	<c:forEach var="c" items="${pageContext.request.cookies }">
		${c.name } : ${c.value } <br />	
	</c:forEach>
</body>
</html>