<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한글이 받아질까용?</title>
</head>
<body>
    <%--
    POST 전송에서 한글이 깨지지 않으려면
    request.setCharacterEncoding("UTF-8"); 를 꼭 써줘야 했지만
    web.xml에 필터를 등록해주면 생략해도 한글이 깨지지 않고
    정상적으로 출력된다.
    
     --%>
     <%
         request.setCharacterEncoding("UTF-8");
     %>
    ${param.text}
    <br />
    <%= request.getParameter("text")%>
    <br />

</body>
</html>