<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>저장하기 폼</title>
</head>
<body>
	<form action="insertOk.jsp" method="post">
		이름 : <input type="text" name="name" required="required"> <br />
		나이 : <input type="number" name="age" required="required"> <br />
		성별 : 
		<label><input type="radio" name="gender" checked="checked" value="M">남자</label> 
		<label><input type="radio" name="gender" value="F">여자</label>
		<br />
		<input type="submit" value="전송하기" /> 
		<input type="button" value="돌아가기" onclick="location.href='selectList.jsp'"/> 
	</form>
</body>
</html>