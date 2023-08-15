<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>헤더 정보를 읽어보자</title>
</head>
<body>
    <h1>모든 헤더 정보를 읽어보자</h1>
    <%
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
        	String headerName = headerNames.nextElement();
        	String headerValue = request.getHeader(headerName);
        	out.println(headerName + " : " + headerValue + "<br>");
        }
    %>
    <hr />
    <%
        headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
        	String headerName = headerNames.nextElement();
        	Enumeration<String> em = request.getHeaders(headerName);
        	String headerValue = request.getHeader(headerName);
        	out.println(headerName + "<br>");
        	while(em.hasMoreElements()){
        		headerValue = em.nextElement();
        		out.println(headerValue + "<br>");
        	}
        	out.println("<hr>");
        }
        out.println(request.getHeader("user-agent").contains("Trident")? "IE로 접속" : "IE아님");
    %>
    

</body>
</html>