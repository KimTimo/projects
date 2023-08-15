<%@page import="java.net.URLDecoder"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	// 쿠키에 userid가 저장되어있는지 판단하여 저장되어있으면 아이디자리에 아이디를 출력하고 아이디 저장을 체크해줘야 한다.
	String userid="";
	Cookie[] cookies = request.getCookies(); // 모든 쿠키를 배열로 읽어온다
	if(cookies!=null && cookies.length>0){ // 쿠키가 존재한다면
		for(Cookie cookie : cookies){ // 반복
			if(cookie.getName().equals("userid")){ // 쿠키이름이 userid라면
				userid = URLDecoder.decode(cookie.getValue(), "UTF-8"); // 아이디값을 읽어서 저장
				break;
			}
		}
	}
	request.setAttribute("userid", userid);
%>
<%-- 이미 로그인이 되어있다면 메인화면으로 보내버린다. 시작!!! --%>
<c:if test="${not empty sessionScope.mvo }">
	<c:redirect url="index.jsp"></c:redirect>
</c:if>
<%-- 이미 로그인이 되어있다면 메인화면으로 보내버린다. 종료!!! --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈화면</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="./css/login.css" rel="stylesheet">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/comm.js"></script>
<script>
$(function() {
	
});
// 아이디와 비번이 입력되지 않았으면 다시 입력을 받게하는 코드
function formCheck(){
	var value = $("#userid").val();
	if(!value || value.trim().length==0){
		alert('아이디는 반드시 입력해야 합니다.');
		values = $("#userid").val("");
		values = $("#userid").focus();
		return false;
	}
	var value = $("#password").val();
	if(!value || value.trim().length==0){
		alert('사용자 비밀번호는 반드시 입력해야 합니다.');
		values = $("#password").val("");
		values = $("#password").focus();
		return false;
	}
}
</script>
<style type="text/css">

</style>
</head>
<body>
<div class="container">
    	<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-12">
								<a href="#" class="active" id="login-form-link">로그인</a>
							</div>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<%-- 여기가 로그인 화면 시작 --%>
								<form id="login-form" action="loginOk.jsp" method="post" role="form" style="display: block;" onsubmit="return formCheck();">
									<div class="form-group">
										<input type="text" name="userid" id="userid" tabindex="1" class="form-control" placeholder="사용자아이디" value="${userid }" required="required">
									</div>
									<div class="form-group">
										<input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="사용자비밀번호" required="required">
									</div>
									<div class="form-group text-center">
										<input type="checkbox" tabindex="3" name="remember" id="remember" ${userid==null || userid=="" ? "" : " checked='checked' " } value="1">
										<label for="remember"> 아이디 저장</label>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="Log In">
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-lg-12">
												<div class="text-center">
													<a href="findUserId.jsp" tabindex="5" class="forgot-password">아이디 찾기</a>
													&nbsp;&nbsp;&nbsp;
													<a href="findPassword.jsp" tabindex="6" class="forgot-password">비밀번호 찾기</a>
													&nbsp;&nbsp;&nbsp;
													<a href="join.jsp" tabindex="6" class="forgot-password">회원가입</a>
												</div>
											</div>
										</div>
									</div>
								</form>
								<%-- 여기가 로그인 화면 종료 --%>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>