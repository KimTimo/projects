<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script type="text/javascript">
	function formCheck() {
		var value = $("#userid").val();
		if(!value || value.trim().length==0){
			alert("아이디는 반드시 입력해야 합니다.");
			$("#userid").val("");
			$("#userid").focus();
			return false;
		}
		val value = $("#password").val();
		if(!value || value.trim().length==0){
			alert("비밀번호는 반드시 입력해야 합니다.");
			$("#password").val("");
			$("#password").focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body>

</body>
</html>