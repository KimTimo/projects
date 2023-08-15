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
	<%-- 
	JSTLEx04.jsp에서 두개의 값을 받아서 
	나이가 20세 미만이면 ???씨는 미성년입니다. 
	나이가 20세 이상이면 ???씨는 성년입니다. 
	를 출력하는 프로그램을 JSTL과 EL만으로 완성하시오!!!!
	--%>
	<form action="JSTLEx04.jsp" method="post">
		<input type="text" name="name" placeholder="이름입력" required="required"/>
		<input type="number" name="age" placeholder="나이입력" required="required"/>
		<input type="submit" value="전송" />
	</form>
</body>
</html>