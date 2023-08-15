<%@page import="java.util.List"%>
<%@page import="kr.green.memo.vo.MemoVO"%>
<%@page import="kr.green.memo.dao.MemoDAO"%>
<%@page import="kr.green.dbcp.DBCPUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Connection conn = DBCPUtil.getConnection();
	MemoDAO dao = MemoDAO.getInstance();
	out.println("전체 : " +  dao.getCount(conn)  + "개<br>");
	// 저장 테스트
	MemoVO memoVO = new MemoVO();
	memoVO.setName("한사람");
	memoVO.setPassword("1234");
	memoVO.setContent("와 일빠다~~~~");
	memoVO.setIp(request.getRemoteAddr());

	int count = dao.insert(conn, memoVO); // 저장
	out.println(count + "저장 완료!!!<br>");
	out.println("전체 : " +  dao.getCount(conn)  + "개<br>");
	List<MemoVO> list = dao.selectAll(conn);
	if(list!=null){
		for(MemoVO vo : list){
			out.println(vo + "<br>");
		}
	}
	out.println("<hr>");
	
	MemoVO vo2 = dao.selectByIdx(conn, 3);
	if(vo2!=null){
		out.println(vo2 + "<br>");
	}else{
		out.println("3번없다.<br>");
	}
	out.println("<hr>");
	
	vo2 = dao.selectByIdx(conn, 100);
	if(vo2!=null){
		out.println(vo2 + "<br>");
	}else{
		out.println("100번없다.<br>");
	}

	out.println("<hr>");
	// 수정테스트!!!!
	vo2 = dao.selectByIdx(conn, 2);
	vo2.setName("바뀐이름");
	vo2.setContent("정말 바뀔까?");
	dao.update(conn, vo2); // 수정
	
	vo2 = dao.selectByIdx(conn, 2);
	if(vo2!=null){
		out.println(vo2 + "<br>");
	}else{
		out.println("100번없다.<br>");
	}
	// 삭제테스트
	count = dao.delete(conn, 4);
	out.println(count + "삭제 완료!!!<br>");
	out.println("전체 : " +  dao.getCount(conn)  + "개<br>");
	
	DBCPUtil.close(conn);
%>
</body>
</html>