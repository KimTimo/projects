<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DBCP를 이용한 켄넥션 사용</title>
</head>
<body>
<%
Context initContext = new InitialContext();
Context envContext  = (Context)initContext.lookup("java:/comp/env");
DataSource ds = (DataSource)envContext.lookup("jdbc/TestDB");
Connection conn = ds.getConnection(); // DataSource로부터 컨넥션얻기
// 사용하기
out.println("연결 성공 : " + conn + "<br>");

// 반납하기
conn.close();
%>
</body>
</html>