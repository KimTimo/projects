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
	<!-- 
    <table class="easyui-datagrid" title="1줄 메모장" style="width:1000px;height:200px"
            data-options="singleSelect:true,collapsible:true,url:'resources/datagrid_data1.json',method:'get'">
        <thead>
            <tr>
                <th data-options="field:'itemid',width:80">Item ID</th>
                <th data-options="field:'productid',width:100">Product</th>
                <th data-options="field:'listprice',width:80,align:'right'">List Price</th>
                <th data-options="field:'unitcost',width:80,align:'right'">Unit Cost</th>
                <th data-options="field:'attr1',width:250">Attribute</th>
                <th data-options="field:'status',width:60,align:'center'">Status</th>
            </tr>
        </thead>
    </table>
	 -->
    <br />
    <table class="easyui-datagrid" title="1줄 메모장" style="width:1000px;height:500px"
            data-options="
            singleSelect:true,
            collapsible:true,
            rownumbers:true,
            autoRowHeight:false,
            url:'rest/list2.json',
            pagination:true,
            pageSize:10,
            method:'get'">
        <thead>
            <tr>
                <th data-options="field:'idx',width:80,align:'center'">번호</th>
                <th data-options="field:'name',width:150,align:'center'">이름</th>
                <!-- 
                <th data-options="field:'password',width:80,align:'center'">비번</th>
                 -->
                <th data-options="field:'content',width:380">내용</th>
                <th data-options="field:'ip',width:100,align:'center'">ip</th>
                <th data-options="field:'regDate',width:200,align:'center'">작성일</th>
            </tr>
        </thead>
    </table>
   
</body>
</html>