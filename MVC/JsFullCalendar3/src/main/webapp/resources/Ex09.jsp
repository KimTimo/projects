<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>9. DB 이벤트 표시하기</title>
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
	          locale : 'ko', // 언어를 한글로 변경
	          // height : '500px', // 높이 변경
	          // 툴바를 변경해보자
	          headerToolbar : {
	        	  left : 'dayGridMonth,dayGridWeek,dayGridDay',
	        	  center : 'title',
	        	  right : 'prevYear,prev,next,nextYear today'
	          },
	          // 수정 가능 지정
	          editable : true,
	          //----------------------------------------------------------------
			  // 날짜를 클릭했을 경우 이벤트 
			  dateClick : function(data){
				  // alert(data);
				  // alert(JSON.stringify(data)); // JSON.stringify(js객체) : js객체를 String으로 변경 ==> 객체 내용 확인
				  // alert(data.date);
				  alert(data.dateStr); // 필요한값만 취해서 어떤일을 한다.
			  },
	          // 일정을 클릭했을 경우 이벤트
	          eventClick : function(data){
	        	  // alert(JSON.stringify(data.event));  
	        	  alert( "이름 : " + data.event.extendedProps.username +
	        			  "\n설명 : " +data.event.extendedProps.description + 
	        			  "\n일정 : " + data.event.title + "\n시간 : " + data.event.start);  
	          },
	          //----------------------------------------------------------------
	          // 초기 이벤트 지정
	          // events : 'events.json'
	          // events : 'events.jsp'
	          events : {
		         url : '${pageContext.request.contextPath}/events',
		         method : 'POST'
	          }
	     });
	     
	     // 달력을 그려라!!!!
	     calendar.render();
	});
</script>
<style type="text/css">
	#calendar { width: 95%; margin: auto;} <!-- 달력의 폭과 정렬 변경, 높이는 않됨 -->
</style>
</head>
<body>
<a href="${pageContext.request.contextPath }/">홈으로</a>
<hr />
<div id='calendar'></div>
</body>
</html>