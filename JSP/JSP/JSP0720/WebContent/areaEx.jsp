<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>4개의 영역에 변수를 저장해보자(pageContext, request, session, application)</title>
</head>
<body>
    <%
        int i = 100;
        pageContext.setAttribute("i", 111);
        request.setAttribute("i", 222);
        session.setAttribute("i", 333);
        application.setAttribute("i", 444);
        
        // i라는 변수를 5개 만들었다
        // 영역에 저장된 변수 읽기
        out.println("i = " + i + "<br>");
        out.println("pageContext i = " + pageContext.getAttribute("i") + "<br>");
        out.println("request i = " + request.getAttribute("i") + "<br>");
        out.println("session i = " + session.getAttribute("i") + "<br>");
        out.println("application i = " + application.getAttribute("i") + "<br>");
    %>
    <hr />
    <h2>영역에 저장된 변수는 EL로 출력이 가능하다.</h2>
    그냥 i = ${i }<br />
    pageContext i = ${pageScope.i }<br />
    request i = ${requestScope.i }<br />
    session i = ${sessionScope.i }<br />
    application i = ${applicationScope.i }<br />

</body>
</html>