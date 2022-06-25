<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- EL과 JSTL만을 이용하여 화면을 구성한다. --%>
	<form action="userInsertOk" method="post">
		<input type="hidden" name="p" value="7">
		<input type="hidden" name="b" value="10">
		<input type="hidden" name="s" value="5">
		번호 : <input type="text" name="idx"><br>
		이름 : <input type="text" name="name"><br>
		나이 : <input type="text" name="age"><br>
		<input type="submit" value="저장">
	</form>
</body>
</html>