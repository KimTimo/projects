<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>오늘의 날짜 : 2021년 07월 12일</h1>
<h1>오늘의 날짜 : <%=new Date().toLocaleString() %></h1>

</body>
</html>