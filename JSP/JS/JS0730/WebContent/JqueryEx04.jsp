<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JQuery 연습 : 객체의 제거</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('h1').first().remove(); // h1태그 첫번째 제거
		$('div').eq(1).empty();   // div태그 2번째것 안의 모든 내용 제거
	});
</script>
<style type="text/css">
	 
</style>
</head>
<body>
	(div>h1{나는 제목 $$}*2)*2
	<div>
		<h1>나는 제목 01</h1>
		<h1>나는 제목 02</h1>
	</div>
	<div>
		<h1>나는 제목 01</h1>
		<h1>나는 제목 02</h1>
	</div>
	
</body>
</html>