<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JQuery 연습 : 객체의 이동</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('img').attr('alt', $('img').attr('src'))		
		$('img').attr('title', $('img').attr('src'))	
		
		setInterval(function() {
			$('img').first().appendTo('body');
		}, 1000);
	});
</script>
<style type="text/css">
img {
	padding: 10px;
	border: 1px solid gray;
	margin: 10px;
	width: 150px;
	height: 150px;
	border-radius: 30px;
}
</style>
</head>
<body>
	img[src='images/penguin$.jpg']*5 <br /><hr />
	<img src="images/penguin1.jpg" alt="" />
	<img src="images/penguin2.jpg" alt="" />
	<img src="images/penguin3.jpg" alt="" />
	<img src="images/penguin4.jpg" alt="" />
	<img src="images/penguin5.jpg" alt="" />
</body>
</html>