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
<title>11. DB에 이벤트 등록하기</title>
<link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/color.css">
<link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/demo/demo.css">
<script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.min.js"></script>
<script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<!-- 날짜 관련 js 라이브러리 추가 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js" ></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/locale/ko.min.js"></script>
<!-- FullCalendar 추가 시작 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/fullcalendar@5.9.0/main.min.css">
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/fullcalendar@5.9.0/main.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/fullcalendar@5.9.0/locales-all.min.js"></script>
<!-- FullCalendar 추가 종료 -->
<script type="text/javascript">
	$(function(){
		$('#dlg').dialog('close'); // 대화상자 닫기
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
				  console.log(JSON.stringify(data)); // JSON.stringify(js객체) : js객체를 String으로 변경 ==> 객체 내용 확인
				  // alert(data.date);
				  // alert(data.dateStr); // 필요한값만 취해서 어떤일을 한다.
				  // 여기에서 새로운 일정 등록 창을 띄워줘야한다.
				  $('#dlg').dialog('open'); // 대화상자 닫기
				  // 시작날짜와 종료날짜에 날짜를 표시해주자
				  $("#_easyui_textbox_input7").val(data.dateStr);
				  $("#_easyui_textbox_input8").val(data.dateStr);
				  $("#startDate").val(data.dateStr);
				  $("#endDate").val(data.dateStr);
				  // $("#_easyui_textbox_input9").prop('disabled','disabled'); // 체크박스 선택시 시간 비활성화!!!
			  },
	          // 일정을 클릭했을 경우 이벤트
	          eventClick : function(data){
	        	  
	        	  // alert(JSON.stringify(data.event));  
	        	  console.log(JSON.stringify(data));

	        	  //--------------------------------------------------------------------------
	        	  // 여기에서 수정/삭제 창을 띄워줘야한다.
	        	  //--------------------------------------------------------------------------
	        	  $('#dlg').dialog('open'); // 대화상자 닫기
	        	  /*
	        	  alert( "이름 : " + data.event.extendedProps.username +
	        			  "\n설명 : " +data.event.extendedProps.description + 
	        			  "\n일정 : " + data.event.title + "\n시간 : " + data.event.start);
	        	  */
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
	        	  console.log(JSON.stringify(info));  
	        	  var start = info.event.start; 
	        	  var end = info.event.end; 
	        	  var idx = info.event.extendedProps._id
				
	        	  var start1 = moment(start).format("YYYY-MM-DDTHH:mm");
	        	  var end1 = moment(end).format("YYYY-MM-DDTHH:mm");
	        	  
	        	  // alert(start + '\n' + end + "\n" + idx + "\n" + start1 + "\n" + end1);
	        	  // 여기에서 Ajax를 호출하여 데이터를 수정해 주어야 한다.!!!!!!
	        	  $.ajax("${pageContext.request.contextPath}/dropUpdate", {
	        		  type:"POST",
	        		  data:{
	        			  "_id": idx,
	        			  "idx": idx,
	        			  "start": start1,
	        			  "end" : end1
	        		  },
	        		  success : function(res){
	        		      	// 화면을 갱신한다.
	        		      	location.reload();
	        		  },
	        		  error : function(){ 
	                         alert("수정 실패!!!!")
	                   }
	        	   });	        	  
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
	          eventResize :function(info){
	        	  // alert(info);
	        	  console.log(JSON.stringify(info));  
	        	  var start = info.event.start; 
	        	  var end = info.event.end; 
	        	  var idx = info.event.extendedProps._id
				
	        	  var start1 = moment(start).format("YYYY-MM-DDTHH:mm");
	        	  var end1 = moment(end).format("YYYY-MM-DDTHH:mm");
	        	  
	        	  alert(start + '\n' + end + "\n" + idx + "\n" + start1 + "\n" + end1);
	        	  
	        	  // 여기에서 Ajax를 호출하여 데이터를 수정해 주어야 한다.!!!!!!
	        	  $.ajax("${pageContext.request.contextPath}/dropUpdate", {
	        		  type:"POST",
	        		  data:{
	        			  "_id": idx,
	        			  "idx": idx,
	        			  "start": start1,
	        			  "end" : end1
	        		  },
	        		  success : function(res){
	        		      	// 화면을 갱신한다.
	        		      	location.reload();
	        		  },
	        		  error : function(){ 
	                         alert("수정 실패!!!!")
	                   }
	        	   });	        	  
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
	// 폼전송
    function submitForm(){
		var allDay = $("#allDay").prop('checked') ? 1 : 0;
		var title = $("#title").val();
		
		var start = $("#startDate").val() + "T" + $("#startTime").val() ; 
		var end = $("#endDate").val() + "T" + $("#endTime").val(); 
		
		// 여기에 기간이라면 종료에 날짜를 1일 더해준다 ------> fullCalendar가 그렇게(종료날짜가 1일 더 커야한다) 작동되기때문이다.
		if(allDay==1){
			// end의 타입은 String이다. 이것을 moment를 이용 날짜타입으로 변경하고 1일을 더하고 다시 문자로 만들어 변수에 저장
			end = moment(end,'YYYY-MM-DDThh:mm').add(1, 'days').format('YYYY-MM-DDThh:mm')
		}
		
		var type = $("#type").val(); 
		var backgroundColor = $("#backgroundColor").val();
		var textColor = $("#textColor").val();
		var username = $("#username").val();
		var description = $("#description").val();
		alert('하루종일 : ' + allDay + "\n일정이름 : " + title + "\n시작 : " + start + "\n종료 : " + end + "\n타입 : " + type
			 + "\n배경색 : " + backgroundColor + "\n글자색 : " + textColor + "\n이름 : " + username + "\n추가설명 : " + description );
		
		// 여기에서 Ajax를 호출하여 저장을 수행하고
	    $.ajax("${pageContext.request.contextPath}/insert2", {
		  type:"POST",
		  data:{
			  "title": title,
			  "start": start,
			  "end" : end,
			  "allDay" : allDay,
			  "type" : type,
			  "backgroundColor" : backgroundColor,
			  "textColor" : textColor,
			  "username" : username,
			  "description" : description
		  },
		  success : function(res){
		        // 대화상자를 닫아줘야 한다. 
		 		$('#dlg').dialog('close');
		      	// 화면을 갱신한다.
		      	location.reload();
		  },
		  error : function(){ 
                 alert("저장 실패!!!!")
           }
	     });
    }
    function cancelForm(){
        //$('#ff').form('clear');
        $('#dlg').dialog('close');
    }
    function myformatter(date){
        var y = date.getFullYear();
        var m = date.getMonth()+1;
        var d = date.getDate();
        return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
    }
    function myparser(s){
        if (!s) return new Date();
        var ss = (s.split('-'));
        var y = parseInt(ss[0],10);
        var m = parseInt(ss[1],10);
        var d = parseInt(ss[2],10);
        if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
            return new Date(y,m-1,d);
        } else {
            return new Date();
        }
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

   <!-- 아래의 내용이 대화상자 모양이다. -->
   <div id="dlg" class="easyui-dialog" title="새로운 일정 입력" data-options="iconCls:'icon-save'" style="width:600px;height:530px;padding:10px">
       <form id="ff" method="post" action="insert">
           <div style="margin-bottom:10px">
           	 <label>
           	 	하루종일 : 
                <input type="checkbox" id="allDay" name="allDay" value="1" style="width:20%" checked="checked">
           	 </label>
           </div>
           <div style="margin-bottom:10px">
               <input class="easyui-textbox" id="title" name="title" style="width:100%" data-options="label:'일정이름 : ',required:true">
           </div>
           <div style="margin-bottom:10px">
			<input class="easyui-datebox" id="startDate" name="startDate" label="시작 : " data-options="formatter:myformatter,parser:myparser,required:true" style="width:50%;">
			<input class="easyui-timepicker" id="startTime" name="startTime" value="00:00" style="width:40%;" data-options="hour24:true">
           </div>
           <div style="margin-bottom:10px">
			<input class="easyui-datebox" id="endDate" name="endDate" label="종료 : " data-options="formatter:myformatter,parser:myparser,required:true" style="width:50%;">
			<input class="easyui-timepicker" id="endTime" name="endTime" value="00:00" style="width:40%;" data-options="hour24:true">
           </div>
           <div style="margin-bottom:10px">
               <select class="easyui-combobox" name="type" id="type" label="카테고리 : " style="width:90%">
                <option value="카테고리1">카테고리1</option>
                <option value="카테고리2">카테고리2</option>
                <option value="카테고리3">카테고리3</option>
                <option value="카테고리4">카테고리4</option>
               </select>
           </div>
           <div style="margin-bottom:10px">
               <select class="easyui-combobox" name="backgroundColor" id="backgroundColor" label="배경색상 : " style="width:90%">
                    <option value="#D25565" style="color:#D25565;">빨간색</option>
                    <option value="#9775fa" style="color:#9775fa;">보라색</option>
                    <option value="#ffa94d" style="color:#ffa94d;">주황색</option>
                    <option value="#74c0fc" style="color:#74c0fc;">파란색</option>
                    <option value="#f06595" style="color:#f06595;">핑크색</option>
                    <option value="#63e6be" style="color:#63e6be;">연두색</option>
                    <option value="#a9e34b" style="color:#a9e34b;">초록색</option>
                    <option value="#4d638c" style="color:#4d638c;">남색</option>
                    <option value="#495057" style="color:#495057;">검정색</option>
               </select>
           </div>
           <div style="margin-bottom:10px">
               <select class="easyui-combobox" name=textColor id="textColor" label="글자색상 : " style="width:90%">
                    <option value="#D25565" style="color:#D25565;">빨간색</option>
                    <option value="#9775fa" style="color:#9775fa;">보라색</option>
                    <option value="#ffa94d" style="color:#ffa94d;">주황색</option>
                    <option value="#74c0fc" style="color:#74c0fc;">파란색</option>
                    <option value="#f06595" style="color:#f06595;">핑크색</option>
                    <option value="#63e6be" style="color:#63e6be;">연두색</option>
                    <option value="#a9e34b" style="color:#a9e34b;">초록색</option>
                    <option value="#4d638c" style="color:#4d638c;">남색</option>
                    <option value="#495057" style="color:#495057;" selected="selected">검정색</option>
               </select>
           </div>
           <div style="margin-bottom:10px">
               <input class="easyui-textbox" id="username" name="username" style="width:95%" data-options="label:'이름 : ',required:true">
           </div>
           <div style="margin-bottom:10px">
               <input class="easyui-textbox" id="description" name="description" style="width:100%;height:60px" data-options="label:'추가설명 : ',multiline:true">
           </div>
       </form>
       <div style="text-align:center;padding:5px 0">
           <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">저장하기</a>
           <a href="javascript:void(0)" class="easyui-linkbutton" onclick="cancelForm()" style="width:80px">취소하기</a>
       </div>
   </div>
</body>
</html>