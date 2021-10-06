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
	
	<c:set  var="oddSum" value="0"/> 
	<c:set  var="evenSum" value="0"/>
	<c:forEach var="i" begin="1" end="100"> 
		<c:if test="${i mod 2 ne 0 }">
			<c:set  var="oddSum" value="${oddSum + i }"/> 
		</c:if>
		<c:if test="${i mod 2 eq 0 }">
			<c:set  var="evenSum" value="${evenSum + i }"/> 
		</c:if>
	</c:forEach>
	
	1~100까지 홀수 합 : ${oddSum } <br />
	1~100까지 짝수 합 : ${evenSum } <br />
	
</body>
</html>