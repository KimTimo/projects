<%@page import="java.sql.PreparedStatement"%>
<%@page import="kr.green.jdbc.DBCPUtil"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
String sql = "select * from guestbook order by idx desc";
PreparedStatement stmt = conn.prepareStatement(sql);
ResultSet rs = stmt.executeQuery();

if(rs.next()){
	do{
		out.println(rs.getInt("idx") + ". ");
		out.println(rs.getString("name") + " : ");
		out.println(rs.getString("content"));
		out.println("<br/>");
	}while(rs.next());
}

DBCPUtil.close(rs);
DBCPUtil.close(stmt);
DBCPUtil.close(conn);
%>
</body>
</html>