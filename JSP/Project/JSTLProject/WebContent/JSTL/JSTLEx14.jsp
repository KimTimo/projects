<%@page import="java.util.Locale"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모든 로케일 보기</title>
</head>
<body>
	<h1>전세계 모든 로케일 보기</h1>
	<c:forEach var="lo" items="<%=Locale.getAvailableLocales() %>" varStatus="vs">
		${vs.count }. ${lo } <br /> 
	</c:forEach>
	<br /> <hr />
	
	<h1>전세계 모든 날짜/숫자 형식 보기</h1>
	<jsp:useBean id="today" class="java.util.Date"/>
	<c:forEach var="lo" items="<%=Locale.getAvailableLocales() %>" varStatus="vs">
		<fmt:setLocale value="${lo }"/>
		${lo } <br />
		<fmt:formatDate value="${today }"/> <br />
		<fmt:formatNumber value="123456789.123456789"/> <br />
		<hr />		
	</c:forEach>
	<br /> <hr />
</body>
</html>