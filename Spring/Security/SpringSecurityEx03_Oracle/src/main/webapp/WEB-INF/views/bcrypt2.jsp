<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비번 비교하기</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function(){
	
	});
</script>
</head>
<body>
	${newPassword } <br />
	${dbPassword } <br />
	${isCheck1 ? "일치":"불일치" } <br />
	${isCheck2 ? "일치":"불일치" } <br />
	<a href="${pageContext.request.contextPath }">홈으로</a>
</body>
</html>