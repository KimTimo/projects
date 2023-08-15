<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>4개의 영역에 변수를 저장해보자(pageContext, request, session, application)</title>
</head>
<body>
    <h2>영역에 저장된 변수는 EL로 출력이 가능하다.</h2>
    그냥 i = ${i }<br />
    pageContext i = ${pageScope.i }<br />
    request i = ${requestScope.i }<br />
    session i = ${sessionScope.i }<br />
    application i = ${applicationScope.i }<br />

</body>
</html>