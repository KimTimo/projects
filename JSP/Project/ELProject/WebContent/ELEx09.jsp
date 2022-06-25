<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
<script>
	$(function(){
		
	});
</script>
</head>
<body>
	<%
	pageContext.setAttribute("num1", 33);
	pageContext.setAttribute("num2", 17);
	%>
	1. EL 산술연산자<br>
	+ , - , * , /(div) , %(mod)<br>
	num1 : ${num1 }<br>
	num2 : ${num2 }<br>
	num1 + num1 = ${num1+num2 }<br>
	num1 - num1 = ${num1-num2 }<br>
	num1 * num1 = ${num1*num2 }<br>
	num1 / num1 = ${num1/num2 }<br>
	num1 div num1 = ${num1 div num2 }<br>
	num1 % num1 = ${num1%num2 }<br>
	num1 mod num1 = ${num1 mod num2 }<br>
	2. EL 비교(관계)연산자<br>
	== 또는 eq , != 또는 ne , < 또는 lt , > 또는 gt , <= 또는 le , >= 또는 ge<br>
	num1 == num2 = ${num1 == num2 }<br>
	num1 eq num2 = ${num1 eq num2 }<br>
	num1 != num2 = ${num1 != num2 }<br>
	num1 < num2 = ${num1 < num2 }<br>
	num1 lt num2 = ${num1 lt num2 }<br>
	num1 <= num2 = ${num1 <= num2 }<br>
	num1 le num2 = ${num1 le num2 }<br>
	num1 > num2 = ${num1 > num2 }<br>
	num1 gt num2 = ${num1 gt num2 }<br>
	num1 >= num2 = ${num1 >= num2 }<br>
	num1 ge num2 = ${num1 ge num2 }<br>
	"한사람" == "한사람" = ${"한사람" == "한사람" }<br>
	'한사람' == '한사람' = ${'한사람' == '한사람' }<br>
	<br>
	3. EL 논리연산자<br>
	&& 또는 and , || 또는 or , ! 또는 not<br>
	!(num1==num2) = ${!(num1==num2) }<br>
	num1 ge num2 && num1 != 10 = ${num1 ge num2 && num1 != 10 }<br>
	num1 ge num2 || num1 != 10 = ${num1 ge num2 || num1 != 10 }<br>
	<br>
	4. EL 삼항연산자<br>
	식 ? 참 : 거짓<br>
	num1%2==0 ? "짝수" : "홀수" = ${num1%2==0 ? "짝수" : "홀수" }<br>
	<br>
	5. EL empty 연산자<br>
	empty 데이터<br>
	empty num1 = ${empty num1 }<br>
	empty num3 = ${empty num3 }<br>
	! empty num1 = ${! empty num1 }<br>
	! empty num3 = ${! empty num3 }<br>
</body>
</html>