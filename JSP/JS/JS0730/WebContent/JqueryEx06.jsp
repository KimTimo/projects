<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JQuery 연습 : 객체의 삽입</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	var address = [
		{name:'한사람',addr:'서울시 용산구'},
		{name:'두사람',addr:'서울시 도봉구'},
		{name:'세사람',addr:'서울시 강남구'},
		{name:'네사람',addr:'성남시 분당구'},
		{name:'오사람',addr:'용인시 처인구'}
	];
	$(function() {
		$('div').append(function(index){
			return "<h2>" + address[index].name + "</h2><h3>" + address[index].addr + "</h3>";
		});
	});
</script>
<style type="text/css">
div {
	padding: 10px;
	border: 1px solid gray;
	margin: 10px;
	width: 150px;
	height: 100px;
	border-radius: 30px;
	float: left;
	text-align: center;
}
</style>
</head>
<body>
	<div></div>
	<div></div>
	<div></div>
	<div></div>
	<div></div>
</body>
</html>