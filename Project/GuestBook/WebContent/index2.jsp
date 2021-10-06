<%@page import="kr.green.guestbook.service.GuestBookServiceImpl"%>
<%@page import="kr.green.guestbook.service.GuestBookService"%>
<%@page import="kr.green.guestbook.vo.GuestBookVO"%>
<%@page import="kr.green.guestbook.vo.PagingVO"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- JSTL을 사용하겠다!!!! --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 목록보기</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="./js/commons.js"></script>
<script>
	$(function(){
		
	});
</script>
<style type="text/css">
	div#content {width: 90%; margin: auto;}
	div.title {font-size: 18pt; text-align: center;}
	div.count {font-size: 10pt; text-align: right;}
	div.no_item {font-size: 10pt; text-align: center; border: 1px solid gray; padding:5px;margin-bottom: 5px; }
	div.item {font-size: 10pt; border: 1px solid gray; padding:5px;margin-bottom: 5px; }
	div.item_title {font-size: 11pt; font-weight: bolder; border: 1px solid gray; padding:5px;margin-bottom: 5px; background-color: silver; }
</style>
</head>
<body>
	<%-- currentPage, pageSize, blockSize를 받자!! --%>
	<jsp:useBean id="cv" class="kr.green.guestbook.vo.CommonVO" scope="request"></jsp:useBean>
	<jsp:setProperty property="*" name="cv"/>
	<%-- 글목록을 읽어오자!!! --%>
	<%
		PagingVO<GuestBookVO> pv = GuestBookServiceImpl.getInstance().selectList(cv.getCurrentPage(), cv.getPageSize(), cv.getBlockSize());
		request.setAttribute("pv", pv);
	%>
	<div id="content">
		<div class="title">방명록 목록보기</div>
		<div class="count">${pv.pageInfo }</div>
		<c:if test="${pv.totalCount gt 0 }">
			<c:forEach var="vo" items="${pv.list }">
				<div class="item">
					<div class="item_title">
						<c:out value="${vo.name }"></c:out>님이
						${vo.ip }에서 
						<fmt:formatDate value="${vo.regDate }" pattern="yyyy-MM-dd hh:mm:ss"/>에 남긴글
					<button type="button" class="btn btn-outline-success btn-sm" 
					        onclick='SendPost("update.jsp",{"p":${pv.currentPage },"s":${pv.pageSize },"b":${pv.blockSize },"idx":${vo.idx },"m":"update"},"post")'>수정</button>
					<button type="button" class="btn btn-outline-success btn-sm" 
						        onclick='SendPost("update.jsp",{"p":${pv.currentPage },"s":${pv.pageSize },"b":${pv.blockSize },"idx":${vo.idx },"m":"delete"},"post")'>삭제</button>
					</div>
					<pre> <c:out value="${vo.content }"></c:out> </pre>
				</div>
			</c:forEach>
			<div>
			${pv.pageList }
			</div>
		</c:if>
		<c:if test="${pv.totalCount eq 0 }">
			<div class="no_item">등록된 글이 없습니다.</div>
		</c:if>
		<%-- 글쓰기 버튼을 출력하자 :   sendPost('hanjaList.jsp',{"p":1,"s":10,"b":10},"post"); --%>
		<div class="count">
			<button type="button" class="btn btn-outline-success btn-sm" 
			        onclick='SendPost("update.jsp",{"p":${pv.currentPage },"s":${pv.pageSize },"b":${pv.blockSize },"idx":${vo.idx },"m":"insert"},"post")'>글쓰기</button>
		</div>
	</div>
</body>
</html>