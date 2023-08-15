<%@page import="kr.green.board.vo.PagingVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<script type="text/javascript" src="./js/commons.js"></script>
</head>
<body>
<jsp:useBean id="cv" class="kr.green.board.vo.CommonVO"></jsp:useBean>
<jsp:setProperty property="*" name="cv"/>


<%
	System.out.println(cv);
	// 전체글을  378개로 가정하자!!!
	int totalCount = 378;
	// 페이지 계산
	List<String> list = new ArrayList<>();
	PagingVO<String> pagingVO = new PagingVO<>(cv.getCurrentPage(), cv.getPageSize(),cv.getBlockSize(), totalCount);
	for(int i=pagingVO.getStartNo();i<=pagingVO.getEndNo();i++) list.add((pagingVO.getTotalCount()-i) + "번째 글입니다.");
	pagingVO.setList(list);
	
	out.print(pagingVO.getPageInfo());
%>
<%-- 몇개씩 보기를 만들어 보자!!!! 시작 --%>
<script>
	$(function(){
		$("#listCount").change(function(){
			// alert($(this).val());
			var pageSize = $(this).val();
			SendPost("?", {"p":<%=cv.getCurrentPage()%>,"s":pageSize,"b":<%=cv.getBlockSize()%>});
		});
	});
</script>
<select id="listCount">
	<option value="5" <%=(cv.getPageSize()==5   ? " selected='selected' ": "")%>>5개씩 보기</option>
	<option value="10" <%=(cv.getPageSize()==10 ? " selected='selected' ": "")%>>10개씩 보기</option>
	<option value="20" <%=(cv.getPageSize()==20 ? " selected='selected' ": "")%>>20개씩 보기</option>
	<option value="50" <%=(cv.getPageSize()==50 ? " selected='selected' ": "")%>>50개씩 보기</option>
</select>
<%-- 몇개씩 보기를 만들어 보자!!!! 종료 --%>
<%	
	out.print("<br><hr>");
	for(String line : list){
		out.println(line + "<br/>");
	}
	out.print("<br><hr>");
	out.print(pagingVO.getPageList());
%>

</body>
</html>