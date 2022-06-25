<%@page import="kr.green.board.service.FreeBoardServiceImpl"%>
<%@page import="kr.green.board.vo.FreeBoardVO"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 내용보기</title>
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
${cv }
<%
	FreeBoardVO vo = FreeBoardServiceImpl.getInstance().selectByIdx(cv.getIdx(), cv.isHit());
	request.setAttribute("vo", vo);
%>
<script>
	$(function(){

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
		<table id="mainContent">
		<tr>
			<td colspan="4" class="title">자유게시판 내용보기</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>
				<c:out value="${vo.name }"></c:out>
			</td>
			<th>작성일</th>
			<td>
				<fmt:formatDate value="${vo.regDate }" type="both" dateStyle="long" timeStyle="long"/>
			</td>
		</tr>
		<tr>
			<th>아이피</th>
			<td>
				${vo.ip }
			</td>
			<th>조회수</th>
			<td>
				${vo.hit }
			</td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3">
				<c:out value="${vo.subject }"></c:out>
			</td>
		</tr>
		<tr>
			<th valign="top">내용</th>
			<td colspan="3">
				<pre><c:out value="${vo.content }"></c:out></pre>
			</td>
		</tr>
		<tr>
			<td colspan="4" class="info">
					<button type="button" class="btn btn-outline-success btn-sm" 
			        onclick='SendPost("index.jsp",{"p":${cv.currentPage },"s":${cv.pageSize },"b":${cv.blockSize }},"post")'> 목록으로 </button>
					<button type="button" class="btn btn-outline-success btn-sm" 
			        onclick='SendPost("update.jsp",{"p":${cv.currentPage },"s":${cv.pageSize },"b":${cv.blockSize }, "idx":${cv.idx},"m":"update","h":false},"post")'> 수정하기 </button>
					<button type="button" class="btn btn-outline-success btn-sm" 
			        onclick='SendPost("update.jsp",{"p":${cv.currentPage },"s":${cv.pageSize },"b":${cv.blockSize }, "idx":${cv.idx},"m":"delete","h":false},"post")'> 삭제하기 </button>
			</td>
		</tr>
		</table>
	</form>
</body>
</html>