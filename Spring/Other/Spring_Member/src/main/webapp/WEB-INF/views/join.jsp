<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/app.css" />
<script src="${pageContext.request.contextPath}/resources/js/comm.js"></script>
<!-- 카카오 우편번호를 사용하겠다. 아래의 자바스크립트 라이브러리를 반드시 포함해야 한다. -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<!-- Jquery datepicker사용 -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<style>
/*datepicer 버튼 롤오버 시 손가락 모양 표시*/
.ui-datepicker-trigger{cursor: pointer;}
/*datepicer input 롤오버 시 손가락 모양 표시*/
.hasDatepicker{cursor: pointer;}
</style>

<script type="text/javascript">
	$(function(){
		//input을 datepicker로 선언
        $("#birth").datepicker({
            dateFormat: 'yy-mm-dd' //Input Display Format 변경
            //,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
            //,showMonthAfterYear:true //년도 먼저 나오고, 뒤에 월 표시
            ,changeYear: true //콤보박스에서 년 선택 가능
            ,changeMonth: true //콤보박스에서 월 선택 가능                
            //,showOn: "both" //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시  
            //,buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif" //버튼 이미지 경로
            //,buttonImageOnly: true //기본 버튼의 회색 부분을 없애고, 이미지만 보이게 함
            //,buttonText: "선택" //버튼에 마우스 갖다 댔을 때 표시되는 텍스트                
            //,yearSuffix: "년" //달력의 년도 부분 뒤에 붙는 텍스트
            ,monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'] //달력의 월 부분 텍스트
            ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip 텍스트
            ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 부분 텍스트
            ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 부분 Tooltip 텍스트
            //,minDate: "-1M" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
            //,maxDate: "+1M" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)                
        });                    
		
		
		// 아이디 중복확인 검사 : Ajax로 처리
		$("#userid").keyup(function() {
			var value = $(this).val();
			// alert(value);
			// 아이디가 3글자 이하면 검사 생략
			if (value.length <= 3) {
				$("#idMessage").html("").css('color', 'black');
				return false;
			}
			if (value.includes(" ")) {
				alert("아이디에는 공백을 포함할 수 없습니다.");
				$(this).val("");
				$(this).focus();
				return false;
			}
			// 여기까지오면 3자이상에 공백이 없다는 것이다.
			$.ajax('idCheck', {
				type : "GET",
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
	// 우편번호 검색하기
	function findPostCode() {
		// alert('호출되냐?');
		new daum.Postcode({
			oncomplete : function(data) {
				var zoneCode = data.zonecode; // 우편번호
				var roadAddr = data.roadAddress; // 도로명 주소 변수
				var jibunAddr = data.jibunAddress; // 지번주소
				// alert(roadAddr);
				$("#zipcode").val(zoneCode);
				$("#addr1").val(roadAddr);
				//$("#jibunAddr").val(jibunAddr);
				$("#addr2").focus();
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
		/*
		if($("#idMessage").css('color')!='rgb(0, 0, 255)'){
			alert('사용불가능한 아이디 입니다.');
			$("#idMessage").html("");
			$("#userid").val("");
			$("#userid").focus();
			return false;
		}
		*/
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
		// 비밀번호 일치를 확인해야 한다.
		var pwd1 = $("#password").val();
		var pwd2 = $("#password2").val();
		if (pwd1 != pwd2) {
			alert("비번이 일치하지 않습니다.");
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
		
		var value = $("#birth").val();
		if(!value || value.trim().length==0){
			alert('생년월일 반드시 입력해야 합니다.');
			$("#birth").val("");
			$("#birth").focus();
			return false;
		}
		
		var value = $("#phone").val();
		if(!value || value.trim().length==0){
			alert('전화번호는 반드시 입력해야 합니다.');
			$("#phone").val("");
			$("#phone").focus();
			return false;
		}
		
		var value = $("#zipcode").val();
		if(!value || value.trim().length==0){
			alert('우편번호는 반드시 입력해야 합니다.');
			$("#zipcode").val("");
			$("#zipcode").focus();
			return false;
		}
		
		var value = $("#addr2").val();
		if(!value || value.trim().length==0){
			alert('상세주소는 반드시 입력해야 합니다.');
			$("#addr2").val("");
			$("#addr2").focus();
			return false;
		}
	}	
</script>
</head>
<body>
	<div id="mainWrapper">
		<div class="join-container">
			<div class="login-card">
				<div class="login-form">
					<form action="<c:url value="/joinOk"/>" method="post" class="form-horizontal" onsubmit="return formCheck();">
						<!-- 에러메세지가 나타날 부분 -->
						<div style="margin-bottom: 10px;font-size: 16pt;font-weight: bold;text-align: center;">
							회원가입
						</div>
						<!-- 아이디 입력폼 -->
						<div class="input-group input-sm">
							<label class="input-group-addon" for="userid" style="font-size: 18pt;margin-right: 5px;"><i class="axi axi-user"></i></label>
							<input type="text" class="form-control"
								id="userid" name="userid" placeholder="사용자 아이디 입력" required>
							<div id="idMessage"
										style="margin-left: 20px; line-height30px; vertical-align: middle;"></div>
						</div>
						<!-- 비밀번호 입력폼 -->
						<div class="input-group input-sm">
							<label class="input-group-addon" for="password" style="font-size: 18pt;margin-right: 5px;"><i class="axi axi-lock2"></i></label> 
								<input type="password"
								class="form-control" id="password" name="password"
								placeholder="사용자 비밀번호 입력" required>
						</div>
						<!-- 비밀번호 확인 입력폼 -->
						<div class="input-group input-sm">
							<label class="input-group-addon" for="password2" style="font-size: 18pt;margin-right: 5px;"><i class="axi axi-lock2"></i></label> 
								<input type="password"
								class="form-control" id="password2" name="password2"
								placeholder="사용자 비밀번호 확인 입력" required >
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
						<!-- 사용자 생년월일 입력폼 -->
						<div class="input-group input-sm">
							<label class="input-group-addon" for="birth" style="font-size: 18pt;margin-right: 5px;"><i class="axi axi-birthday-cake"></i></label>
							<input type="text" class="form-control"
								id="birth" name="birth" placeholder="사용자 생년월일 입력" required>
						</div>
						<!-- 사용자 전화번호 입력폼 -->
						<div class="input-group input-sm">
							<label class="input-group-addon" for="phone" style="font-size: 18pt;margin-right: 5px;"><i class="axi axi-phone"></i></label>
							<input type="text" class="form-control" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" 
								id="phone" name="phone" placeholder="010-1234-5678" required>
						</div>
						<!-- 우편번호 주소 입력폼 -->
						<div class="input-group input-sm">
							<label class="input-group-addon" for="userid" style="font-size: 18pt;margin-right: 5px;"><i class="axi axi-local-post-office"></i></label>
							<input type="text" class="form-control"	id="zipcode" name="zipcode" onclick="findPostCode()" placeholder="우편번호" required readonly="readonly">
						</div>
						<div class="input-group input-sm">
							<label class="input-group-addon" for="addr1" style="font-size: 18pt;margin-right: 5px;">&nbsp;&nbsp;&nbsp;&nbsp;</label>
							<input type="text" class="form-control"	id="addr1" name="addr1" placeholder="주소" required readonly="readonly">
						</div>
						<div class="input-group input-sm">
							<label class="input-group-addon" for="addr2" style="font-size: 18pt;margin-right: 5px;">&nbsp;&nbsp;&nbsp;&nbsp;</label>
							<input type="text" class="form-control"	id="addr2" name="addr2" placeholder="상세주소" required>
						</div>
						<%-- 시큐리티에서 사용하려면 아래의 내용도 넘겨줘야 한다. --%>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						
						<!-- 전송 입력폼 -->
						<div class="form-actions" style="margin-bottom: 5px;">
							<input type="submit"
								class="btn btn-block btn-primary btn-default" value="회원가입하기">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>