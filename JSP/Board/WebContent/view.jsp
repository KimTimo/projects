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
<%--
${cv }
 --%>
<%
	BoardVO vo = BoardService.getInstance().selectByIdx(cv.getIdx(), cv.isHit());
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
		<%-- 댓글처리 시작 --%>
		<tr>
			<td style="border: none;" colspan="4">
			<hr />
			<%-- 댓글 폼 --%>
			<script type="text/javascript">
				$(function(){
					$("#commentForm").submit(function(event) {
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
						var value = $("#content").val();
						if(!value || value.trim().length==0){
							alert('내용은 반드시 입력해야 합니다.');
							 $("#content").val("");
							 $("#content").focus();
							 return false;
						}
						return true;
					});
					
					// 취소하기 버튼을 누르면 
					$("#resetBtn").click(function() {
						$("#resetBtn").css('display', 'none');
						$("#submitBtn").val(' 저 장 하 기 ');
						$("#name").val("");
						$("#password").val("");
						$("#content").val("");
						$("#idx").val("0");
						$("#mode").val("insert");
						$("#name").prop('readonly','');
						$("#content").prop('readonly','');
						$("#name").focus();
					});
				});
				// 수정하기 버튼을 누르면 
				function updateComment(idx){
					//alert(idx + "번 수정할거다.");
					$("#resetBtn").css('display', 'inline');
					$("#submitBtn").val(' 수 정 하 기 ');
					$("#name").val($('#cname'+idx).html());
					$("#password").val("");
					$("#content").val($('#ccontent'+idx).html());
					$("#idx").val(idx);
					$("#mode").val("update");
					$("#name").prop('readonly','readonly');
					$("#password").focus();
				}
				// 삭제하기 버튼을 누르면 
				function deleteComment(idx){
					//alert(idx + "번 삭제할거다.");
					$("#resetBtn").css('display', 'inline');
					$("#submitBtn").val(' 삭 제 하 기 ');
					$("#name").val($('#cname'+idx).html());
					$("#password").val("");
					$("#content").val($('#ccontent'+idx).html());
					$("#idx").val(idx);
					$("#mode").val("delete");
					$("#name").prop('readonly','readonly');
					$("#content").prop('readonly','readonly');
					$("#password").focus();
				}
				
			</script>
			<form action="commentUpdateOk.jsp" method="post" id="commentForm">
				<%-- 몇개는 숨겨서 가져가자 --%>
				<input type="hidden" name="idx" value="0" id="idx">
				<input type="hidden" name="ref" value="${vo.idx }">
				<input type="hidden" name="p" value="${cv.currentPage }">
				<input type="hidden" name="s" value="${cv.pageSize }">
				<input type="hidden" name="b" value="${cv.blockSize }">
				<input type="hidden" name="m" value="insert" id="mode">
				
				<input type="text" name="name" id="name" placeholder="이름입력" required="required" size="15" style="margin-bottom: 10px;" tabindex="1"/>
				<input type="password" name="password" id="password" placeholder="비번입력" required="required" size="15" tabindex="2"/> 
				<br />
				<textarea name="content" id="content" cols="180" rows="4" placeholder="내용입력" tabindex="3"  style="height: 80px;line-height: 20px;"></textarea>
				<input type="submit" value=" 저 장 하 기 " id="submitBtn" class="btn btn-outline-success btn-sm" tabindex="4" />
				<input type="button" value=" 취 소 하 기 " id="resetBtn" class="btn btn-outline-success btn-sm" tabindex="5" style="display: none;"/>
			</form>
			<hr />
			<%-- 댓글 목록 --%>
			<c:if test="${empty vo.list }">
				<div style="border: 1px solid gray; margin: 0px; margin-bottom: 5px; padding:5px">
					<div style="border: 1px solid gray;   padding:5px; background-color: silver; text-align: center;">
					등록된 댓글이 없습니다.
					</div>
				</div>
			</c:if>
			<c:if test="${not empty vo.list }">
				<c:forEach var="comment" items="${vo.list }">
					<div style="border: 1px solid gray; margin: 0px; margin-bottom: 5px; padding:5px">
						<div style="border: 1px solid gray;   padding:5px; background-color: silver;margin-bottom: 10px;">
							<b><span id="cname${comment.idx }">${comment.name }</span></b> 님이 
							<b><span>${comment.regDate }</span></b> 에 
							<b><span>${comment.ip }</span></b> 에서 남긴글
							<button type="button" class="btn btn-outline-success btn-sm" 
			        		onclick='updateComment(${comment.idx})'>수정</button>
							<button type="button" class="btn btn-outline-success btn-sm" 
			        		onclick='deleteComment(${comment.idx})'>삭제</button>
						</div>
						<pre  id="ccontent${comment.idx }">${comment.content }</pre>
					</div>
				</c:forEach>
			</c:if>
			
			</td>
		</tr>		
		<%-- 댓글처리 종료 --%>
		</table>
</body>
</html>