<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키를 저장해 보자!!!</title>
</head>
<body>
	<%
		Cookie cookie1 = new Cookie("userid","admin");
		cookie1.setMaxAge(0);
		// Cookie cookie2 = new Cookie("nickName","최고 관리자"); // 한글을 쿠키로 저장 불가!!!
		Cookie cookie2 = new Cookie("nickName",URLEncoder.encode("최고 관리자","UTF-8")); // 인코딩 하면 저장 가능
		Cookie cookie3 = new Cookie("age","45");
	
		// cookie3.setDomain(domain)
		// cookie3.setPath(uri);
		cookie3.setMaxAge(0);
		
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		response.addCookie(cookie3);
		
		pageContext.forward("readAllCookie.jsp");
	%>
</body>
</html>