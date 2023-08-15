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
    <jsp:include page="module/top.jsp">
        <jsp:param value="첫번째 주메뉴" name="title"/>
    </jsp:include>
    
    나는 첫번째 페이지 입니다.
    
    <%-- 여기에 실행결과를 포함해 보자 --%>
    <jsp:include page="module/bottom.jsp"></jsp:include>

</body>
</html>