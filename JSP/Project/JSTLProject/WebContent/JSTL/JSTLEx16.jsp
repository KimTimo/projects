<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value='${empty param.lo ? "ko":param.lo }' /> 
<fmt:requestEncoding  value="UTF-8"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>국제화기능 지원하기</title>
</head>
<body>
	<fmt:setBundle basename="message" />
	<a href="?lo=ko">KOR</a>
	<a href="?lo=en">ENG</a> 
	<a href="?lo=zh">때놈</a>
	<a href="?lo=ja">쪽바리</a> <br />
	<hr />
	<h1><fmt:message key="TITLE"  var="title"/> ${title }</h1>
	<fmt:message key="GREETING" /> <br />
	<fmt:message key="BODY" /> <br />
	<fmt:message key="COMPANY_NAME" /> <br />
</body>
</html>