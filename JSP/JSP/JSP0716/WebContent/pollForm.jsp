<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투표 등록하기 폼</title>
<style type="text/css">
table {
	width: 700px;
	margin: auto;
	border: none;
}

.title {
	border: none;
	text-align: center;
	font-size: 18pt;
}

th {
	border: 1px solid gray;
	background-color: silver;
	padding: 5px;
}

td {
	border: 1px solid gray;
	padding: 5px;
}

input[type="text"] {
	line-height: 15px;
	font-size: 14pt;
}
</style>
<script type="text/javascript">
    function formCheck() {
    	var obj = document.getElementById("title");
    	if(!obj.value || obj.value.trim().length==0){
    		alert("제목을 입력해야 합니다.");
    		obj.value="";
    		obj.focus();
    		return false;
    	}
    	var obj = document.getElementById("start");
    	if(!obj.value || obj.value.trim().length==0){
    		alert("시작일을 입력해야 합니다.");
    		obj.value="";
    		obj.focus();
    		return false;
    	}
    	var obj = document.getElementById("end");
    	if(!obj.value || obj.value.trim().length==0){
    		alert("종료일을 입력해야 합니다.");
    		obj.value="";
    		obj.focus();
    		return false;
    	}
    	for(var i = 1; i <= 2; i++){
    		var obj = document.getElementById("item" + i);
        	if(!obj.value || obj.value.trim().length==0){
        		alert('항목' + i + '을 입력해야 합니다.');
        		obj.value="";
        		obj.focus();
        		return false;
        	}
    	}
    	return true;
	}
</script>
</head>
<body>
	<form action="pollInsertOk.jsp" method="post"
		onsubmit="return formCheck()">
		<table>
			<tr>
				<td colspan="4" class="title">투표 등록하기</td>
			</tr>
			<tr>
				<th width="20%" align="right">제목 :</th>
				<td colspan="3"><input type="date" size="60" name="title"
					id="title" /></td>
			</tr>
			<tr>
				<th align="right">시작일 :</th>
				<td><input type="date" name="start" id="start" /></td>
			</tr>
			<tr>
				<th align="right" width="20%">종료일 :</th>
				<td><input type="date" name="end" id="end" /></td>
			</tr>
			<%for(int i = 0; i < 10; i++){ %>
			<tr>
				<th align="right">항목 <%=i+1 %> :
				</th>
				<td colspan="3"><input type="text" size="60" name="item"
					id="item<%=i+1 %>"/></td>

			</tr>
			<%} %>
			<tr>
				<td colspan="4" class="title"><input type="submit" value="저장하기">
					<input type="reset" value="다시쓰기"> <input type="button"
					value="돌아가기" onclick="location.href='list.jsp'"></td>
			</tr>



		</table>
	</form>

</body>
</html>