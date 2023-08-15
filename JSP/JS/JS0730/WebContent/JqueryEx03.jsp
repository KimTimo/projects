<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JQuery 연습 : 태그내의 값 얻기/변경하기</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#btn1").click(function(){
			alert($('span').eq(0).html() + "\n" + $('span').eq(1).text());
		});
		$("#btn2").click(function(){
			$('span').eq(0).text('<h1>♥</h1>').css('color','red');
			$('span').eq(1).html('<h1>♥</h1>').css('color','red');
		});
		$("#btn3").click(function(){
			$('span').eq(2).text( $('span').eq(2).text() + $('span').eq(0).text());
		});
		$("#btn4").click(function(){
			$('span').eq(3).html(function (index, html) { // 첫번째 인수는 위치값, 두번째 인수는 값
				return '♥' + html + '♥';
			});
		});
		
	});
</script>
<style type="text/css">
	 
</style>
</head>
<body>
	(span{★}+button[id=btn$]{눌러줘 $}+br)*3 <br />
	<span>★</span>
	<button id="btn1">눌러줘 1</button>
	<br />
	<span>★</span>
	<button id="btn2">눌러줘 2</button>
	<br />
	<span>★</span>
	<button id="btn3">눌러줘 3</button>
	<br />
	<span>★</span>
	<button id="btn4">눌러줘 4</button>
	<br />
	
</body>
</html>