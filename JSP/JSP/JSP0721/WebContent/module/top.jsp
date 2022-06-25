<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
    #header{
        border-bottom: 5px solid gray;
        padding: 10px;
        text-align: center;
        font-size: 15pt;
        margin-bottom: 10px;
        background-color: silver;
    }
</style>
</head>
<body> 
	<div id="header">
		<h2><%=request.getParameter("title") %></h2>
		<a href="main1.jsp">메뉴1</a> 
		<a href="main2.jsp">메뉴2</a> 
		<a href="main3.jsp">메뉴3</a>
	</div>
</body>
</html>