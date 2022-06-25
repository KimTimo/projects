<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다른 사이트의 내용을 포함</title>
<style type="text/css">
	div{width: 400px;height: 400px; padding: 10px; border: 1px solid gray;}
</style>
<body>
	<h1>하하하하 나는 상단이다..</h1><hr />
	<%-- 다른 사이트의 내용을 여기에 표시한다. --%>
	<div>
	<c:import url="https://www.nate.com"/>
	</div>

	<hr /><h1>하하하하 나는 하단이다..</h1>
</body>
</html>