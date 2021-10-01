<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EsayUI 연습 1</title>
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/color.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/demo/demo.css">
    <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$('#dlg').dialog('close'); // 대화상자 닫기
		});
	</script>
</head>
<body>
	<h2>기본 Dialog</h2>
    <div style="margin:20px 0;">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#dlg').dialog('open')">열기</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#dlg').dialog('close')">닫기</a>
    </div>
    <!-- 아래의 내용이 대화상자 모양이다. -->
    <div id="dlg" class="easyui-dialog" title="기본 Dialog" data-options="iconCls:'icon-save'" style="width:400px;height:200px;padding:10px">
        여기에 표시하고자하는 내용을 쓰면되지롱!! <br />
        하하하하 <br />
    </div>
</body>
</html>