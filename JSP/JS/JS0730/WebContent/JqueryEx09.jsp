<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JQuery 연습 : 폼제어</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		//alert($("#cancelBtn").css('display'));
		//alert($("#updateForm").attr('action'));
	});
	
	function editForm(idx){
		// 폼의 값을 채워주고
		$("#idx").val($("#idx"+idx).html());
		$("#name").val($("#name"+idx).html());
		$("#content").val($("#content"+idx).html());

		// 폼의 액션 속성을 변경
		$("#updateForm").attr('action','updateOk.jsp');
		// 버튼의 제목을 "수정하기"로 변경
		$("#submitBtn").val("수정하기")
		// 취소 버튼을 보이게 한다.
		$("#cancelBtn").css('display','inline');
	}
	function deleteForm(idx){
		// 폼의 값을 채워주고
		$("#idx").val($("#idx"+idx).html());
		$("#name").val($("#name"+idx).html());
		$("#content").val($("#content"+idx).html());
		// 폼의 액션 속성을 변경
		$("#updateForm").attr('action','deleteOk.jsp');
		// 버튼의 제목을 "삭제하기"로 변경
		$("#submitBtn").val("삭제하기")
		// 취소 버튼을 보이게 한다.
		$("#cancelBtn").css('display','inline');
	}
	function resetForm(){
		// 폼의 값을 비워주고
		$("#idx").val(0);
		$("#name").val("");
		$("#content").val("");
		// 폼의 액션 속성을 변경
		$("#updateForm").attr('action','insertOk.jsp');
		// 버튼의 제목을 "저장하기"로 변경
		$("#submitBtn").val("저장하기")
		// 취소 버튼을 숨긴다.
		$("#cancelBtn").css('display','none');
	}
</script>
<style type="text/css">
	div { border:1px solid gray; padding:5px; margin: 2px;}
</style>
</head>
<body>
	<div>
		<span id="idx1">1</span>
		<span id="name1">한사람1</span>
		<span id="content1">나는 내용입니다.1111</span>
		<button onclick="editForm(1)">수정</button>
		<button onclick="deleteForm(1)">삭제</button>
	</div>
	<div>
		<span id="idx2">2</span>
		<span id="name2">한사람2</span>
		<span id="content2">나는 내용입니다.2222</span>
		<button onclick="editForm(2)">수정</button>
		<button onclick="deleteForm(2)">삭제</button>
	</div>
	<div>
		<span id="idx3">3</span>
		<span id="name3">한사람3</span>
		<span id="content3">나는 내용입니다.3333</span>
		<button onclick="editForm(3)">수정</button>
		<button onclick="deleteForm(3)">삭제</button>
	</div>
	<form action="insertOk.jsp" method="post" id="updateForm">
		<input type="hidden" id="idx" value="0" />
		<input type="text" id="name" placeholder="이름 입력" required="required"/>
		<input type="password" id="password" placeholder="암호입력" required="required"/>
		<input type="text" id="content" name="content" size="60" placeholder="내용입력" required="required" />
		<input type="submit" id="submitBtn" value="저장하기"/>
		<input type="button" id="cancelBtn" value="취소하기" style="display: none;" onclick="resetForm()"/>
	</form>
</body>
</html>