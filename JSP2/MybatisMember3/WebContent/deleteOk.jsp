<%@page import="kr.green.member.service.MemberService"%>
<%@page import="kr.green.email.util.PasswordUtil"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여기에 제목</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/comm.js"></script>
<script>
	$(function(){
		
	});
</script>
</head>
<body>
	<fmt:requestEncoding value="UTF-8"/>
	<c:if test='${pageContext.request.method!="POST" }'>
		<c:redirect url="index.jsp"></c:redirect>
	</c:if>
	<jsp:useBean id="mvo" class="kr.green.member.vo.MemberVO" scope="request"></jsp:useBean>
	<jsp:setProperty property="*" name="mvo"/>
	<%--
	${mvo }
	 --%>
	<%
		// 1. 서비스를 호출하여 회원탈퇴를 수행한다.
		boolean isDelete = MemberService.getInstance().delete(mvo);
	
		request.setAttribute("isDelete", isDelete);
		// 2. 삭제 성공하면 강제 로그아웃을 시키고 아래의 버튼을 눌러 홈으로 이동 하도록 하자!! 
	%>
	<c:if test="${isDelete }">
		<h1>${mvo.userid }님의 회원 탈퇴가 정상적으로 처리되었습니다.</h1>
		<h1>회원정보는 보안을 위하여 1개월 동안 보관후 일괄 삭제 됩니다.</h1>
		<c:remove var="mvo" scope="session"/>
	</c:if>	
	<c:if test="${not isDelete }">
		<h1>${mvo.userid }님의 회원 탈퇴에 실패했습니다.</h1>
		<h1>다시 시도하시기 바랍니다.</h1>
		<button  class="btn btn-outline-success btn-sm" onclick="location.href='delete.jsp'">다시하기</button>
	</c:if>	
	<button  class="btn btn-outline-success btn-sm" onclick="location.href='index.jsp'">홈으로</button>
	
</body>
</html>