<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Types"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.CallableStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여기에 제목</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/comm.js"></script>
<script>
	$(function() {

	});
</script>
</head>
<body>
	<%
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver"); // 오라클 드라이버
	} catch (Exception e) {
		System.err.println(e);
		System.exit(1);
	}

	Connection conn = null;
	CallableStatement cstmt = null; // 프로시져를 호출하기 위한 명령 객체!!!!

	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String id = "hr";
	String pass = "123456";
	String query = null;

	try {
		conn = DriverManager.getConnection(url, id, pass);
	} catch (Exception e) {
		System.err.println(e);
		System.exit(1);
	}
	query = "{call myproc(?,?) }"; // 프로시저 호출 단계
	try {
		cstmt = conn.prepareCall(query); // 명령생성 -- =========이부분
		cstmt.setString(1, "네사람"); // 첫번째 인수 지정
		cstmt.registerOutParameter(2, Types.INTEGER); //Types 를 이용하여 out 객체 타입 결정해줌. 두번째 변수 지정  =========이부분
		cstmt.executeQuery(); // 쿼리 실행
		int age = cstmt.getInt(2); // 읽기
		out.println("나이는 : " + age); // 출력
		cstmt.close();
		conn.close();
	} catch (SQLException e) {
		System.err.println(e);
	}
	%>
</body>
</html>
