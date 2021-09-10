<%@page import="kr.green.mybatis.memo.service.MemoService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<script type="text/javascript">
	$(function(){
		
	});
</script>
</head>
<body>
<fmt:requestEncoding value="UTF-8"/>
<c:if test='${pageContext.request.method "POST"}'>
	<c:redirect url="index.jsp"></c:redirect>
</c:if>
<%-- 넘어오는 현재페이지, 페이지사이즈, 블록 사이즈를 받아야 한다. --%>
<jsp:useBean id="cv" class="kr.green.mybatis.memo.vo.CommVO"></jsp:useBean>
<jsp:setProperty property="*" name="cv"/>

<%-- 2. 데이터를 받고 부족한 데이터를 채우기 --%>
<jsp:useBean id="vo" class="kr.green.mybatis.memo.vo.MemoVO"/>
<jsp:setProperty property="*" name="vo"/>
<jsp:setProperty property="ip" name="vo" value="${pageContext.request.remoteAddr}"/>
<%
	// 3. 모드 값에 따라 서비스에서 맞는 메서드를 호출해 준다.
	int currentPage = cv.getCurrentPage(); // 수정이나 삭제시는 현재 페이지에 머물러 있어야 한다.
	switch(cv.getMode()){
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
%>
<script type="text/javascript">
	SendPost("index.jsp", {"p":"${cv.currentPage}","s":"${cv.pageSize}", "b":"${cv.blockSize}"});
</script>
</body>
</html>