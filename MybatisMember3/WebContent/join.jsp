<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
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
		// 아이디 중복확인 검사 : Ajax로 처리
		$("#userid").keyup(function() {
			var value = $(this).val();
			// alert(value);
			// 아이디가 3글자 이하면 검사 생략
			if (value.length <= 3) {
				return false;
			} else {
				$("#idMessage").html("");
			}
			if (value.includes(" ")) {
				alert("아이디에는 공백을 포함할 수 없습니다.");
				$(this).val("");
				$(this).focus();
				return false;
			}
			// 여기까지오면 3자이상에 공백이 없다는 것이다.
			$.ajax('idCheck.jsp', {
				type : "POST",
				data : {
					"userid" : value
				},
				success : function(data) {
					// alert(data + "\n" + typeof(data));
					if (data * 1 >= 1) {
						$("#idMessage").html("사용 불가능").css('color', 'red');
					} else {
						$("#idMessage").html("사용가능").css('color', 'blue');
					}
				},
				error : function() {
					alert("에러!!!");
				}
			});
		});
	});
	// 비밀번호 일치 확인
	function pwdConfirm() {
		var pwd1 = $("#password").val();
		var pwd2 = $("#confirm_password").val();
		if (pwd1 != pwd2) {
			alert("비번이 일치하지 않습니다.");
			$("#confirm_password").val("");
			$("#confirm_password").focus();
			return false;
		}
	}
	// 우편번호 검색하기
	function findPostCode() {
		// alert('호출되냐?');
		new daum.Postcode({
			oncomplete : function(data) {
				var zoneCode = data.zonecode; // 우편번호
				var roadAddr = data.roadAddress; // 도로명 주소 변수
				var jibunAddr = data.jibunAddress; // 지번주소
				// alert(roadAddr);
				$("#postCode").val(zoneCode);
				$("#roadAddr").val(roadAddr);
				$("#jibunAddr").val(jibunAddr);
				$("#detailAddr").focus();
			}
		}).open();
	}
	
	function formCheck(){
		// 폼의 유효성을 검사한다.
		var value = $("#userid").val();
		if(!value || value.trim().length==0){
			alert('아이디는 반드시 입력해야 합니다.');
			$("#userid").val("");
			$("#userid").focus();
			return false;
		}
		// 사용불가능한 아이디인 경우 검사
		if($("#idMessage").css('color')=='rgb(255, 0, 0)'){
			alert('사용불가능한 아이디 입니다.');
			$("#idMessage").html("");
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
		var value = $("#confirm_password").val();
		if(!value || value.trim().length==0){
			alert('비밀번호 확인은 반드시 입력해야 합니다.');
			$("#confirm_password").val("");
			$("#confirm_password").focus();
			return false;
		}
		// 비밀번호 일치를 확인해야 한다.
		var pwd1 = $("#password").val();
		var pwd2 = $("#confirm_password").val();
		if (pwd1 != pwd2) {
			alert("비번이 일치하지 않습니다.");
			$("#confirm_password").val("");
			$("#confirm_password").focus();
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
		
		// alert(value + "\n" + verifyEmail(value));
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
		var value = $("#postCode").val();
		if(!value || value.trim().length==0){
			alert('우편번호는 반드시 입력해야 합니다.');
			$("#postCode").val("");
			$("#postCode").focus();
			return false;
		}
		var value = $("#detailAddr").val();
		if(!value || value.trim().length==0){
			alert('상세주소는 반드시 입력해야 합니다.');
			$("#detailAddr").val("");
			$("#detailAddr").focus();
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
								<a href="#" id="register-form-link" class="active">회원가입</a>
							</div>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<%-- 여기가 회원가입 화면 시작 --%>
								<form id="register-form" action="joinOk.jsp" method="post"
									role="form" onsubmit="return formCheck();">
									<div class="form-group">
										<input type="text" name="userid" id="userid" tabindex="1"
											class="form-control"
											style="width: 50%; float: left; margin-bottom: 15px;"
											placeholder="사용자아이디" value=""> <span id="idMessage"
											style="margin-left: 20px; line-height: 45px; vertical-align: middle;"></span>
									</div>
									<div class="form-group">
										<input type="password" name="password" id="password"
											tabindex="2" class="form-control" placeholder="비밀번호">
									</div>
									<div class="form-group">
										<input type="password" name="confirm_password"
											id="confirm_password" tabindex="3" class="form-control"
											placeholder="비밀번호 확인" onblur="pwdConfirm();">
									</div>
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
										<input type="text" name="postCode" id="postCode"
											class="form-control"
											style="width: 50%; float: left; margin-bottom: 15px;"
											placeholder="우편번호" readonly="readonly"> 
										<input type="button"
											value=" 우편번호 검색 " onclick="findPostCode()" tabindex="7"
											class="btn btn-outline-success btn-sm"
											style="margin-left: 20px; line-height: 33px; vertical-align: middle;" />
									</div>
									<div class="form-group">
										<input type="text" name="roadAddr" id="roadAddr"
											class="form-control" placeholder="도로명 주소" readonly="readonly">
									</div>
									<div class="form-group">
										<input type="text" name="jibunAddr" id="jibunAddr"
											class="form-control" placeholder="지번 주소" readonly="readonly">
									</div>
									<div class="form-group">
										<input type="text" name="detailAddr" id="detailAddr"
											tabindex="8" class="form-control" placeholder="상세 주소">
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-12" style="text-align: center;">
												<input type="submit" 
													class="btn btn-outline-success btn-sm" value="   회 원 가 입   " >
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