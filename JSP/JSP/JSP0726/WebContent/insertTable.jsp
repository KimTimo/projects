<%@page import="java.util.Random"%>
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
    	// 2. 사용 : 트랜젝션 처리하기
    	conn.setAutoCommit(false); // 트랜젝션 시작. JSP는 자동 commit된다. 해제
    	// -----------------------------------------------------------
    	// 여기에서 여러개의 SQL명령어 실행
    	// 이 부분만 변경된다.................................
    	String name = "한사람";
    	int age = 26;
    	String gender = "M";
    	String sql = "insert into sample(name, age, gender) values(";
    	sql += "'" + name + "',";
    	sql += new Random().nextInt(101) + ",";
    	sql += "'" + (new Random().nextInt(2) == 1 ? "M":"F") + "')";              // 명령어 만들고
    	
    	out.println(sql + "<br>");
    	
    	stmt = conn.createStatement();           // 명령객체 만들고
    	
    	int count = stmt.executeUpdate(sql);     // 명령을 실행하고
    	
    	out.println(count + "개 저장완료!!");    // 결과를 출력
    	
    	// -----------------------------------------------------------
    	// DB에 모두 적용
    	conn.commit();
    }catch(SQLException e){
    	out.println("연결 실패 : " + e.getMessage() + "<br>");
    	// 여러개  sql 명령 중 1개라도 에러가 있으면 모두 취소해라.
    	JDBCUtill.rollback(conn);
    }finally{
    	// 3. 닫기(열기의 역순으로 닫는다.)
    	JDBCUtill.close(rs);
    	JDBCUtill.close(stmt);
    	JDBCUtill.close(conn);
    }
%>

</body>
</html>