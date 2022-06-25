<%@page import="java.sql.SQLException"%>
<%@page import="kr.green.jdbc.JDBCUtill"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- VO로 받자!!! --%>
	<%-- 1. 객체 생성 --%>
	<jsp:useBean id="vo" class="kr.green.jdbc.vo.SampleVO"></jsp:useBean>
	<%-- 2. setter를 불러 내용 받기 --%>
	<jsp:setProperty property="*" name="vo"/>
	
	<%
	// 저장
	Connection conn = null;
	PreparedStatement pstmt = null;
	try{
		// 1. 연결
		conn = JDBCUtill.getConnection();
		// 2. 사용 : 트랜젝션 처리하기
		conn.setAutoCommit(false); // 트랜젝션 시작. JSP는 자동 commit인다. 해제
		//-----------------------------------------------------------------------
		// 여기에서 여러개의 SQL명령어 실행.....
		// 이부분만 변경된다.......................................		
		// 미완성 명령을 만든다. 바뀌어 들어갈 부분을 ?로 만든다.
		String sql = "insert into sample (name,age,gender) values (?,?,?)";
		pstmt = conn.prepareStatement(sql); // 명령어를 넘겨 명령객체를 만든다. ... 아직 미완성
		// ?를 값으로 바꿔준다.
		pstmt.setString(1, vo.getName()); // String은 ''안에 넣어준다.
		pstmt.setInt(2, vo.getAge()); // String은 ''안에 넣어준다.
		pstmt.setString(3, vo.getGender()); // String은 ''안에 넣어준다.

		int count = pstmt.executeUpdate(); // 완성된 명령을 실행하고 이때 명령을 인수로 전달하지 않는다.
		out.println(count + "개 저장 완료!!!"); // 결과를 출력
		//-----------------------------------------------------------------------
       // DB에 모두 적용
       conn.commit();
		
	   // 내용보기로 가자!!!!
	   response.sendRedirect("selectList.jsp");
	}catch(SQLException e){
		out.println("연결 실패 : " + e.getMessage() +  "<br>");
		// 여러개 sql 명령중 1개라도 에러가 있으면 모두 취소해라
		JDBCUtill.rollback(conn);
	}finally{
		// 3. 닫기 (열기의 역순으로 닫는다)
		JDBCUtill.close(pstmt);
		JDBCUtill.close(conn);
	}		
	
		
		// 이동
	%>
</body>
</html>