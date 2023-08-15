<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta charset="UTF-8"/>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>

	<hr />
	현재 사용자 : ${user }
	<br />
	<hr />
	<a href="admin">관리자 페이지 가기</a>
	<a href="dba">DB관리자 페이지 가기</a>
	<a href="home">일반페이지 가기</a>
	<c:if test='${user!="anonymousUser" }'>
		<a href="${pageContext.request.contextPath }/logout">로그아웃</a>
	</c:if>
	<c:if test='${user=="anonymousUser" }'>
		<a href="${pageContext.request.contextPath }/login">로그인</a>
	</c:if>
</body>
</html>
