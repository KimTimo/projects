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
		// 1. 서비스를 호출하여 비밀번호 찾기를 수행한다.
		String userid = MemberService.getInstance().findPassword(mvo);
	
		request.setAttribute("userid", userid);
		// 2. 삭제 성공하면 강제 로그아웃을 시키고 아래의 버튼을 눌러 홈으로 이동 하도록 하자!! 
	%>
	<c:if test='${userid!="" }'>
		<h1>${mvo.userid }님의 "${mvo.email }"로 새로운 임시 비밀 번호를 발송했습니다. </h1>
		<h1>이메일을 확인하여 ${userid }로 로그인하시기 바랍니다.</h1>
		<button  class="btn btn-outline-success btn-sm" onclick="location.href='login.jsp'">로그인하기</button>
	</c:if>	
	<c:if test='${userid=="" }'>
		<h1>${mvo.userid }님의 정보는 존재하지 않습니다.</h1>
		<h1>회원가입을 하시려면 회원가입 단추를 클릭하여 가입을 진행해 주세요 </h1>
		<button  class="btn btn-outline-success btn-sm" onclick="location.href='findPassword.jsp'">다시하기</button>
		<button  class="btn btn-outline-success btn-sm" onclick="location.href='join.jsp'">회원가입</button>
	</c:if>	
	<button  class="btn btn-outline-success btn-sm" onclick="location.href='index.jsp'">홈으로</button>
	
</body>
</html>