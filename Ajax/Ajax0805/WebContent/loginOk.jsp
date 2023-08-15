<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="kr.green.jdbc.DBCPUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="application/json; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
	if(!request.getMethod().equals("POST")){
		out.println("{\"result\": 0}");
		return;
	}
	// 데이터를 받자
	String userid = request.getParameter("userid");
	String password = request.getParameter("password");
	// 로그인 처리를 해준다.
	Connection conn = DBCPUtil.getConnection();
	// 해당 아이디의 데이터를 가져온다.
	// 암호에 다음과 같이 입력하면 [qqq' or '1'='1] 전체 조건은 무조건 참입니다. 이런것을 막아야 한다.
	// String sql = "select * from tmember where userid='" + userid + "' and password = '" + password + "'";
	String sql = "select * from tmember where userid='" + userid + "'";
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
	if(rs.next()){ // 있으면 아이디 존재
		String id = rs.getString("userid");
		String pwd = rs.getString("password");
		String nickname = rs.getString("nickname");
		int  point = rs.getInt("point");
		// 비번이 일치하는지 다시 검사한다.
		// 아이디, 닉네임, 비번(암호화)을 비교하여 일치하는 개수를 구한다.
		sql = "select count(*) from tmember where userid='" + userid + "'";
		sql += " and nickname='" + nickname + "' and password=password('"+password+"')";
		Statement stmt2 = conn.createStatement();
		ResultSet rs2 = stmt2.executeQuery(sql);
		rs2.next();
		int count = rs2.getInt(1);
		String result = "";
		if(count==1){
			// 로그인 성공
			result = "{\"result\":1,\"nickname\":\"" +nickname+ "\",\"userid\":\""+userid+ "\",\"point\":"+point+"}";
			// System.out.println(result);
			session.setAttribute("mv", "로그인성공!!!"); // 원래는 vo 객체를 저장해야 한다.
		}else{
			// 로그인 실패
			result = "{\"result\":0}";
		}
		DBCPUtil.close(rs2);
		DBCPUtil.close(stmt2);
		DBCPUtil.close(conn);		
		out.println(result);
	}else{ // 없으면 아이디 없다.
		out.println("{\"result\": 0}");
	}
	DBCPUtil.close(rs);
	DBCPUtil.close(stmt);
	DBCPUtil.close(conn);
%>