<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="kr.green.jdbc.DBCPUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/plain; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
	// 아이디를 받아 DB에 저장되어있는 아이디들 중에 같은 아이디가 있는지 검사하여  결과에 따른 값을 출력해주면된다.
	// 개수를 세서 1 이상이면 있는 아이디이고 0이면 사용가능한 아이디이다.
	// 2. 넘어온 아이디를 받는다.
	String userid = request.getParameter("userid");
	String sql = "select count(*) as cnt from tmember  where userid='" + userid + "'";
	
	Connection conn  = DBCPUtil.getConnection();
	Statement  stmt = conn.createStatement();
	ResultSet  rs = stmt.executeQuery(sql);
	rs.next();
	// int count = rs.getInt(1);
	int count = rs.getInt("cnt");

	DBCPUtil.close(rs);
	DBCPUtil.close(stmt);
	DBCPUtil.close(conn);
	out.println(count);
%>
