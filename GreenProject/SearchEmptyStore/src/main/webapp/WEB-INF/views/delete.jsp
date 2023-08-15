<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/app.css" />
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1. 11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/comm.js"></script>
<script>
	$(function() {
		
	});
		
	function formCheck(){
		// 폼의 유효성을 검사한다.
		var value = $("#userid").val();
		if(!value || value.trim().length==0){
			alert('아이디는 반드시 입력해야 합니다.');
			$("#userid").val("");
			$("#userid").focus();
			return false;
		}
		
		var value = $("#password").val();
		if(!value || value.trim().length==0){
			alert('비밀번호는 반드시 입력해야 합니다.');
			$("#password").val("");
			$("#password").focus();
			return false;
		}
		var value = $("#password2").val();
		if(!value || value.trim().length==0){
			alert('비밀번호 확인은 반드시 입력해야 합니다.');
			$("#password2").val("");
			$("#password2").focus();
			return false;
		}
		var value1 = $("#password").val();
		var value2 = $("#password2").val();
		if(value1 != value2){
			alert('비밀번호가 일치하지 않습니다.');
			$("#password2").val("");
			$("#password2").focus();
			return false;
		}
		
		var value = $("#username").val();
		if(!value || value.trim().length==0){
			alert('사용자 이름은 반드시 입력해야 합니다.');
			$("#username").val("");
			$("#username").focus();
			return false;
		}
		var value = $("#email").val();
		if(!value || value.trim().length==0){
			alert('이메일 주소는 반드시 입력해야 합니다.');
			$("#email").val("");
			$("#email").focus();
			return false;
		}
		// 이메일 주소가 유효한지 검증해야 한다.
		if(!verifyEmail(value)){
			alert('올바른 이메일 주소가 아닙니다.\n이메일 주소는 정확하게 입력해야 합니다.');
			$("#email").val("");
			$("#email").focus();
			return false;
		}
	}
</script>
<style type="text/css">
</style>
</head>
<body>
	<div id="mainWrapper">
		<div class="join-container">
			<div class="login-card">
				<div class="login-form">
					<form action="<c:url value="delete"/>" method="post" class="form-horizontal" onsubmit="return formCheck();">
						<!-- 에러메세지가 나타날 부분 -->
						<div style="margin-bottom: 10px;font-size: 16pt;font-weight: bold;text-align: center;">
							회원탈퇴
						</div>
						<!-- 아이디 입력폼 -->
						<div class="input-group input-sm">
							<label class="input-group-addon" for="userid" style="font-size: 18pt;margin-right: 5px;"><i class="axi axi-user"></i></label>
							<input type="text" class="form-control"	id="userid" name="userid" placeholder="사용자 아이디 입력" required>
							<div id="idMessage"	style=" line-height:30px; vertical-align: middle;"></div>
						</div>
						<!-- 비밀번호 입력폼 -->
						<div class="input-group input-sm">
							<label class="input-group-addon" for="password" style="font-size: 18pt;margin-right: 5px;"><i class="axi axi-lock2"></i></label> 
								<input type="password" class="form-control" id="password" name="password" placeholder="사용자 비밀번호 입력" required>
						</div>
						<!-- 비밀번호 확인 입력폼 -->
						<div class="input-group input-sm">
							<label class="input-group-addon" for="password2" style="font-size: 18pt;margin-right: 5px;"><i class="axi axi-lock2"></i></label> 
								<input type="password" class="form-control" id="password2" name="password2"	placeholder="사용자 비밀번호 확인 입력" required >
						</div>
						<!-- 사용자이름 입력폼 -->
						<div class="input-group input-sm">
							<label class="input-group-addon" for="username" style="font-size: 18pt;margin-right: 5px;"><i class="axi axi-user"></i></label>
							<input type="text" class="form-control"
								id="username" name="username" placeholder="사용자 이름 입력" required>
						</div>
						<!-- 사용자 이메일 입력폼 -->
						<div class="input-group input-sm">
							<label class="input-group-addon" for="email" style="font-size: 18pt;margin-right: 5px;"><i class="axi axi-email"></i></label>
							<input type="text" class="form-control"
								id="email" name="email" placeholder="이메일 주소 입력" required>
						</div>
						<%-- 시큐리티에서 사용하려면 아래의 내용도 넘겨줘야 한다. --%>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						
						<!-- 전송 입력폼 -->
						<div class="form-actions" style="margin-bottom: 5px;">
							<input type="submit" class="btn btn-block btn-primary btn-default" value="회원탈퇴">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>