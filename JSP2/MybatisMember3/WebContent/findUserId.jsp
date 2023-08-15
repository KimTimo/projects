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
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link href="./css/login.css" rel="stylesheet">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/comm.js"></script>

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
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-12">
								<a href="#" id="register-form-link" class="active">사용자 아이디 찾기</a>
							</div>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<%-- 여기가 회원가입 화면 시작 --%>
								<form id="register-form" action="findUseridOk.jsp" method="post"
									role="form" onsubmit="return formCheck();">
									<div class="form-group">
										<input type="text" name="username" id="username" tabindex="4"
											class="form-control" placeholder="사용자 이름">
									</div>
									<div class="form-group">
										<input type="text" name="email" id="email" tabindex="5"
											class="form-control" placeholder="사용자 이메일">
									</div>
									<div class="form-group">
										<input type="text" name="phone" id="phone" tabindex="6"
											pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" required
											class="form-control" placeholder="010-1234-5678">
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-12" style="text-align: center;">
												<input type="submit" 
													class="btn btn-outline-success btn-sm" value="   아이디 찾기   " >
												&nbsp;&nbsp;&nbsp;
												<input type="button" 
													class="btn btn-outline-success btn-sm" value="   취 소 하 기   " 
													onclick="location.href='index.jsp'">
											</div>
										</div>
									</div>
								</form>
								<%-- 여기가 회원가입 화면 종료 --%>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>