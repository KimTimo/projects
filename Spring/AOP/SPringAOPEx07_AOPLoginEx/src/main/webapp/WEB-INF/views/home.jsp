<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
	<title>Home</title>
	<meta charset="UTF-8">
</head>
<body>
	<h1> Hello world! </h1>
	<hr/>
	<c:if test="${not empty userId }">
		${userId }님 방가방가
		<input type="button" value="로그아웃" onclick="location.href='logout'"/>
	</c:if>
	<c:if test="${empty userId }">
		손님 방가방가
		<input type="button" value="로그인" onclick="location.href='login'"/>
	</c:if>
	<hr/>
	<P>The time on the server is ${serverTime}. </P>
	<a href="list">목록으로가기</a>
	<a href="insert">등록하러가기</a>
</body>
</html>
