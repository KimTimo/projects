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
	var max=6, min=2, index=2; // 최대개수, 최소개수, 현재 개수
	$(function(){
		$("#appendBtn").click(function(){
			if(index==max){
				alert('최대 ' + max + '개 까지만 가능합니다.');
				return;
			}
			++index;
			$("#content").append('<div id="item'+index+'"> 항목  ' + index + ' : <input type="text" name="item" size="50"> </div>');
		});
		$("#removeBtn").click(function(){
			if(index==min){
				alert('최소 ' + min + '개는 반드시 있어야만 합니다.');
				return;
			}
			$("#item"+index).remove();
			--index;
		});
	});
</script>
<style type="text/css">
</style>
</head>
<body>
	<button id="appendBtn">+</button>
	<button id="removeBtn">-</button>
	<hr />
	<div id="content">
		<div id="item1"> 항목  1 : <input type="text" name="item" size="50"> </div>
		<div id="item2"> 항목  2 : <input type="text" name="item" size="50"> </div>
	</div>
</body>
</html>