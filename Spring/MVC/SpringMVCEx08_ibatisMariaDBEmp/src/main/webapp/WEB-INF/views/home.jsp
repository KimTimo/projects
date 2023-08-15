<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
	<h1>Hello World!!!</h1>
	<h2>DB 서버 시간 : ${serverTime }</h2>
	<h2>DB 서버 시간 : <fmt:formatDate value="${today}" pattern="yyyy-MM-dd(E) hh:mm:ss"/> </h2>
	<a href="list">목록보기</a>
</body>
</html>
