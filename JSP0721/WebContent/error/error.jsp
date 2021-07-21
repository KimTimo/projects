<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- 나는 에러가 발생하면 보여지는 페이지 입니다. --%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error!!!</title>
</head>
<body>
    <h2 style="color: red;">죄송함다. 얼른 고칠게요....</h2>
    에러 메세지 : <%=exception.getMessage() %> <br />
    <%-- 에러를 추적하려면 --%>
    <%
        exception.printStackTrace();
    %>

</body>
</html>