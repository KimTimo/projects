<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>URL인코딩 방법</title>
</head>
<body>
	<a href="?name1=한사람&nick1=최고관리자">URL에 한글1</a> <br />
	<a href="?name2=qwerty&nick2=12345">URL에 영문1</a> <br />
	<a href="?name3=<%=URLEncoder.encode("한사람","UTF-8") %>&nick3=<%=URLEncoder.encode("최고관리자","UTF-8") %>">URL에 한글2</a> <br />
	<hr />
	<h2>데이터를 받아보자!!!</h2>
	<%
		String name1 = request.getParameter("name1");
		String nick1 = request.getParameter("nick1");
	
		String name2 = request.getParameter("name2");
		String nick2 = request.getParameter("nick2");
	
		String name3 = request.getParameter("name3");
		String nick3 = request.getParameter("nick3");
	%>
	<%=name1 %> <br />
	<%=name2 %> <br />
	<%=name3 %> <br />
	<br />
	<%=nick1 %> <br />
	<%=nick2 %> <br />
	<%=nick3 %> <br />
</body>
</html>