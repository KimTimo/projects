<%@page import="java.sql.SQLException"%>
<%@page import="kr.green.jdbc.JDBCUtill"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.green.jdbc.vo.SampleVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
int idx = Integer.parseInt(request.getParameter("idx"));
SampleVO vo = null;
Connection conn = null;
Statement  stmt = null;
ResultSet  rs = null;
try{
	// 1. 연결
	conn = JDBCUtill.getConnection();
	// 2. 사용 : 트랜젝션 처리하기
	conn.setAutoCommit(false); // 트랜젝션 시작. JSP는 자동 commit인다. 해제
	//-----------------------------------------------------------------------
	// 이부분만 변경된다.......................................		
	String sql = "select * from sample where idx=" + idx; // SQL명령어
	stmt = conn.createStatement(); // 명령 객체 생성
	// show, select명령은 executeQuery()로 실행하고 ResultSet으로 받는다.
	rs = stmt.executeQuery(sql); // 명령을 실행하여 결과 객체 만들기
	if(rs.next()){ // 다음으로(없으면 false리턴)
		vo = new SampleVO();
		vo.setIdx(rs.getInt("idx"));
		vo.setName(rs.getString("name"));
		vo.setAge(rs.getInt("age"));
		vo.setGender(rs.getString("gender"));
	}
	//-----------------------------------------------------------------------
   conn.commit();
}catch(SQLException e){
	JDBCUtill.rollback(conn);
	e.printStackTrace();
}finally{
	JDBCUtill.close(rs);
	JDBCUtill.close(stmt);
	JDBCUtill.close(conn);
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제하기 폼</title>
</head>
<body>
	<form action="deleteOk.jsp" method="post">
		<input type="hidden" name="idx" value="<%=vo.getIdx()%>">
		이름 : <input type="text" name="name" required="required" value='<%=vo.getName() %>'> <br />
		나이 : <input type="number" name="age" required="required" value='<%=vo.getAge() %>'> <br />
		성별 : 
		<label><input type="radio" name="gender" <%=(vo.getGender().equals("M")? " checked='checked' ":"")%> value="M">남자</label> 
		<label><input type="radio" name="gender" <%=(vo.getGender().equals("F")? " checked='checked' ":"")%> value="F">여자</label>
		<br />
		<input type="submit" value="삭제하기" /> 
		<input type="button" value="목록으로" onclick="location.href='selectList.jsp'" /> 
	</form>
</body>
</html>