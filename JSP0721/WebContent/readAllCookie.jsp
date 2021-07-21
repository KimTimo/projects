<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모든 쿠키 보기</title>
</head>
<body>
	<%
		Cookie[] cookies = request.getCookies(); // 모든 쿠키를 배열로 읽는다.
		if(cookies!=null && cookies.length>0){ // 쿠키가 있다면
			for(Cookie cookie : cookies){
				// 쿠키값이 인코딩이되어 있으면 디코딩해야 보인다.
				// out.println(cookie.getName() + " : " + cookie.getValue() + "<br>");
				out.println(cookie.getName() + " : " + URLDecoder.decode(cookie.getValue(), "UTF-8") + "<br>");
			}
		}
	%>
</body>
</html>