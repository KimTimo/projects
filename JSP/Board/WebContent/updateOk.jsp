<%@page import="kr.green.board.service.BoardService"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<jsp:useBean id="vo" class="kr.green.board.vo.BoardVO"></jsp:useBean>
<jsp:setProperty property="*" name="vo"/>
<jsp:setProperty property="ip" name="vo" value="${pageContext.request.remoteAddr }"/>
<%--
${vo }
 --%>
 <%
 	// 받기가 완료되었으니 저장/수정/삭제 3중에 1개를 수행하면 된다.
 	int count = 0;
 	switch(cv.getMode()){
 	case "insert":
 		count = BoardService.getInstance().insert(vo);
 		break;
 	case "update":
 		count = BoardService.getInstance().update(vo);
 		break;
 	case "delete":
 		count = BoardService.getInstance().delete(vo);
 		break;
 	}
 	request.setAttribute("count", count);
%>
<%-- ========================================================================================= --%>
<script>
	var mode = '${cv.mode}';
	var count = ${count };
	$(function(){
		if(mode=='insert' && (count*1>0)){
			alert('저장 성공!!!');
			SendPost("index.jsp",{"p":1,"s":${cv.pageSize },"b":${cv.blockSize }},"post")
			return;
		}
		if(mode=='insert' && (count*1==0)){
			alert('저장 실패!!!');
			SendPost("index.jsp",{"p":${cv.currentPage },"s":${cv.pageSize },"b":${cv.blockSize }},"post")
			return;
		}
		if(mode=='update' && (count*1>0)){
			alert('수정 성공!!!');
			SendPost("view.jsp",{"p":${cv.currentPage },"s":${cv.pageSize },"b":${cv.blockSize },"idx":${cv.idx},"m":"${cv.mode}","h":false},"post")
			return;
		}
		if(mode=='update' && (count*1==0)){
			alert('수정 실패!!!');
			SendPost("update.jsp",{"p":${cv.currentPage },"s":${cv.pageSize },"b":${cv.blockSize },"idx":${cv.idx},"m":"${cv.mode}","h":false},"post")
			return;
		}
		if(mode=='delete' && (count*1>0)){
			alert('삭제성공!!!');
			SendPost("index.jsp",{"p":${cv.currentPage },"s":${cv.pageSize },"b":${cv.blockSize }},"post")
			return;
		}
		if(mode=='delete' && (count*1==0)){
			alert('삭제 실패!!!');
			SendPost("update.jsp",{"p":${cv.currentPage },"s":${cv.pageSize },"b":${cv.blockSize },"idx":${cv.idx},"m":"${cv.mode}","h":false},"post")
			return;
		}
	});
</script>
</head>
<body>

</body>
</html>