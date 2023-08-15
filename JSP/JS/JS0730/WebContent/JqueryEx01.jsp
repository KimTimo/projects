<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JQuery 연습 : class 추가 및 제거</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#btn1").click(function () {
			$("h2").addClass("item1");
		});
		$("#btn2").click(function () {
			$("h2").removeClass("item1");
		});
		$("#btn3").click(function () {
			$("h2").addClass(function( index ) {
				return "item" + (index+1);
			});
		});
		$("#btn4").click(function () {
			$("h2").removeClass(function( index ) {
				return "item" + (index+1);
			});
		});
		// toggleClass : 적용/해제 반복
		$("#btn5").click(function () {
			$("h2").toggleClass(function( index ) {
				return "item" + (index+1);
			});
		});
	});
</script>
<style type="text/css">
	.item1 {color : red;}
	.item2 {color : green;}
	.item3 {color : blue;}
	.item4 {color : pink;}
	.item5 {color : silver;}
</style>
</head>
<body>
	<button id="btn1">모든 h2에 동일한 클래스 적용하기</button>
	<button id="btn2">모든 h2에 클래스 제거하기</button>
	<button id="btn3">h2에 각각 다른 클래스 적용하기</button>
	<button id="btn4">h2에 각각 다른 클래스 제거하기</button>
	<button id="btn5">클래스 토글시키기</button><br /><hr />
	h2{아이템 $$}*5
	<h2>아이템 01</h2>
	<h2>아이템 02</h2>
	<h2>아이템 03</h2>
	<h2>아이템 04</h2>
	<h2>아이템 05</h2>
</body>
</html>