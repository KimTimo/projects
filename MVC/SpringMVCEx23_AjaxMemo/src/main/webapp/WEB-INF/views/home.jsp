<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여기에는 제목</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {
		getAll();
	});
	function dateFormat(date) {
		let month = date.getMonth() + 1;
		let day = date.getDate();
		let hour = date.getHours();
		let minute = date.getMinutes();
		let second = date.getSeconds();

		month = month >= 10 ? month : '0' + month;
		day = day >= 10 ? day : '0' + day;
		hour = hour >= 10 ? hour : '0' + hour;
		minute = minute >= 10 ? minute : '0' + minute;
		second = second >= 10 ? second : '0' + second;

		return date.getFullYear() + '-' + month + '-' + day + ' ' + hour + ':' + minute + ':' + second;
	}
	function getAll() {
		// alert('눌렀냐?');
		$.ajax("rest/selectAll", {
			type : "get",
			dataType : "json",
			success : function(data) {
				// alert(JSON.stringify(data));
				$("#result").html("");
				for ( var i in data) {
					$("#result").append(
							data[i].idx
									+ ". "
									+ data[i].name
									+ " : "
									+ data[i].content
									+ "("
									+ data[i].ip
									+ ", "
									+ dateFormat(new Date(data[i].regDate)) + ")" 
									+ " <button class='btn btn-outline-success btn-sm' onclick='memoUpdate("+data[i].idx+")'>수정</button>"
									+ " <button class='btn btn-outline-success btn-sm' onclick='memoDelete("+data[i].idx+")'>삭제</button>"
									+ "<br>");
				}
			},
			error : function() {
				alert('에러다!!!!');
			}
		});
	}
	function memoInsert(){
		var idx = $("#idx").val();
		var mode = $("#mode").val();
		var name = $("#name").val();
		if(!name || name.trim().length==0){
			alert('이름은 반드시 입력해야 합니다.');
			$("#name").val("");
			$("#name").focus();
			return false;
		}
		var password = $("#password").val();
		if(!password || password.trim().length==0){
			alert('비밀번호는 반드시 입력해야 합니다.');
			$("#password").val("");
			$("#password").focus();
			return false;
		}
		var content = $("#content").val();
		if(!content || content.trim().length==0){
			alert('내용은 반드시 입력해야 합니다.');
			$("#content").val("");
			$("#content").focus();
			return false;
		}
		// alert(name + "\n" + password + "\n" + content);
		// 여기서 Ajax를 이용하여 저장을 수행한다.
		$.ajax("rest/update", {
			type : "get",
			data : {"idx":idx,"mode":mode,"name":name, "password":password, "content":content},
			success : function(data){
				// alert('성공')
				// 하단의 목록을 갱신한다.
				getAll();
				// 폼을 원래대로 되돌린다.
				resetForm();
			},
			error : function(){
				alert("Insert에러!!!");
			}
		});
	}
	function resetForm(){
		$("#idx").val("0");
		$("#mode").val("insert");
		$("#name").val("");
		$("#password").val("");
		$("#content").val("");
		$("#submitBtn").html("저장");
		$("#cancelBtn").css('display','none');
		$("#name").focus();
	}
	function memoUpdate(idx){
		// idx번의 글을 읽어서 폼에 표시를 해준다. 
		$("#idx").val(idx);
		$("#mode").val("update");
		$("#submitBtn").html("수정");
		$("#cancelBtn").css('display','inline');
		
		$.ajax("rest/select/"+idx+".json", {
			type : "get",
			data : {"idx":idx},
			success : function(data){
				// alert(JSON.stringify(data));
				$("#name").val(data.name);
				$("#password").val("");
				$("#content").val(data.content);
				$("#password").focus();
			},
			error : function(){
				alert("Update에러!!!");
			}
		});
	}
	function memoDelete(idx){
		// idx번의 글을 읽어서 폼에 표시를 해준다. 
		$("#idx").val(idx);
		$("#mode").val("delete");
		$("#submitBtn").html("삭제");
		$("#cancelBtn").css('display','inline');
		$.ajax("rest/select/"+idx+".json", {
			type : "get",
			data : {"idx":idx},
			success : function(data){
				// alert(JSON.stringify(data));
				$("#name").val(data.name);
				$("#password").val("");
				$("#content").val(data.content);
				$("#password").focus();
			},
			error : function(){
				alert("Delete에러!!!");
			}
		});
	}
</script>
<style type="text/css">
.result {
	margin: 5px;
	padding: 5px;
	border: 1px solid gray;
}
</style>
</head>
<body>
	<!-- 
	<button onclick="getAll()">모두 가져오기</button>
	-->
	<div>
		<input type="text" id="idx" name="idx" size="3" value="0" readonly="readonly"/>
		<input type="text" id="mode" name="mode" size="3" value="insert" readonly="readonly"/>
		<input type="text" id="name" name="name" placeholder="이름" />
		<input type="password" id="password" name="password" placeholder="비밀번호" />
		<input type="text" id="content" name="content" placeholder="내용" size="60" />
		<button id="submitBtn" onclick="memoInsert()" class='btn btn-outline-success btn-sm' >저장</button>
		<button id="cancelBtn" onclick="resetForm()" class='btn btn-outline-success btn-sm' style="display: none;">취소</button>
	</div>

	<hr />
	<div id="result" class="result">여기에 목록이 나온다.</div>
</body>
</html>