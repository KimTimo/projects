<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.green.memo.vo.PagingVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="paramVO" class="kr.green.memo.vo.ParamVO"></jsp:useBean>
<jsp:setProperty property="*" name="paramVO"/>
<%
	System.out.println("받은 내용 : " + paramVO);
	PagingVO<String> pagingVO = new PagingVO<>(paramVO.getCurrentPage(), paramVO.getPageSize(), paramVO.getBlockSize(),2456);
	List<String> list = new ArrayList<>();
	for(int i=pagingVO.getStartNo();i<=pagingVO.getEndNo();i++ ){
		list.add("글번호 " + i);
	}
	pagingVO.setList(list);
	out.println(pagingVO.getPageInfo() + "<br>");
	for(String msg : pagingVO.getList()){
		out.println(msg + "<br>");
	}
	out.println(pagingVO.getPageList() + "<br>");
%>
</body>
</html>