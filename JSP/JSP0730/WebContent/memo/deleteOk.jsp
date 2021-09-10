<%@page import="kr.green.memo.service.MemoService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8"); // web.xml에 인코딩 필터를 추가 했으면 생략 가능
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 1. POST전송이 아니면 목록으로 보내기 --%>
<%
	if(!request.getMethod().equals("POST")){
		response.sendRedirect("index.jsp");
		return;
	}
%>

<%-- 2. 데이터를 받고 부족한 데이터를 채우기 --%>
<jsp:useBean id="vo" class="kr.green.memo.vo.MemoVO"/>
<jsp:setProperty property="*" name="vo"/>
<%
	// 3. 서비스를 호출하여 삭제하고
	MemoService.getInstance().delete(vo);
	// 4. 다시 목록으로 간다.
	response.sendRedirect("index.jsp");
%>
</body>
</html>