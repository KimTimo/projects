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
      
        pageContext.forward("areaEx3.jsp");  // forward로 넘기면 같은 request영역
    %>    

</body>
</html>