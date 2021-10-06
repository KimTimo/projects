<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL로 초기화 파라메터 읽기</title>
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
	<h1>EL 사용하지 않았을 경우</h1>
	userid : <%=application.getInitParameter("userid") %> <br />
	password : <%=application.getInitParameter("password") %> <br />
	<hr />
	<h1>EL 사용했을 경우</h1>
	userid : ${initParam.userid } <br /> 
	password : ${initParam.password }<br />
</body>
</html>