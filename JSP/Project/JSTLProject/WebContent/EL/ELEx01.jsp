<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL(expression language : 표현언어)</title>
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
	<h1>EL(expression language : 표현언어)</h1>
	<hr />
	표현식을 대체하는 언어이다!!!. 앞으로는 JSP파일에 표현식을 쓰면 죽는다~~~ <br />
	<%
		int sum = 0;
		for(int i=1;i<=100;i++) sum += i;
		// 추가적으로 4개의 영역 중에 저장을 해놓으면 EL로 간단하게 출력이 가능하다.
		request.setAttribute("sum", sum);
	%>
	1 ~ 100 까지 합  : <%=sum %> <br />
	1 ~ 100 까지 합  : ${sum } <br />
	
</body>
</html>