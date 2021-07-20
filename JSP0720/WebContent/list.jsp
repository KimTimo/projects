<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List<String> list = (List<String>)session.getAttribute("list"); // 세션에서 읽기
	if(list==null){ // 최초에는 없다
		System.out.println("없다!!!!");
		list = new ArrayList<>(); // 만들어주고
	}
	// 데이터 받기
	String content = request.getParameter("content");
	if(content!=null && content.trim().length()>0){ // 받은 데이터 유효하다면
		list.add(content.trim()); // 리스트에 저장
		session.setAttribute("list", list); // 다시 세션에 저장
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 생각정리 노트</title>
</head>
<body>
	<form action="?" method="post">
		나의 생각 : 
		<input type="text" name="content"  size="30"/>
		<input type="submit" value="저장" />
	</form>
	<hr />
	<h1>나의 생각들...</h1>
	<% 
		for (String c : list){ 
			out.println(c + "<br>");		
		}
	%>
	
</body>
</html>