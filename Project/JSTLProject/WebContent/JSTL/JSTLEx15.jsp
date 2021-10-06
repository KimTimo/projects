<%@page import="java.util.TimeZone"%>
<%@page import="java.util.Locale"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세계 시간표 보기</title>
</head>
<body>

	<h1>전세계 시간표 보기</h1>
	<jsp:useBean id="today" class="java.util.Date"/>
	<c:forEach var="tz" items="<%=TimeZone.getAvailableIDs() %>" varStatus="vs">
		${tz } <br />
		<fmt:timeZone value="${tz }">
			<fmt:formatDate value="${today }" dateStyle="full"/> <br />
			<fmt:formatDate value="${today }" type="time" timeStyle="full"/> <br />
		</fmt:timeZone>
		<hr />		
	</c:forEach>
	<br /> <hr />
</body>
</html>