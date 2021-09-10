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
<jsp:setProperty property="ip" name="vo" value="<%=request.getRemoteAddr() %>"/>

<%
	// 3. 모드 값에 따라 서비스에서 맞는 메서드를 호출해 준다.
	switch(vo.getMode()){
	case "insert" :
		MemoService.getInstance().insert(vo);
		break;
	case "update" :
		MemoService.getInstance().update(vo);
		break;
	case "delete" :
		MemoService.getInstance().delete(vo);
		break;
	}
	// 4. 다시 목록으로 간다.
	response.sendRedirect("index.jsp");
%>
</body>
</html>