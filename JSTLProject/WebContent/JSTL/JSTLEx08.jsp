<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core 태그 연습</title>
</head>
<body>
	<%-- JSP 태그로 예외 처리 하기 --%>
	<c:catch var="e">
		<% 
		int num1 = 100;
		int num2 = 0;
		int result = num1/ num2; 
		%>
		나눗셈의 결과 : <%=result %>
	</c:catch>
	
	<c:if test="${empty e }">
		<h2>에러 없다!!!</h2>
	</c:if>

	<c:if test="${not empty e }">
		<h2>에러 발생!!! : ${e.message }</h2>
	</c:if>
	<hr />
	<c:catch var="e">
		<c:set var="num1" value="100" scope="page"/>
		<c:set var="num2" value="0"  scope="page"/>
		나눗셈의 결과 : ${num1/num2 } <%-- EL은 에러 아님!! --%>
	</c:catch>
	
	<c:if test="${empty e }">
		<h2>에러 없다!!!</h2>
	</c:if>

	<c:if test="${not empty e }">
		<h2>에러 발생!!! : ${e.message }</h2>
	</c:if>
</body>
</html>