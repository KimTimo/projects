<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core 태그 연습</title>
</head>
<body>
	<%-- c:if 태그는 조건을 검사한다. else가 없다. --%>
	<c:if test="${empty param.score}">
		<c:set  var="score" value="67"/>
	</c:if>
	<c:if test="${not empty param.score}">
		<c:set  var="score" value="${param.score }"/>
	</c:if>
	<c:if test="${score>=0 and score<=100}">
		<c:choose>
			<c:when test="${score ge 90 }">
				${score }의 학점은 "A"입니다.
			</c:when>
			<c:when test="${score ge 80 }">
				${score }의 학점은 "B"입니다.
			</c:when>
			<c:when test="${score ge 70 }">
				${score }의 학점은 "C"입니다.
			</c:when>
			<c:when test="${score ge 60 }">
				${score }의 학점은 "D"입니다.
			</c:when>
			<c:otherwise>
				${score }의 학점은 "F"입니다.
			</c:otherwise>
		</c:choose>
	</c:if>
	<c:if test="${score<0 or score>100}">
		${score }는 잘못된 점수 입니다.
	</c:if> 
</body>
</html>