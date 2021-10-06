<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 영역이름 지정</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.min.js" ></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
<script type="text/javascript">

</script>
<style type="text/css">

</style>
</head>
<body>
	<h1>var변수의 값 : ${var }</h1>
	<h1>page 영역의 var변수의 값 : ${pageScope.var }</h1>
	<h1>request 영역의 var변수의 값 : ${requestScope.var }</h1>
	<h1>session 영역의 var변수의 값 : ${sessionScope.var }</h1>
	<h1>application 영역의 var변수의 값 : ${applicationScope.var }</h1>
</body>
</html>