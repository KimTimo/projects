<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href='<c:url value="/test"/>'>테스트해보기</a>

<hr />
	로그인 정보 :  ${user } <br />
	세션정보 : ${sessionScope.mvo } <br />
</body>
</html>
