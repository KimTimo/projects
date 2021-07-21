<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 쿠키에 userid가 저장되어있는지 판단하여 저장되어있으면 아이디자리에 아이디를 출력하고 아이디 저장을 체크해줘야 한다.
	String userid="";
	Cookie[] cookies = request.getCookies(); // 모든 쿠키를 배열로 읽어온다
	if(cookies!=null && cookies.length>0){ // 쿠키가 존재한다면
		for(Cookie cookie : cookies){ // 반복
			if(cookie.getName().equals("userid")){ // 쿠키이름이 userid라면
				userid = URLDecoder.decode(cookie.getValue(), "UTF-8"); // 아이디값을 읽어서 저장
				break;
			}
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키를 이용한 아이디 자동저장 구현</title>
<style type="text/css">
	div{width:160px; padding:10px; float: left}
	#userid, #password {padding: 5px; width: 150px;border: 1px solid gray;margin-bottom: 5px;}
	#submitBtn { width: 60px; height: 60px;}
	fieldset { width: 360px; margin: auto;}
</style>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#loginForm").submit(function() {
			var value = $("#userid").val();
			if(value==null || value.trim().length==0 ){
				alert('아이디는 반드시 입력해야 합니다.');
				$("#userid").val("");
				$("#userid").focus();
				return false;
			}
			var value = $("#password").val();
			if(value==null || value.trim().length==0 ){
				alert('비밀번호는 반드시 입력해야 합니다.');
				$("#password").val("");
				$("#password").focus();
				return false;
			}
			return true;
		});
	});
</script>
</head>
<body>
	<form action="loginOk.jsp" method="post" id="loginForm">
		<fieldset>
			<legend>로그인</legend>		
			<div>
			<input type="text" name="userid" id="userid" placeholder="아이디" required="required" value="<%=userid%>"/>
			<input type="password" name="password" id="password" placeholder="비밀번호" required="required"/> <br />
			<label><input type="checkbox" name="saveid" id="saveid" value="1" <%=userid==null || userid.equals("") ? "": "checked='checked'" %>> 아이디저장</label>
			</div>
			<div>
				<input type="submit" id="submitBtn" value="로그인"/>
			</div>
		</fieldset>
	</form>
</body>
</html>