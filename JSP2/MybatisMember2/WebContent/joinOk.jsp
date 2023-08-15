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
	${mvo }
	<%
		// 0. vo에 인증문자를 추가한다.
		mvo.setAuth(PasswordUtil.generateAuth(10));
		// 1. 서비스를 호출하여 저장을 수행한다.(가입축하 이메일을 발송한다.)
		MemberService.getInstance().insert(mvo);
		// 2. 인증을 하라는 안내 메세지를 출력한다.
		// 3. 돌아가기 버튼을 클릭하면 시작화면으로 이동한다.
	%>
	<h1>${mvo.username }님은 ${mvo.userid }로 회원가입을 하셨습니다.</h1>
	<h1>${mvo.email }에서 인증을 하셔야 회원가입이 완료됩니다.</h1>
	<button  class="btn btn-outline-success btn-sm" onclick="location.href='index.jsp'">홈으로</button>
</body>
</html>