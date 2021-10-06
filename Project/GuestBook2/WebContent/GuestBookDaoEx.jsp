<%@page import="java.util.List"%>
<%@page import="java.util.Random"%>
<%@page import="kr.green.guestbook.vo.GuestBookVO"%>
<%@page import="kr.green.guestbook.dao.GuestBookDAO"%>
<%@page import="kr.green.jdbc.DBCPUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	Connection conn  = DBCPUtil.getConnection();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
<script>
	$(function(){
		
	});
</script>
</head>
<body>
	전체 : <%=GuestBookDAO.getInstance().selectCount(conn) %>개 <br />
	<%
		GuestBookVO guestBookVO = GuestBookDAO.getInstance().selectByIdx(conn, 1);
		if(guestBookVO==null){
			out.println("1번글 없다. <br>");
		}else{
			out.println(guestBookVO + "<br>");
		}
	
		guestBookVO.setContent("수정 수정 수정 우리 수정교!!!!");
		int count = GuestBookDAO.getInstance().update(conn, guestBookVO);
		if(count>0){
			out.println(count + "개 수정함. <br>");
		}else{
			out.println("수정 실패<br>");
		}
		
		guestBookVO = GuestBookDAO.getInstance().selectByIdx(conn, 1);
		if(guestBookVO==null){
			out.println("1번글 없다. <br>");
		}else{
			out.println(guestBookVO + "<br>");
		}
		guestBookVO.setContent("저장 저장 저장!!!!");
		count = GuestBookDAO.getInstance().insert(conn, guestBookVO);
		if(count>0){
			out.println(count + "개 저장함. <br>");
		}else{
			out.println("저장 실패<br>");
		}
	%>
	전체 : <%=GuestBookDAO.getInstance().selectCount(conn) %>개 <br />
	<%
		int idx = new Random().nextInt(GuestBookDAO.getInstance().selectCount(conn)); // 무작위로 글번호 얻기
		count = GuestBookDAO.getInstance().delete(conn, idx);
		if(count>0){
			out.println(count + "개 삭제함. <br>");
		}else{
			out.println("삭제 실패<br>");
		}
	%>
	전체 : <%=GuestBookDAO.getInstance().selectCount(conn) %>개 <br />
	<%
		List<GuestBookVO> list = GuestBookDAO.getInstance().selectList(conn, 0, 1000);
		if(list!=null){
			for(GuestBookVO vo : list){
				out.println(vo + "<br>");
			}
		}else{
			out.println("글이 없습니다.<br>");
		}
	%>
</body>
</html>
<%
	DBCPUtil.close(conn);
%>