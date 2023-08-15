<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    이전 페이지 : <%=request.getHeader("referer") %> <br />
    <button onclick="history.back();">돌아가기 1</button>
    <button onclick="history.go(-1);">돌아가기 2</button>
    <button onclick="location.href='<%=request.getHeader("referer") %>'">돌아가기 3</button>

</body>
</html>