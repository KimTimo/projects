<%@page import="kr.green.jdbc.service.SampleServiceImpl"%>
<%@page import="java.sql.SQLException"%>
<%@page import="kr.green.jdbc.JDBCUtil"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		// POST방식의 전송이 아니라면 목록으로 보낸다.
		if(!request.getMethod().equals("POST")){
			response.sendRedirect("selectList.jsp");
			return;
		}
	
	%>
	<%-- VO로 받자!!! --%>
	<%-- 1. 객체 생성 --%>
	<jsp:useBean id="vo" class="kr.green.jdbc.vo.SampleVO"></jsp:useBean>
	<%-- 2. setter를 불러 내용 받기 --%>
	<jsp:setProperty property="*" name="vo"/>
	
	<%
	// mode값에따라 적당한 서비스를 호출한다.
	// 유효성 검사를 해서 데이터가 유효하면  
	if(vo!=null){
		switch(mode){
		case "i":
			SampleServiceImpl.getInstance().insert(vo);
			break;
		case "u":
			SampleServiceImpl.getInstance().update(vo);
			break;
		case "d":
			SampleServiceImpl.getInstance().delete(vo);
			break;
		}
	}
	// 이동
	response.sendRedirect("selectList.jsp");

	%>
</body>
</html>