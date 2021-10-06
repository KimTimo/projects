<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
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
		// 퀴리를 가로채기 위하여 2가지가 변경된다.
		// String driverClass = "org.mariadb.jdbc.Driver";
		// String url = "jdbc:mariadb://localhost:3306/jspdb";
		
		String driverClass = "net.sf.log4jdbc.DriverSpy";
		String url = "jdbc:log4jdbc:mysql://localhost:3306/jspdb";
		
		
		String user = "jspuser";
		String password = "123456";
		Class.forName(driverClass);
		Connection conn = DriverManager.getConnection(url, user, password);
		out.println(conn + "<br>");
		
		String sql = "show tables";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()){
			do{
				out.println(rs.getString(1) + "<br>");
			}while(rs.next());
		}
		String sql2 = "select ?, ?, ?";
		PreparedStatement pstmt = conn.prepareStatement(sql2);
		pstmt.setInt(1, 34*45);
		pstmt.setString(2, "하나람");
		pstmt.setInt(3, 34*45);
		ResultSet rs2 = pstmt.executeQuery();
		if(rs2.next()){
			do{
				out.println(rs2.getString(1) + "<br>");
				out.println(rs2.getString(2) + "<br>");
				out.println(rs2.getString(3) + "<br>");
			}while(rs2.next());
		}
		conn.close();
	%>
</body>
</html>