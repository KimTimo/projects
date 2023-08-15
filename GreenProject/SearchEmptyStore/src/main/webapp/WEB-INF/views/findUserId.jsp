<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 아이디 찾기</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/app.css" />
<script src="${pageContext.request.contextPath}/resources/js/comm.js"></script>
<!-- Jquery datepicker사용 -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script>
	$(function() {
		
	});
	
	function formCheck(){
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
		var value = $("#phone").val();
		if(!value || value.trim().length==0){
			alert('전화번호는 반드시 입력해야 합니다.');
			$("#phone").val("");
			$("#phone").focus();
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
					<form action="<c:url value="/findUserId"/>" method="get" class="form-horizontal" onsubmit="return formCheck();">
						<!-- 에러메세지가 나타날 부분 -->
						<div style="margin-bottom: 10px;font-size: 16pt;font-weight: bold;text-align: center;">
							아이디 찾기
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
						<!-- 사용자 전화번호 입력폼 -->
						<div class="input-group input-sm">
							<label class="input-group-addon" for="phone" style="font-size: 18pt;margin-right: 5px;"><i class="axi axi-phone"></i></label>
							<input type="text" class="form-control" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" 
								id="phone" name="phone" placeholder="010-1234-5678" required>
						</div>
						<%-- 시큐리티에서 사용하려면 아래의 내용도 넘겨줘야 한다. --%>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						
						<!-- 전송 입력폼 -->
						<div class="form-actions" style="margin-bottom: 5px;">
							<input type="submit" class="btn btn-block btn-primary btn-default" value="아이디 찾기">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>