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
<%-- 넘어오는 현재페이지, 페이지사이즈, 블록 사이즈를 받아야 한다. --%>
<jsp:useBean id="paramVO" class="kr.green.memo.vo.ParamVO"></jsp:useBean>
<jsp:setProperty property="*" name="paramVO"/>

<%-- 2. 데이터를 받고 부족한 데이터를 채우기 --%>
<jsp:useBean id="vo" class="kr.green.memo.vo.MemoVO"/>
<jsp:setProperty property="*" name="vo"/>
<jsp:setProperty property="ip" name="vo" value="<%=request.getRemoteAddr() %>"/>

<%
	// 3. 모드 값에 따라 서비스에서 맞는 메서드를 호출해 준다.
	int currentPage = paramVO.getCurrentPage(); // 수정이나 삭제시는 현재 페이지에 머물러 있어야 한다.
	switch(vo.getMode()){
	case "insert":
		MemoService.getInstance().insert(vo);
		currentPage = 1; // 새글을 쓰고나면 무조건 1페이지로 간다.
		break;
	case "update":
		MemoService.getInstance().update(vo);
		break;
	case "delete":
		MemoService.getInstance().delete(vo);
		break;
	}
	// 4. 다시 목록으로 간다.
	response.sendRedirect("index.jsp?p=" + currentPage + "&s=" + paramVO.getPageSize() + "&b=" + paramVO.getBlockSize());
%>
</body>
</html>