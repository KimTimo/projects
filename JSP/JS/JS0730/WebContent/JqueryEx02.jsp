<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JQuery 연습 : 속성 검사 및 변경</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		// alert($('img').attr('src')); // 속성 얻기
		$('img').attr('alt', $('img').attr('src')); // 속성 변경
		// 속성 추가
		$('img').attr('title', $('img').attr('src'));
		/*
		$('img').attr('width', '150');
		$('img').attr('height', function(i){
			return (i+1)*50;
		});
		*/
		// 객체를 전달해서 여러개 속성을 1번에 변경
		$("img").attr({
			height : 100,
			width : function(i){
				return (i+1)*50;
			}
		});
		// 속성을 제거하자
		$('img').removeAttr("title");
		
	});
</script>
<style type="text/css">
	 
</style>
</head>
<body>
	<img src="images/penguin0.jpg" alt="팽귄 그림 1" /> <br />
	<img src="images/penguin1.jpg" alt="팽귄 그림 2" /> <br />
	<img src="images/penguin2.jpg" alt="팽귄 그림 3" /> <br />
	<img src="images/penguin3.jpg" alt="팽귄 그림 4" /> <br />
	<img src="images/penguin4.jpg" alt="팽귄 그림 5" /> <br />
	<img src="images/penguin5.jpg" alt="팽귄 그림 6" /> <br />
	<img src="images/penguin6.jpg" alt="팽귄 그림 7" /> <br />
	<img src="images/penguin7.jpg" alt="팽귄 그림 8" /> <br />
	<img src="images/penguin8.jpg" alt="팽귄 그림 9" /> <br />
	<img src="images/penguin9.jpg" alt="팽귄 그림 10" /> <br />
</body>
</html>