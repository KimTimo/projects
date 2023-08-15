<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>저장하기 폼</title>
</head>
<body>
	<form action="insertTable2.jsp" method="post">
		이름 : <input type="text" name="name" required="required"><br />
		나이 : <input type="number" name="age" required="required"><br />
		성별 : 
		       <label><input type="radio" name="gender" required="required" value="M">남자</label>
		       <label><input type="radio" name="gender" required="required" value="F">여자</label>
		       <br />
		       <input type="submit" value="전송하기" />
	</form>

</body>
</html>