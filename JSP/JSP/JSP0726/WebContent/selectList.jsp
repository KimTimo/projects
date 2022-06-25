<%@page import="java.sql.SQLException"%>
<%@page import="kr.green.jdbc.JDBCUtill"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.green.jdbc.vo.SampleVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
List<SampleVO> list = new ArrayList<>();
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
	String sql = "select * from sample order by idx desc"; // SQL명령어
	stmt = conn.createStatement(); // 명령 객체 생성
	// show, select명령은 executeQuery()로 실행하고 ResultSet으로 받는다.
	rs = stmt.executeQuery(sql); // 명령을 실행하여 결과 객체 만들기
	if(rs.next()){ // 다음으로(없으면 false리턴)
		do{
			SampleVO vo = new SampleVO();
			vo.setIdx(rs.getInt("idx"));
			vo.setName(rs.getString("name"));
			vo.setAge(rs.getInt("age"));
			vo.setGender(rs.getString("gender"));
			list.add(vo);
		}while(rs.next()); // 끝까지 반복
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
<title>목록보기</title>
<style type="text/css">
	table { width: 700px; margin: auto; padding: 10px; border: none;}
	th { padding: 5px; border: 1px solid gray; background-color: silver;}
	td { padding: 5px; border: 1px solid gray; background-color: white;}
	.title { text-align: center; font-size: 18pt; border: none;}
	.sub-title { text-align: right; font-size: 10pt; border: none;}
	.sub-title2 { text-align: center; font-size: 10pt; border: 1px solid gray;}
</style>
</head>
<body>
	<table>
		<tr>
			<td colspan="5" class="title"> 목록 보기</td>
		</tr>
		<tr>
			<td colspan="5" class="sub-title"> 전체 : <%=list.size() %>개</td>
		</tr>
		<tr>
			<th>idx</th>
			<th>name</th>
			<th>age</th>
			<th>gender</th>
			<th>Edit/Delete</th>
		</tr>
		<% if(list.size()>0){ %>
		<% 		for(SampleVO vo : list ){ %>
			<tr align="center">
				<td><%=vo.getIdx() %></td>
				<td><%=vo.getName() %></td>
				<td><%=vo.getAge() %></td>
				<td><%=vo.getGender().equals("M") ? "남":"여" %></td>
				<td>
				[<a href="editForm.jsp?idx=<%=vo.getIdx()%>">Edit</a>]
				[<a href="deleteForm.jsp?idx=<%=vo.getIdx()%>">Del</a>]
				</td>
			</tr>
		<% 		} 
		   }else {
		%>
		<tr>
			<td colspan="5" class="sub-title2">데이터가 없습니다.</td>
		</tr>
		<% } %>
		<tr>
			<td colspan="5" class="sub-title">
			<a href="insertForm3.jsp">글쓰기</a>
			</td>
		</tr>
	</table>
</body>
</html>