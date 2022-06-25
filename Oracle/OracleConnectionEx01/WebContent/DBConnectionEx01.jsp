<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MariaDB 연결하기</title>
</head>
<body>
<%
	// 1. 드라이버 클래스를 로드한다.
	// 드라이버 이름은 DBMS회사 홈페이지에서 알려 줍니다.
	String driverName = "oracle.jdbc.driver.OracleDriver";
	Class.forName(driverName);
	// 2. 준비   // jdbc:mariadb://서버아이피:포트번호/디비명
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "jspuser";
	String password = "123456";

	Connection conn = null;
	try{
		// 3. 연결
		conn = DriverManager.getConnection(url, user, password);
		out.println("연결 성공 : " + conn + "<br>");
		
		// 4. 사용
		DatabaseMetaData meta = conn.getMetaData();
        String name = meta.getDatabaseProductName(); 
        String version = meta.getDatabaseProductVersion();
        out.println("database.name=" + name  + "<br>");
        out.println("database.version=" + version   + "<br>");

	}catch(SQLException e){
		out.println("연결 실패 : " + e.getMessage() +  "<br>");
	}finally{
		// 5. 닫기
		try{
			if(conn!=null) conn.close();
		}catch(SQLException e){
			out.println("닫기 실패 : " + e.getMessage() +  "<br>");
		}
	}
%>
</body>
</html>