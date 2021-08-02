<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="org.apache.log4j.BasicConfigurator"%>
<%@page import="org.apache.log4j.Logger"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script   src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
<script>
   $(function(){
      
   });
</script>
</head>
<body>
    <%! static Logger logger = Logger.getLogger("logEx01.jsp"); %>
    <%
        //BasicConfigurator.configure();
        logger.debug("이놈은 어디에 찍힐까?");
        out.println("<h1>나는 어디에 찍힐까?</h1>");
    %>

</body>
</html>