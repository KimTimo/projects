<%@page import="kr.green.dbcp.DBCPUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DBCP를 이용한 켄넥션 사용</title>
</head>
<body>
<%
Connection conn = DBCPUtil.getConnection();

// 사용하기
out.println("연결 성공 : " + conn + "<br>");

// 반납하기
DBCPUtil.close(conn);
%>
</body>
</html>