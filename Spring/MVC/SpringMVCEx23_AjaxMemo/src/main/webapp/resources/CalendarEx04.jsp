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
	
	// 날짜의 활성화/비활성화
	function validatorDate(date){ 
       return !(date.getDay()==0 || date.getDay()==6); // 일요일/토요일만 비활성화
    }
</script>
</head>
<body>
	 <h2>jQuery EasyUI 달력 - 날짜 비활성화 시키기</h2>
	 <!-- data-options="validator:함수이름" :날짜의 활성화/비활성화를 지정 가능하다. -->
	 <!-- showWeek="true" : 주표시,  weekNumberHeader="주" : 주표시 제목지정 -->
	 <div id="cc" class="easyui-calendar"  showWeek="true" weekNumberHeader="주" style="width:250px;height:250px;" data-options="validator:validatorDate"></div>
	 <br />
	 <div class="easyui-calendar" style="width:70%;height:50%;" data-options="
	 							validator:function(date){
	 								return date.getDay()!=6; // 토요일만 비활성화
	 							}
	 							"></div>
</body>
</html>