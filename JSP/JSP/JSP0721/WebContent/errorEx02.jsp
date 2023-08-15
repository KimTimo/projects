<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ page errorPage = "error/error.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일부러 에러 발생</title>
</head>
<body>
    3/0 = <%=3/0 %> <br />

</body>
</html>
<%-- 에러처리 우선 순위
1. errorPage 를 찾는다.
2. exception-type 
3. error-code
4. jsp 에러페이지



--%>