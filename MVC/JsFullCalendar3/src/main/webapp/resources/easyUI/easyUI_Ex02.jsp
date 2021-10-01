<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EsayUI 연습 2</title>
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/color.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/demo/demo.css">
    <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript">
		$(function(){
			// $('#dlg').dialog('close'); // 대화상자 닫기
		});
		// 폼전송
        function submitForm(){
			
			var allDay = $("#allDay").prop('checked') ? 1 : 0;
			var title = $("#title").val();
			var start = $("#startDate").val() + (allDay==0 ? "T" + $("#startTime").val() : ""); 
			var end = $("#endDate").val() + (allDay==0 ? "T" + $("#endTime").val() : ""); 
			var type = $("#type").val(); 
			var backgroundColor = $("#backgroundColor").val();
			var textColor = $("#textColor").val();
			var username = $("#username").val();
			var description = $("#description").val();
			alert('하루종일 : ' + allDay + "\n일정이름 : " + title + "\n시작 : " + start + "\n종료 : " + end + "\n타입 : " + type
				 + "\n배경색 : " + backgroundColor + "\n글자색 : " + textColor + "\n이름 : " + username + "\n추가설명 : " + description );
			
			
            // $('#ff').form('submit');
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
</head>
<body>
	<h2>기본 Dialog</h2>
    <div style="margin:20px 0;">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#dlg').dialog('open')">열기</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#dlg').dialog('close')">닫기</a>
    </div>
    <!-- 아래의 내용이 대화상자 모양이다. -->
    <div id="dlg" class="easyui-dialog" title="새로운 일정 입력" data-options="iconCls:'icon-save'" style="width:600px;height:500px;padding:10px">
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