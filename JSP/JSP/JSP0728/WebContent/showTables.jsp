<%@page import="java.util.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="kr.green.dbcp.DBCPUtil"%>
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
// DB에서 테이블 목록을 가져와 보자!!!
String sql = "show tables";
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery(sql);
if(rs.next()){
	out.println("<h1>테이블 목록 </h1>");
	do{
		out.println( rs.getString(1) + "<br>");
	}while(rs.next());
}else{
	out.println("테이블 없다!!!<br>");
}

DBCPUtil.close(rs);
DBCPUtil.close(stmt);
DBCPUtil.close(conn);
%>
</body>
</html>