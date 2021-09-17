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
	
	});
</script>
</head>
<body>
<h2>Basic Accordion Ajax</h2>
    <div style="margin:20px 0 10px 0;"></div>
    <div class="easyui-accordion" style="width:500px;height:300px;">
        <div title="애국가 1절" data-options="iconCls:'icon-ok', href:'song1.html'" style="overflow:auto;padding:10px;">
        </div>
        <div title="애국가 2절" data-options="iconCls:'icon-ok', href:'song2.html'" style="overflow:auto;padding:10px;">
        </div>
        <div title="애국가 3절" data-options="iconCls:'icon-ok', href:'song3.html'" style="overflow:auto;padding:10px;">
        </div>
        <div title="애국가 4절" data-options="iconCls:'icon-ok', href:'song4.html'" style="overflow:auto;padding:10px;">
        </div>
    </div>
</body>
</html>