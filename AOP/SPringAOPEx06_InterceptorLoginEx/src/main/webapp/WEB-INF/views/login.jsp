<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
	<title>Home</title>
	<meta charset="UTF-8">
	<script type="text/javascript">
		function formCheck(){
			f = document.forms[0];
			if(!f.userId.value){
				alert("아이디는 반드시 입력하세요...");
				f.userId.focus();
				return false;
			}
			if(!f.password.value){
				alert("암호는 반드시 입력하세요...");
				f.password.focus();
				return false;
			}
			return true;
		}
	</script>
</head>
<body>
	<div style="color:red;">${msg }</div>
	<form action="loginOk" method="post" onsubmit="return formCheck();">
		id : <input type="text" name="userId"><br/>
		pw : <input type="password" name="password"><br/>
		<input type="submit" value="로그인">
	</form>
</body>
</html>
