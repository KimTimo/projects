<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2. 로케일(국가/언어) 변경하기</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<!-- FullCalendar 추가 시작 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/fullcalendar@5.9.0/main.min.css">
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/fullcalendar@5.9.0/main.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/fullcalendar@5.9.0/locales-all.min.js"></script>
<!-- FullCalendar 추가 종료 -->
<script type="text/javascript">
	$(function(){
		 // DOM 객체 찾기 : id값이  calendar인 요소 찾기
		 var calendarEl = document.getElementById('calendar');
		 // 달력객체 생성 : new FullCalendar.Calendar(돔요소, 옵션);
	     var calendar = new FullCalendar.Calendar(calendarEl, {
	          initialView: 'dayGridMonth', // 월달력
	          // initialView: 'dayGridWeek', // 주달력
	          // initialView: 'dayGridDay', // 일달력
	          locale : 'ko', // 언어를 한글로 변경
	          height : '500px' // 높이 변경
	     });
	     // 달력을 그려라!!!!
	     calendar.render();
	});
</script>
<style type="text/css">
	#calendar { width: 80%; margin: auto; height: 80%;} <!-- 달력의 폭과 정렬 변경, 높이는 않됨 -->
</style>
</head>
<body>
<a href="${pageContext.request.contextPath }/">홈으로</a>
<hr />

<div id='calendar'></div>

</body>
</html>