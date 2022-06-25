<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>어디로 부터 왔는지를 판단하는 방법</h1>
    이전 페이지 : <%=request.getHeader("referer") %> <br />
    <button onclick="location.href='referer.jsp'">눌러줘잉</button>
    <a href="referer.jsp">눌러줭2</a>
    

</body>
</html>