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
<h2>Basic Accordion</h2>
    <p>애국가</p>
    <div style="margin:20px 0 10px 0;"></div>
    <div class="easyui-accordion" style="width:500px;height:300px;">
        <div title="애국가 1절" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
            <h3 style="color:#0099FF;">애국가 1절</h3>
            <p>
            동해물과 백두산이 마르고 닳도록
			하느님이 보우하사 우리나라만세
			(후렴)무궁화 삼천리 화려강산 대한사람 대한으로 길이 보전하세
            </p>
        </div>
        <div title="애국가 2절" data-options="iconCls:'icon-ok'" style="padding:10px;">
 			<h3 style="color:#0099FF;">애국가 2절</h3>
            <p>
			남산위에 저 소나무 철갑을 두른듯
			바람서리 불변함은 우리기상 일세
			(후렴)무궁화 삼천리 화려강산 대한사람 대한으로 길이보전하세            
			</p>        
		</div>
        <div title="애국가 3절" data-options="iconCls:'icon-ok'" style="padding:10px;">
			<h3 style="color:#0099FF;">애국가 3절</h3>
            <p>
			가을하늘 공활한데 높고 구름없이 
			밝은달은 우리가슴 일편단심일세
			(후렴)무궁화 삼천리 화려강산 대한사람 대한으로 길이보전하세
			</p>          
		</div>
        <div title="애국가 4절" data-options="iconCls:'icon-ok'" style="padding:10px;">
			<h3 style="color:#0099FF;">애국가 4절</h3>
            <p>
			이 기상과 이 맘으로 충성을 다하여
			괴로우나 즐거우나 나라사랑하세
			(후렴)무궁화 삼천리 화려강산 대한사람 대한으로 길이보전하세
			</p>          
        </div>
     </div>
</body>
</html>