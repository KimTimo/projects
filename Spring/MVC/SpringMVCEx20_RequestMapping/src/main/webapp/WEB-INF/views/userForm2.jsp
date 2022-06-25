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
	<h1>JSP로보기</h1>
	<form action="user1" method="post">
		<input type="hidden" name="p" value="7">
		<input type="hidden" name="b" value="10">
		<input type="hidden" name="s" value="5">
		번호 : <input type="text" name="idx"><br>
		이름 : <input type="text" name="name"><br>
		나이 : <input type="text" name="age"><br>
		<input type="submit" value="저장">
	</form>
	<br /><hr />
	<h1>XML로 보기</h1>
	<%-- EL과 JSTL만을 이용하여 화면을 구성한다. --%>
	<form action="user2.xml" method="post">
		번호 : <input type="number" name="idx"><br>
		이름 : <input type="text" name="name"><br>
		나이 : <input type="number" name="age"><br>
		<input type="submit" value="저장">
	</form>
	<h1>JSON으로 보기</h1>
	<%-- EL과 JSTL만을 이용하여 화면을 구성한다. --%>
	<form action="user2.json" method="post">
		번호 : <input type="number" name="idx" min="1"><br>
		이름 : <input type="text" name="name"><br>
		나이 : <input type="number" name="age" max="100" min="20"><br>
		<input type="submit" value="저장">
	</form>
</body>
</html>