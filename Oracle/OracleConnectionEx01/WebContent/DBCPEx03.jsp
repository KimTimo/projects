<%@page import="java.sql.PreparedStatement"%>
<%@page import="kr.green.jdbc.DBCPUtil"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
// DBCP에 연결해보자!!!
Connection conn = DBCPUtil.getConnection();
out.println("연결 성공!!! : " + conn + "<br>" );
// DB에서 날짜를 얻어와 보자!!!
String sql = "select SYSDATE, ?, ? from dual";
PreparedStatement stmt = conn.prepareStatement(sql);
stmt.setInt(1, 125*368);
stmt.setInt(2, 12/3);
ResultSet rs = stmt.executeQuery();
rs.next();
Date today = rs.getTimestamp(1);
out.println("현재 날짜 : " + today + "<br>");
int result = rs.getInt(2);
out.println("125*368 = " + result + "<br>");
result = rs.getInt(3);
out.println("12/3 = " + result + "<br>");

DBCPUtil.close(rs);
DBCPUtil.close(stmt);
DBCPUtil.close(conn);
%>
</body>
</html>