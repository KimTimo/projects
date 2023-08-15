<%@page import="kr.green.board.service.BoardService"%>
<%@page import="kr.green.board.vo.BoardVO"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/comm.js"></script>
<%-- ========================================================================================= --%>
<%-- 파라메터 인코딩 지정 --%>
<fmt:requestEncoding value="UTF-8"/>
<%-- POST전송이 아니면 index.jsp로 이동 --%>
<c:if test="${pageContext.request.method!='POST' }">
	<c:redirect url="index.jsp"></c:redirect>
</c:if>
<%-- 넘어온 인수 받기 --%>
<jsp:useBean id="cv" class="kr.green.board.vo.CommonVO"></jsp:useBean>
<jsp:setProperty property="*" name="cv"/>
<%-- ${cv }  --%>
<c:if test='${cv.mode=="insert" }'>
	<c:set var="title" value="새글쓰기"></c:set>	
	<jsp:useBean id="vo" class="kr.green.board.vo.BoardVO" scope="request"></jsp:useBean>
</c:if>
<c:if test='${cv.mode=="update" }'>
	<c:set var="title" value="수정하기"></c:set>	
	<%
		BoardVO vo = BoardService.getInstance().selectByIdx(cv.getIdx(), cv.isHit());
		request.setAttribute("vo", vo);
	%>
</c:if>
<c:if test='${cv.mode=="delete" }'>
	<c:set var="title" value="삭제하기"></c:set>	
	<%
		BoardVO vo = BoardService.getInstance().selectByIdx(cv.getIdx(), cv.isHit());
		request.setAttribute("vo", vo);
	%>
</c:if>
<script type="text/javascript">
	document.title = '자유게시판 ${title}'; // 제목 변경
	var mode = '${cv.mode}';
</script>
<%-- ========================================================================================= --%>
<script>
	$(function(){
		switch (mode) {
		case "insert": // 새글쓰기 이면 이름에 커서 위치 시키기
			$("#name").focus();
			break;
		case "update": // 수정이면 이름은 못고치게 읽기 전용으로 만들고 비번에  커서 위치 시키기
			$("#name").prop('readonly','readonly');
			$("#password").focus();
			break;
		case "delete": // 삭제이면 3개 읽기 전용으로 만들고  비번에  커서 위치 시키기
			$("#name").prop('readonly','readonly');
			$("#subject").prop('readonly','readonly');
			$("#content").prop('readonly','readonly');
			$("#password").focus();
			break;
		}
		
		// 폼이 전송될때 실행해라!!!
		$("#myForm").submit(function(event) {
			// 폼의 유효성을 검사한다.
			var value = $("#name").val();
			if(!value || value.trim().length==0){
				alert('이름은 반드시 입력해야 합니다.');
				$("#name").val("");
				$("#name").focus();
				return false;
			}
			var value = $("#password").val();
			if(!value || value.trim().length==0){
				alert('비밀번호는 반드시 입력해야 합니다.');
				$("#password").val("");
				$("#password").focus();
				return false;
			}
			var value = $("#subject").val();
			if(!value || value.trim().length==0){
				alert('제목은 반드시 입력해야 합니다.');
				$("#subject").val("");
				$("#subject").focus();
				return false;
			}
			var value = $("#content").val();
			if(!value || value.trim().length==0){
				alert('내용은 반드시 입력해야 합니다.');
				$("#content").val("");
				$("#content").focus();
				return false;
			}
			return true;
		});
	});
</script>
<style type="text/css">
	* { font-size: 10pt; }
	table#mainContent{width: 90%; margin: auto;}
	th {border: 1px solid gray; background-color: silver;padding: 5px; text-align: center; width: 100px;}
	td {border: 1px solid gray; padding: 5px;}
	td.title {border:none; padding: 5px; text-align: center; font-size: 18pt;}
	td.info {border:none; padding: 5px; text-align: right; }
	td.info2 {border: 0px solid gray; padding: 5px; text-align: center; }
</style>
</head>
<body>
	<form action="updateOk.jsp" method="post" id="myForm">
		<table id="mainContent">
		<tr>
			<td colspan="4" class="title">자유게시판 ${title }</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>
				<%-- 보이지 않고 넘겨여할 데이터를 hidden필드로 선언해 보자!!!  --%>
				<input type="hidden" name="idx" value="${vo.idx }">
				<input type="hidden" name="p" value="${cv.currentPage }">
				<input type="hidden" name="s" value="${cv.pageSize }">
				<input type="hidden" name="b" value="${cv.blockSize }">
				<input type="hidden" name="m" value="${cv.mode }">
				<input type="hidden" name="h" value="${cv.hit}">
				<input type="text" name="name" id="name" required="required" size="20" value="${vo.name }"/>
			</td>
			<th>비밀 번호</th>
			<td>
				<input type="password" name="password" id="password" required="required" size="20"/>
			</td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3">
				<input type="text" name="subject" id="subject" required="required" size="180" value="${vo.subject }"/>
			</td>
		</tr>
		<tr>
			<th valign="top">내용</th>
			<td colspan="3">
				<textarea name="content" id="content" cols="180" rows="20" required="required">${vo.content }</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="4" class="info">
					<input type="submit" class="btn btn-outline-success btn-sm" value="${title }">
					<c:if test='${cv.mode=="insert"}'>
						<button type="button" class="btn btn-outline-success btn-sm" 
				        onclick='SendPost("index.jsp",{"p":${cv.currentPage },"s":${cv.pageSize },"b":${cv.blockSize }},"post")'> 돌 아 가 기 </button>
					</c:if>
					<c:if test='${cv.mode=="update" or cv.mode=="delete"}'>
						<button type="button" class="btn btn-outline-success btn-sm" 
				        onclick='SendPost("view.jsp",{"p":${cv.currentPage },"s":${cv.pageSize },"b":${cv.blockSize },"idx":${cv.idx},"m":"${cv.mode}","h":false},"post")'> 돌 아 가 기 </button>
					</c:if>
			</td>
		</tr>
		</table>
	</form>
</body>
</html>