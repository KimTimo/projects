<%@page import="java.util.Arrays"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- JSTL과 같이 써야 한다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL Set 사용</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script type="text/javascript">
	
</script>
<style type="text/css">
</style>

</head>
<body>
	<h1>EL Set 사용</h1>
	<%
		Set<String> set = new HashSet<>(Arrays.asList(new String[]{"한놈","두식이","석삼","너구리"}));
		pageContext.setAttribute("set", set);
	%>
	<h1>Set의 내용 : ${set }</h1>	
	
	<c:forEach var="name" items="${set }">
		${name } <br />
	</c:forEach>

</body>
</html>