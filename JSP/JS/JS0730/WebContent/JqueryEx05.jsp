<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JQuery 연습 : 객체의 삽입</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		// 앞에 있는 내용이 박스의 자식으로
		$("<h3>나는 어디 1</h3>").appendTo($("#innerBox"));
		$("<h3>나는 어디 2</h3>").prependTo($("#innerBox"));
		// 앞에 있는 내용이 박스의 형제로
		$("<h3>나는 어디 3</h3>").insertAfter($("#innerBox"));
		$("<h3>나는 어디 4</h3>").insertBefore($("#innerBox"));
		
		// 뒤에 있는 내용이 박스의 형제로
		$("#outerBox").before($('<hr size="5">'));
		$("#outerBox").after($('<hr size="10">'));
		// 뒤에 있는 내용이 박스의 자식으로
		$("#outerBox").prepend($('<hr size="5" color="red">'));
		$("#outerBox").append($('<hr size="10" color="red">'));
	});
</script>
<style type="text/css">
	 div { padding : 10px; border : 1px solid gray; margin: 10px;}
</style>
</head>
<body>
	<div id="outerBox">
		밖의 박스
		<div id="innerBox">
			안의 박스
		</div>
	</div>	
</body>
</html>