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
		var value = $("#password").val();
		if(!value || value.trim().length==0){
			alert('비밀번호는 반드시 입력해야 합니다.');
			$("#password").val("");
			$("#password").focus();
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
								<a href="#" id="register-form-link" class="active">회원 정보 수정</a>
							</div>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<%-- 여기가 회원 정보 수정 화면 시작 --%>
								<form id="register-form" action="updateOk.jsp" method="post"
									role="form" onsubmit="return formCheck();">
									<div class="form-group">
										<input type="text" name="userid" id="userid" tabindex="1"
											class="form-control"
											style="width: 50%; float: left; margin-bottom: 15px;"
											placeholder="사용자아이디" value="${mvo.userid }" readonly="readonly">
									</div>
									<div class="form-group">
										<input type="password" name="password" id="password"
											tabindex="2" class="form-control" placeholder="비밀번호">
									</div>
									<div class="form-group">
										<input type="text" name="username" id="username" tabindex="4"
											class="form-control" placeholder="사용자 이름" value="${mvo.username }">
									</div>
									<div class="form-group">
										<input type="text" name="email" id="email" tabindex="5"
											class="form-control" placeholder="사용자 이메일" value="${mvo.email }"> 
									</div>
									<div class="form-group">
										<input type="text" name="phone" id="phone" tabindex="6"
											pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" required
											class="form-control" placeholder="010-1234-5678" value="${mvo.phone }">
									</div>
									<div class="form-group">
										<input type="text" name="postCode" id="postCode"
											class="form-control"
											style="width: 50%; float: left; margin-bottom: 15px;"
											placeholder="우편번호" readonly="readonly" value="${mvo.postCode }"> 
										<input type="button"
											value=" 우편번호 검색 " onclick="findPostCode()" tabindex="7"
											class="btn btn-outline-success btn-sm"
											style="margin-left: 20px; line-height: 33px; vertical-align: middle;" />
									</div>
									<div class="form-group">
										<input type="text" name="roadAddr" id="roadAddr"
											class="form-control" placeholder="도로명 주소" readonly="readonly" value="${mvo.roadAddr }">
									</div>
									<div class="form-group">
										<input type="text" name="jibunAddr" id="jibunAddr"
											class="form-control" placeholder="지번 주소" readonly="readonly" value="${mvo.jibunAddr }">
									</div>
									<div class="form-group">
										<input type="text" name="detailAddr" id="detailAddr"
											tabindex="8" class="form-control" placeholder="상세 주소" value="${mvo.detailAddr }">
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-12" style="text-align: center;">
												<input type="submit" 
													class="btn btn-outline-success btn-sm" value="   정 보 수 정   " >
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