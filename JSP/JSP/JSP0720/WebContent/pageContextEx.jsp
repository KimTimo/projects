<%@page import="java.io.Writer"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pageContext객체</title>
</head>
<body>
    <%
        PrintWriter pw = response.getWriter();
        out.println("하하하하<br>");
        pw.println("하하하하<br>");
        if(pw.equals(out)){
        	out.println("같다!!!<br>");
        }else{
        	out.println("다르다!!!<br>");
        }
        out.println((out instanceof JspWriter) + "<br>");
        out.println((pw instanceof PrintWriter) + "<br>");
        out.println((out instanceof Writer) + "<br>");
        out.println((pw instanceof Writer) + "<br>");
    %>
</body>
</html>