<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
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
    Statement stmt = null;
    ResultSet rs = null;
    try{
    	// 1. 연결
    	conn = JDBCUtill.getConnection();
    	// 2. 사용
    	out.println("<h1>테이블 목록보기</h1>");
    	String sql = "show tables";
    	stmt = conn.createStatement();
    	rs = stmt.executeQuery(sql);
    	if(rs.next()){
    		do{
    		out.println(rs.getString(1) + "<br>");
    		}while(rs.next());
    	}else{
    		out.println("테이블이 존재하지 않습니다.<br>");
    	}
    }catch(SQLException e){
    	out.println("연결 실패 : " + e.getMessage() + "<br>");
    }finally{
    	// 3. 닫기
    	JDBCUtill.close(rs);
    	JDBCUtill.close(stmt);
    	JDBCUtill.close(conn);
    }
%>

</body>
</html>