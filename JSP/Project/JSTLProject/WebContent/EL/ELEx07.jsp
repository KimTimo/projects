<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL로 같은 이름 여러개 파라메터 읽기</title>
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
	<h1>주소표시줄에 다음을 추가하고 실행해봐!!! ?a=1&a=2&a=3</h1>
	<h1>EL 사용하지 않았을 경우</h1>
	a : <%=request.getParameterValues("a")[0] %> <br />
	a : <%=request.getParameterValues("a")[1] %> <br />
	a : <%=request.getParameterValues("a")[2] %> <br />
	<hr />
	<h1>EL 사용했을 경우</h1>
	a : ${paramValues.a[0] } <br /> 
	a : ${paramValues.a[1] } <br /> 
	a : ${paramValues.a[2] } <br /> 
</body>
</html>