<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>있는 그대로 출력하기(태그 무시)</title>
<style type="text/css">
	div{width: 400px;height: 400px; padding: 10px; border: 1px solid gray;}
</style>
<body>
	<c:set var="content" value="<h1>나의 이름은 <u>한사람</u>입니다.</h1>"/>
	${content } <br />
	
	<c:out value="${content }"/> <br />
	<c:out value="${content }" escapeXml="true"/> <br />
	<c:out value="${content }" escapeXml="false"/> <br />
	<hr />
	<c:out value="${str }"/> <br />
	<c:out value="${str }" default="기본값표시"/> <br />
</body>
</html>