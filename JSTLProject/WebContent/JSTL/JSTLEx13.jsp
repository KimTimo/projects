<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>숫자를 이쁘게 출력하기</title>
</head>
<body>
	<c:set var="num" value="45643254789.56789" scope="request"/>
	숫자  : ${num } <br />
	<fmt:formatNumber value="${num }" var="n"/> <%-- 변수에 저장 --%>
	숫자 : ${n } <br />
	숫자 : <fmt:formatNumber value="${num }"/> <br /> <!-- var 생략시 출력 -->
	<hr />
	숫자 : <fmt:formatNumber value="${num }" groupingUsed="false"/> <br />
	숫자 : <fmt:formatNumber value="${num }" groupingUsed="true"/> <br />  <%-- 기본값 --%>

	<hr />
	숫자 : <fmt:formatNumber value="${num }" type="currency"/> <br />
	숫자 : <fmt:formatNumber value="${num }" type="percent"/> <br />
	숫자 : <fmt:formatNumber value="${num }" type="currency" currencySymbol="$" /> <br />

	<hr />
	숫자 : <fmt:formatNumber value="${num }" pattern="#,###.##"/> <br />
	숫자 : <fmt:formatNumber value="${num }" pattern="#,####원"/> <br />
	
	
</body>
</html>