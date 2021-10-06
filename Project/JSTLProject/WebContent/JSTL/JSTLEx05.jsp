<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core 태그 연습</title>
</head>
<body>
	<%-- c:foreach 태그는 반복한다. --%>
	<c:forEach begin="1" end="4">
		야 호 ~~~ <br />
	</c:forEach>
	<hr />
	<c:forEach var="i" begin="1" end="4">
		야 호 ${i } ~~~ <br />
	</c:forEach>
	<hr />
	<c:forEach var="i" begin="1" end="10" step="3">
		야 호 ${11-i } ~~~ <br />
	</c:forEach>
	<hr />

	<c:forEach var="size" begin="10" end="40" step="5">
		<div style="font-size: ${size}pt;">야 호 ~~~ </div>
	</c:forEach>
</body>
</html>