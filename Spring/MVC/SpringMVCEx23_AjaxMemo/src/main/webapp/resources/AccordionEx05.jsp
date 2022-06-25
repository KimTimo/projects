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
		 $('#aa').accordion('select',"애국가 4절"); // 제목으로 선택
	});
	// 선택
    function selectPanel(){
        $.messager.prompt('Prompt','선택할 제목을 입력해 주세요 :',function(s){
            if (s){
                $('#aa').accordion('select', s);
            }
        });
    }
	// 추가
    var idx = 2;
	/*
    function addPanel(){
        $('#aa').accordion('add',{
            title:'제목 ' + idx,
            // content:'<div style="padding:10px">내용 '+idx+'</div>'
            href : 'song4.html' // Ajax로 읽어서 내용 지정            
        });
        idx++;
    }
	*/
    function addPanel(){
        $('#aa').accordion('add',{
            title:'애국가 ' + idx + "절",
            // content:'<div style="padding:10px">내용 '+idx+'</div>'
            href : 'song'+idx+'.html', // Ajax로 읽어서 내용 지정     
            titleDirection : 'up',
            iconCls:'icon-ok'
        });
        idx++;
        if(idx==5) idx=1;
    }
    // 삭제
    function removePanel(){
        var pp = $('#aa').accordion('getSelected'); // 현재 선택된 제목
        if (pp){ // 선택이 있다면
            var index = $('#aa').accordion('getPanelIndex',pp); // 선택된 항목의 번호를 얻기
            $('#aa').accordion('remove',index); // 삭제
        }
    }	
</script>
</head>
<body>
    <div style="margin:20px 0 10px 0;"></div>
        <div style="margin:20px 0 10px 0;">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="selectPanel()">선택</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="addPanel()">추가</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="removePanel()">삭제</a>
    </div>
    <div id="aa" class="easyui-accordion" halign="left" style="width:500px;height:600px;">
        <div title="애국가 1절" data-options="iconCls:'icon-ok', href:'song1.html'" titleDirection="up" style="overflow:auto;padding:10px;">
        </div>
    	<!-- 
        <div title="애국가 2절" data-options="iconCls:'icon-ok', href:'song2.html'" style="overflow:auto;padding:10px;">
        </div>
        <div title="애국가 3절" data-options="iconCls:'icon-ok', href:'song3.html'" style="overflow:auto;padding:10px;">
        </div>
        <div title="애국가 4절" data-options="iconCls:'icon-ok', href:'song4.html'" style="overflow:auto;padding:10px;">
    	 -->
        </div>
    </div>
</body>
</html>