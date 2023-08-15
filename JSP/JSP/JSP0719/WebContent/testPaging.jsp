<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="kr.green.memo.vo.PagingVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int currentPage = 1;
		int pageSize = 10;
		int blockSize = 10;
		int totalCount = 456;
		// 넘어온 값을 받는다.
		try{
			currentPage = Integer.parseInt(request.getParameter("p"));
		}catch(Exception e) { ; }
		
		try{
			pageSize = Integer.parseInt(request.getParameter("s"));
		}catch(Exception e) { ; }
		
		try{
			blockSize = Integer.parseInt(request.getParameter("b"));
		}catch(Exception e) { ; }
	
		// 글 넣어주기
		List<String> list = new ArrayList<>();
		for(int i=0;i<totalCount;i++) list.add("글 " + (i+1));
	
		PagingVO<String> pagingVO = new PagingVO<>(totalCount, currentPage, pageSize, blockSize);
		pagingVO.setList(list);
		
		// out.println(pagingVO + "<br>");
		out.println(pagingVO.getPageInfo() + "<br>");
		out.println(pagingVO.getPageList() + "<br>");
	
	%>
</body>
</html>