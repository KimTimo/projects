<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
	<meta charset="UTF-8">
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  현재시간 : ${today}. </P>
<P>  덧셈 : ${sum} </P>
<P>  곱셈 : ${mul} </P>
<hr />
<a href='<c:url value="/"/>'>홈으로</a>
</body>
</html>
