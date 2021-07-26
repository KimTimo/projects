<%@page import="kr.green.jdbc.JDBCUtill"%>
<%@page import="java.sql.DatabaseMetaData"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MariaDB 연결하기</title>
</head>
<body>
<%
    Connection conn = null;
    try{
    	// 1. 연결
    	conn = JDBCUtill.getConnection();
    	out.println("연결성공 : " + conn + "<br>");
    	// 2. 사용
    	DatabaseMetaData meta = conn.getMetaData();
    	String name = meta.getDatabaseProductName();
    	String version = meta.getDatabaseProductVersion();
    	
    	if(version != null && version.indexOf('\n') != -1){
    		version = version.replace('\n', ' ');
    	}
    	out.println("database.name=" + name + "<br>");
    	out.println("database.version=" + version + "<br>");
    	
    }catch(SQLException e){
    	out.println("연결 실패 : " + e.getMessage() + "<br>");
    }finally{
    	// 3. 닫기
    	JDBCUtill.close(conn);
    }
%>

</body>
</html>