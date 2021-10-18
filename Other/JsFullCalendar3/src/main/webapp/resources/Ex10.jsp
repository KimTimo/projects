<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	if(name==null || name.trim().length()==0){
		name="모두";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>10. DB 사용자별 이벤트 표시하기</title>
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
				  // 여기에서 새로운 일정 등록 창을 띄워줘야한다.
				  // alert(data);
				  // alert(JSON.stringify(data)); // JSON.stringify(js객체) : js객체를 String으로 변경 ==> 객체 내용 확인
				  // alert(data.date);
				  // alert(data.dateStr); // 필요한값만 취해서 어떤일을 한다.
				  var title = prompt("일정명입력","새일정");
				  $.ajax("${pageContext.request.contextPath}/insert", {
					  type:"POST",
					  data:{
						  "title": title,
						  "start": data.dateStr,
						  "end" : data.dateStr
					  },
					  success : function(res){
						  alert('저장 성공!!!');
						  location.reload();
					  },
					  error : function(){ 
		                    alert("저장 실패!!!!")
		              }
				  });
			  },
	          // 일정을 클릭했을 경우 이벤트
	          eventClick : function(data){
	        	  // 여기에서 수정/삭제 창을 띄워줘야한다.
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
		          url : '${pageContext.request.contextPath}/events2',
		          method : 'POST',
		          extraParams : {
		        	  'username': '<%=name%>'
		          }
	          },
	          // 일정을 드래그앤 드롭 했을때 처리할 내용 지정
	          eventDrop : function(info){
	        	  // alert(info);
	        	  // alert(JSON.stringify(info));  
	        	  // 여기에서 Ajax를 호출하여 데이터를 수정해 주어야 한다.!!!!!!
	        	  alert('일정날짜가 변경됨!!!')
	          },
	          /*
	          // 일정 밖으로 마우스가 나갈때 이벤트 지정
	          eventMouseLeave : function(info){
	        	  // alert(info);
	        	  // alert(JSON.stringify(info));
	        	  alert('마우스 포인터가 일정 밖으로 들어옴!!!');
	          },
	          // 일정 안으로 마우스가 들어올때 이벤트 지정
	          eventMouseEnter : function(info){
	        	  // alert(info);
	        	  // alert(JSON.stringify(info));
	        	  alert('마우스 포인터가 일정 안으로 나감!!!');
	          },
	          */
	          // 일정의 크기를 변경했을때 처리할 내용 지정
	          eventResizeStop :function(info){
	        	  // alert(info);
	        	  // alert(JSON.stringify(info));  
	        	  // 여기에서 Ajax를 호출하여 데이터를 수정해 주어야 한다.!!!!!!
	        	  alert('일정의 크기가 변경됨')
	          },
	          
	     });
	     
	     // 달력을 그려라!!!!
	     calendar.render();
	});
	// 이름을 클릭하면 실행될 함수
	function nameFilter(name){
		// alert(name + "선택!!!");
		location.href = "?name=" + encodeURI(name); // 자신을 이름을 가지고 호출
		return false;
	}
</script>
<style type="text/css">
	#calendar { width: 95%; margin: auto;} <!-- 달력의 폭과 정렬 변경, 높이는 않됨 -->
</style>
</head>
<body>
<a href="${pageContext.request.contextPath }/">홈으로</a>
<hr />
<a href="javascript:nameFilter('정연')">정연</a> 
<a href="javascript:nameFilter('다현')">다현</a> 
<a href="javascript:nameFilter('사나')">사나</a> 
<a href="javascript:nameFilter('나연')">나연</a> 
<a href="javascript:nameFilter('지효')">지효</a> 
<a href="javascript:nameFilter('모두')">전체일정보기</a> 
<hr />
<div id='calendar'></div>
</body>
</html>