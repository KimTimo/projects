<%@page import="kr.green.guestbook.service.GuestBookService"%>
<%@page import="kr.green.guestbook.vo.GuestBookVO"%>
<%@page import="kr.green.guestbook.vo.PagingVO"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>허접한 방명록</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/comm.js"></script>
<style type="text/css">
	div#title{width: 80%; padding: 5px; font-size: 18pt; text-align: center; border: none; margin: auto;}
	div#info{width: 80%; padding: 5px; text-align: right; border: none;  margin: auto;}
	div#empty{width: 80%; padding: 5px; text-align: center; border: 1px solid gray; margin: auto;}
	div#pagelist{width: 80%; padding: 5px; text-align: center; border: none; margin: auto;}
	div.content{width: 80%; padding: 5px; border: 1px solid gray;  margin: auto; margin-bottom: 15px;}
	div.content-header{padding: 5px; border: 1px solid gray;margin-bottom: 5px; background-color: silver; margin: auto;}
</style>
<script>
	$(function(){
		
	});
	
	function editForm(idx){
		// 폼의 값을 채워주고
		$("#idx").val($("#idx"+idx).html());
		$("#name").val($("#name"+idx).html());
		$("#content").val($("#content"+idx).html());

		// mode 값을 "update"로 변경한다.
		$("#mode").val("update")
		// 버튼의 제목을 "수정하기"로 변경
		$("#submitBtn").val("수정하기")
		// 취소 버튼을 보이게 한다.
		$("#cancelBtn").css('display','inline');
		$("#password").focus();
	}
	function deleteForm(idx){
		// 폼의 값을 채워주고
		$("#idx").val($("#idx"+idx).html());
		$("#name").val($("#name"+idx).html());
		$("#content").val($("#content"+idx).html());
		
		// 폼의 액션 속성을 변경
		// $("#updateForm").attr('action','deleteOk.jsp');
		// mode 값을 "delete"로 변경한다.
		$("#mode").val("delete")
		
		// 버튼의 제목을 "삭제하기"로 변경
		$("#submitBtn").val("삭제하기")
		// 취소 버튼을 보이게 한다.
		$("#cancelBtn").css('display','inline');
		$("#password").focus();
	}
	function resetForm(){
		// 폼의 값을 비워주고
		$("#idx").val(0);
		$("#name").val("");
		$("#content").val("");
		
		// 폼의 액션 속성을 변경
		// $("#updateForm").attr('action','insertOk.jsp');
		// mode 값을 "insert"로 변경한다.
		$("#mode").val("insert")
		
		// 버튼의 제목을 "저장하기"로 변경
		$("#submitBtn").val("저장하기")
		// 취소 버튼을 숨긴다.
		$("#cancelBtn").css('display','none');
		$("#name").focus();
	}
</script>
</head>
<body>
	<%-- 넘어온 데이터들을 받자 --%>
	<jsp:useBean id="cv" class="kr.green.guestbook.vo.CommVO"></jsp:useBean>
	<jsp:setProperty property="*" name="cv"/>
	<script>
		$(function(){
			$("#psize").change(function(){
				// alert($(this).val());
				SendPost("index.jsp", {"p":${cv.currentPage},"s":$(this).val(),"b":${cv.blockSize}});
			});
		});
	</script>
	<%-- 서비스클래스를 호출하여 데이터를 가져오자 --%>
	<%
		PagingVO<GuestBookVO> pagingVO = GuestBookService.getInstance().selectList(cv.getCurrentPage(), cv.getPageSize(), cv.getBlockSize());
		request.setAttribute("pv", pagingVO);
	%>
	<div id="title">허접한 방명록</div>
	<div id="info">
		${pv.pageInfo }
		<select id="psize">
			<option value="5"   ${cv.pageSize==5 ? '  selected="selected" ' : '' }>  5개씩 보기</option>
			<option value="10"  ${cv.pageSize==10 ? ' selected="selected" ' : '' }> 10개씩 보기</option>
			<option value="20"  ${cv.pageSize==20 ? ' selected="selected" ' : '' }> 20개씩 보기</option>
			<option value="50"  ${cv.pageSize==50 ? ' selected="selected" ' : '' }> 50개씩 보기</option>
		</select>
	</div>
	<%-- 글쓰기 폼을 달아보자 --%>
	<div class="content" style="border: none;">
		<hr />
		<form action="updateOk.jsp" method="post" id="updateForm">
			<%-- ------------------------------------------------------------------------------------- --%>			
			<%-- 저장/수정/삭제시 돌아올때는 현재 페이지에 머물러 있어야 한다. 그렇다면 넘겨줘야 한다. --%>
			<input type="hidden" name="p" value="${pv.currentPage }" />
			<input type="hidden" name="s" value="${pv.pageSize }" />
			<input type="hidden" name="b" value="${pv.blockSize }" />
			<%-- ------------------------------------------------------------------------------------- --%>			

			<input type="hidden" id="idx" name="idx" value="0" />
			<input type="hidden" id="mode" name="mode" value="insert" />
			<input type="text" size="15" placeholder="이름입력" name="name" id="name" required="required">
			<input type="password" size="15" placeholder="암호입력" name="password" id="password" required="required">
			<br />
			<textarea name="content" id="content" cols="150" rows="10" style="margin-bottom: 10px;" placeholder="내용입력" required="required"></textarea>
			<br />
			<input type="submit" id="submitBtn" value="저장하기"  class="btn btn-success btn-sm">
			<input type="button" id="cancelBtn" value="취소하기" style="display: none;" onclick="resetForm()"  class="btn btn-success btn-sm"/>
		</form>
		<hr />
	</div>
	
	<%-- 글이 없다면 --%>
	<c:if test="${empty pv.list }">
		<div id="empty">등록된 글이 없습니다.</div>
	</c:if>
	<%-- 글이 있다면 --%>
	<c:if test="${not empty pv.list }">
		<c:forEach var="vo" items="${pv.list }">
			<div class="content">
				<div class="content-header">
				<strong id="idx${vo.idx }"><c:out value="${vo.idx }"></c:out></strong>. 
				<strong id="name${vo.idx }"><c:out value="${vo.name }"></c:out></strong>님이
				<strong>${vo.ip }</strong>에서
				<strong><fmt:formatDate value="${vo.regDate }" pattern="yyyy-MM-dd hh:mm:ss"/></strong>에 남긴 흔적...

				<a href="javascript:editForm(${vo.idx })" class="btn btn-success btn-sm">수정</a> 
				<a href="javascript:deleteForm(${vo.idx })" class="btn btn-success btn-sm">삭제</a>
				</div>
				<pre id="content${vo.idx }"><c:out value="${vo.content }"></c:out></pre>
			</div>
		</c:forEach>
		<%-- 페이지 이동 달기 --%>
		<div id="pagelist">${pv.pageList }</div>
	</c:if>
</body>
</html>