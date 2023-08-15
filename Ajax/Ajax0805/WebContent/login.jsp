<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
<script type="text/javascript">
<%
	if(session.getAttribute("mv")!=null){ // 세션에 mv객체가 존재하면 로그인 상태이고
		out.println("var isLogin = true");		
	}else{ // 세션에 mv객체가 존재하지 않으면 로그아웃 상태이고
		out.println("var isLogin = false");		
	}
	// out.println("alert(isLogin);");		
%>
</script>
<script>
	$(function(){
		if(isLogin){
			$("#loginBox").css('display','none');
			$("#logoutBox").css('display','block');
		}else{
			$("#loginBox").css('display','block');
			$("#logoutBox").css('display','none');
		}
		
		$("#loginBtn").click(function(){
			var userid=$("#userid").val();
			var password=$("#password").val();
			// 여기에서 서버의 로그인 처리를 Ajax로 호출해보자!!!
			$.ajax({
				url : "loginOk.jsp",
				method : "post",
				data : {"userid":userid, "password":password},
				dataType:"json",
				success : function(data){
					if(data['result']*1==1){
						//alert('로그인 성공');
						$("#loginBox").css('display','none');
						$("#logoutBox").css('display','block');
						$("#msg1").html(data['userid'] + "(" + data['nickname'] + ")님 반가워!!");
						$("#msg2").html("보유포인트 : " + data['point'] + "점");
					}else{
						alert('로그인 실패');
					}
				}
			});
		});
		$("#logoutBtn").click(function(){
			// 여기에서 서버의 로그아웃 처리를 Ajax로 호출해보자!!!
			$.ajax({
				url : "logout.jsp",
				method : "get",
				success : function(data){
					if(data*1==1){
						$("#loginBox").css('display','block');
						$("#logoutBox").css('display','none');
					}
				}
			});
		});
	});
</script>
<style type="text/css">
	table { width: 90%; height: 600px; border: 1px solid gray; padding: 10px;margin: auto;}
	td { border: 1px solid gray; padding: 10px;margin: auto;}
</style>
</head>
<body>
	<table>
		<tr>
			<td colspan="3" style="height: 100px;"><h1>상단에로고</h1></td>
		</tr>
		<tr>
			<td valign="top">왼쪽</td>
			<td valign="top" width="80%">여기에는 내용이 나온다</td>
			<td valign="top">
			오른쪽
			<%-- 로그인이 나타날거다 --%>
			<div id="loginBox">
				<input type="text" id="userid" name="userid"  placeholder="아이디입력" required="required"/> <br />
				<input type="password" id="password" name="password"  placeholder="비번입력" required="required"/> <br />
				<input type="button" id="loginBtn" value="로그인"/>
			</div>
			<%-- 로그아웃이 나타날거다 --%>
			<div id="logoutBox">
				<div id="msg1">????(???)님</div>
				<div id="msg2">포인트 : ???점</div>
				<input type="button" id="logoutBtn" value="로그아웃"/>
			</div>
			</td>
		</tr>
		<tr>
			<td colspan="3"  style="height: 100px;"><h1>하단</h1></td>
		</tr>
	</table>
</body>
</html>