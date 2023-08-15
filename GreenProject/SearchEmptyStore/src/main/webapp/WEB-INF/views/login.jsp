<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
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
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
<link href="./css/login.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/app.css" />
<script type="text/javascript">
	function formCheck(){
		var value = $("#userid").val();
		if(!value || value.trim().length==0){
			alert("사용자 아이디는 반드시 입력해야 합니다.");
			$("#userid").val("");
			$("#userid").focus();
			return false;
		}
		var value = $("#password").val();
		if(!value || value.trim().length==0){
			alert("사용자 비밀번호는 반드시 입력해야 합니다.");
			$("#password").val("");
			$("#password").focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<div id="mainWrapper">
		<div class="login-container">
			<div class="login-card">
				<div class="login-form">
					<form action="<c:url value="/login"/>" method="post" class="form-horizontal" onsubmit="return formCheck();">
						<!-- 에러메세지가 나타날 부분 -->
						<div class="input-group input-sm" style="margin-bottom: 10px;font-size: 12pt;">
							<c:if test="${not empty error}">
								<span style="color:red;font-weight: bold;">${error } </span> 
							</c:if>
							<c:if test="${not empty msg}">
								<span style="color:green;font-weight: bold;">${msg } </span> 
							</c:if>
						</div>
						<!-- 아이디 입력폼 -->
						<div class="input-group input-sm" style="margin-bottom: 10px;">
							<label class="input-group-addon" for="userid" style="font-size: 18pt;margin-right: 5px;"><i class="axi axi-user"></i></label>
							<input type="text" class="form-control" id="userid" name="userid" placeholder="사용자아이디입력" required>
						</div>
						<!-- 비밀번호 입력폼 -->
						<div class="input-group input-sm" style="margin-bottom: 10px;">
							<label class="input-group-addon" for="password" style="font-size: 18pt;margin-right: 5px;"><i class="axi axi-lock2"></i></label> 
								<input type="password" class="form-control" id="password" name="password" placeholder="사용자 비밀번호입력" required>
						</div>
						<!-- 시큐리트에서 사용자가 지정한 폼을 사용하려면 반드시 아래의 코드를 첨부해줘야 한다.-->
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						<!-- 아이디 저장 체크 -->
						<div class="form-group text-center">
							<input type="checkbox" tabindex="3" name="remember" id="remember" ${userid==null || userid=="" ? "" : " checked='checked' " } value="1">
							<label for="remember"> 아이디 저장</label>
						</div>
						
						<!-- 전송 입력폼 -->
						<div class="form-actions" style="margin-bottom: 10px;">
							<input type="submit" class="btn btn-block btn-primary btn-default" value="로그인하기">
						</div>
						<!-- 회원가입/아이디 찾기/비번찾기/홈으로 링크 보이기 -->
						<div style="margin-bottom: 10px; text-align: center;">
							<a href="${pageContext.request.contextPath }/join">회원가입</a> &nbsp;
							<a href="${pageContext.request.contextPath }/findUserId">아이디 찾기</a> &nbsp;
							<a href="${pageContext.request.contextPath }/findPassword">비밀번호 찾기</a> &nbsp;
							<a href="${pageContext.request.contextPath }/">홈으로</a>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>