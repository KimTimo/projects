<%@page import="kr.green.member.service.MemberService"%>
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
	<jsp:useBean id="mvo" class="kr.green.member.vo.MemberVO" scope="request"></jsp:useBean>
	<jsp:setProperty property="*" name="mvo"/>
	<%--
	${mvo }
	 --%>
	 <%
	 	// 1. 서비스클래스를 이용하여 인증을 수행한다.
	 	boolean isOk = MemberService.getInstance().setAuth(mvo);
	 	request.setAttribute("isOk", isOk);
	 	// 2. 홈으로 보낸다.
	 	
	 %>
	 <c:if test="${isOk }">
		 <h1>${mvo.userid }님 인증에 성공하셨습니다.</h1>
	 </c:if>
	 <c:if test="${not isOk }">
		 <h1>${mvo.userid }님 인증에 실패하셨습니다.</h1>
	 </c:if>
	 <button  class="btn btn-outline-success btn-sm" onclick="location.href='index.jsp'">홈으로</button>
</body>
</html>