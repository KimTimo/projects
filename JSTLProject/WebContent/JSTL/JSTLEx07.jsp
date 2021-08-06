<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core 태그 연습</title>
</head>
<body>
	<c:set var="str" value="한놈 두식이 석삼 너구리 오징어 육계장 칠면조" scope="request"/>
	<c:forTokens var="item" items="${str }" delims=" ">
		${item } <br />
	</c:forTokens>
	<hr />
	<c:set var="str" value="한놈,두식이.석삼-너구리=오징어/육계장~칠면조" scope="request"/>
	<c:forTokens var="item" items="${str }" delims=",.-=/~">
		${item } <br />
	</c:forTokens>
	<hr />
</body>
</html>