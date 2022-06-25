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
<!-- EasyUI 설정 시작 -->
<link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/color.css">
<link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/demo/demo.css">
<!-- 
<script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.min.js"></script>
 -->
<script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<!-- EasyUI 설정 종료 -->

<script type="text/javascript">
	$(function(){
		$('#cc').calendar({firstDay:0}); // 최초에 첫번째 요일이 금요일이 된다.
		
		
	});
	// 난수로 임의의 날짜를 생성
	var d1 = Math.floor((Math.random()*30)+1); 
	var d2 = Math.floor((Math.random()*30)+1);
	
	
	// 임의의 날짜에 아이콘 달기
	function formatDay(date){ // 날짜의 모양을 지정
       var m = date.getMonth()+1; 	// 월
       var d = date.getDate(); 		// 일
       var opts = $(this).calendar('options'); // 옵션읽기
       if (opts.month == m && d == d1){ // 같은달 위에서 구한 날짜와 같다면
           return '<div class="icon-ok md">' + d + '</div>'; // 날짜모양 변경
       } else if (opts.month == m && d == d2){
           return '<div class="icon-search md">' + d + '</div>';
       }
       // 일요일에 모두 체크 표시를 하시오!!!!
       if(date.getDay()==0){
    	   return '<div class="icon-ok"><b>' + d + '</b></div>';
       }
       return d;
    }
</script>
</head>
<body>
	 <h2>jQuery EasyUI 달력 - Custom Calendar</h2>
	 <!-- data-options="formatter:함수이름" : 날짜의 모양을 변경하는 함수를 지정 가능하다. -->
	 <div id="cc" class="easyui-calendar" style="width:250px;height:250px;" data-options="formatter:formatDay"></div>
</body>
</html>