<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%-- 여기에 실행결과를 포함해 보자 --%>
    <%--
         경로 앞에 ${pageContext.request.contextPath }/ 를 붙이면 절대경로가 된다.
     --%>
    
    
    <jsp:include page="../module/top.jsp"></jsp:include>
    
    나는 첫번째 페이지 입니다.
    
    <%-- 여기에 실행결과를 포함해 보자 --%>
    <jsp:include page="../module/bottom.jsp"></jsp:include>

</body>
</html>