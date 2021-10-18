<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여기에는 제목</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<!-- 날짜 관련 js 라이브러리 추가 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js" ></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/locale/ko.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("body").append("하하하하하<br>");
		$("body").append(moment() + "<br>"); // 현재날짜
		$("body").append(moment().format('MMMM Do YYYY, h:mm:ss a') + "<br>"); // 원하는 문자열로 변경
		$("body").append(moment().format('YYYY-MM-DDThh:mm') + "<br>");
		$("body").append(moment('2019-05-07T09:30','YYYY-MM-DDThh:mm') + "<br>"); // 날짜읽기
		$("body").append(moment('2019-05-07T09:30','YYYY-MM-DDThh:mm').format('YYYY-MM-DDThh:mm')  + "<br>"); // 읽어 원하는 문자열로 변경
		$("body").append(moment('2019-05-07T09:30','YYYY-MM-DDThh:mm').add(1, 'days').format('YYYY-MM-DDThh:mm')  + "<br>"); // 읽어 원하는 문자열로 변경
		$("body").append(moment('2019-05-07T09:30','YYYY-MM-DDThh:mm').subtract(1, 'days').format('YYYY-MM-DDThh:mm')  + "<br>"); // 읽어 원하는 문자열로 변경
		
	});
</script>
</head>
<body>

</body>
</html>