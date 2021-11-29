<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%-- 로그인 여부 확인 --%>
<c:if test="${empty sessionScope.mvo }">
	<c:redirect url="index.jsp"></c:redirect>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 바꾸기</title>
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
		// 폼의 유효성을 검사한다.
		var value = $("#password").val();
		if(!value || value.trim().length==0){
			alert('이전 비밀번호는 반드시 입력해야 합니다.');
			$("#password").val("");
			$("#password").focus();
			return false;
		}
		var value = $("#password2").val();
		if(!value || value.trim().length==0){
			alert('새 비밀번호는 반드시 입력해야 합니다.');
			$("#newPassword").val("");
			$("#newPassword").focus();
			return false;
		}
		var value = $("#password2").val();
		if(!value || value.trim().length==0){
			alert('새 비밀번호 확인은 반드시 입력해야 합니다.');
			$("#password2").val("");
			$("#password2").focus();
			return false;
		}
		var value1 = $("#password2").val();
		var value2 = $("#password2").val();
		if(value1 != value2){
			alert('새 비밀번호가 일치하지 않습니다.');
			$("#password2").val("");
			$("#password2").focus();
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
					<form action="<c:url value="/login"/>" method="post" class="form-horizontal" onsubmit="return formCheck();">
						<!-- 에러메세지가 나타날 부분 -->
						<div style="margin-bottom: 10px;font-size: 16pt;font-weight: bold;text-align: center;">
							비밀번호 바꾸기
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
						<!-- 비밀번호 확인 입력폼 -->
						<div class="input-group input-sm">
							<label class="input-group-addon" for="password2" style="font-size: 18pt;margin-right: 5px;"><i class="axi axi-lock2"></i></label> 
								<input type="password" class="form-control" id="password2" name="password2"	placeholder="사용자 비밀번호 확인 입력" required >
						</div>
						<%-- 시큐리티에서 사용하려면 아래의 내용도 넘겨줘야 한다. --%>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						<!-- 전송 입력폼 -->
						<div class="form-actions" style="margin-bottom: 5px;">
							<input type="submit" class="btn btn-block btn-primary btn-default" value="비밀번호 바꾸기">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>