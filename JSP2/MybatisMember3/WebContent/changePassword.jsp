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
<title>회원 정보 수정</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link href="./css/login.css" rel="stylesheet">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/comm.js"></script>
<!-- 카카오 우편번호를 사용하겠다. 아래의 자바스크립트 라이브러리를 반드시 포함해야 한다. -->
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

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
		var value = $("#newPassword").val();
		if(!value || value.trim().length==0){
			alert('새 비밀번호는 반드시 입력해야 합니다.');
			$("#newPassword").val("");
			$("#newPassword").focus();
			return false;
		}
		var value = $("#confirmNewPassword").val();
		if(!value || value.trim().length==0){
			alert('새 비밀번호 확인은 반드시 입력해야 합니다.');
			$("#confirmNewPassword").val("");
			$("#confirmNewPassword").focus();
			return false;
		}
		var value1 = $("#newPassword").val();
		var value2 = $("#confirmNewPassword").val();
		if(value1 != value2){
			alert('새 비밀번호가 일치하지 않습니다.');
			$("#confirmNewPassword").val("");
			$("#confirmNewPassword").focus();
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
								<a href="#" id="register-form-link" class="active">회원 비밀 번호 수정</a>
							</div>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<%-- 여기가 회원 정보 수정 화면 시작 --%>
								<form id="register-form" action="changePasswordOk.jsp" method="post"
									role="form" onsubmit="return formCheck();">
									<div class="form-group">
										<input type="text" name="userid" id="userid" tabindex="1"
											class="form-control"
											style="width: 50%; float: left; margin-bottom: 15px;"
											placeholder="사용자아이디" value="${mvo.userid }" readonly="readonly">
									</div>
									<div class="form-group">
										<input type="password" name="password" id="password"
											tabindex="2" class="form-control" placeholder="이전 비밀 번호">
									</div>
									<div class="form-group">
										<input type="password" name="newPassword" id="newPassword"
											tabindex="2" class="form-control" placeholder="새로운 비밀 번호">
									</div>
									<div class="form-group">
										<input type="password" name="confirmNewPassword" id="confirmNewPassword"
											tabindex="2" class="form-control" placeholder="새로운 비밀 번호 확인">
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-12" style="text-align: center;">
												<input type="submit" 
													class="btn btn-outline-success btn-sm" value="   비밀번호수정   " >
												&nbsp;&nbsp;&nbsp;
												<input type="button" 
													class="btn btn-outline-success btn-sm" value="   취 소 하 기   " 
													onclick="location.href='index.jsp'">
											</div>
										</div>
									</div>
								</form>
								<%-- 여기가 회원 정보 수정 화면 종료 --%>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>