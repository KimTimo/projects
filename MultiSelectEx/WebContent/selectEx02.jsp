<%@page import="kr.green.select.service.SelectService"%>
<%@page import="kr.green.select.vo.AreaVO"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여기에 제목</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/comm.js"></script>
<script>
	$(function(){
		$("#item1").change(function() {
			if($(this).val()!=null){
				$.ajax({
					url:"selectItem2.jsp",
					type:"GET",
					data:{"code":$(this).val()},
					dataType:"json",
					error : function(){
						alert('실패!!!');
					},
					success : function(data) {
						// alert('성공 : ' + data);
						$("#item2 option").remove(); // 기존에 있던 <option> 태그 모두 삭제
						$("#item2").append("<option>선택</option>");
						if(data!=null && data.length>0){
							for( i in data){
								var code = data[i].code;
								code = code.substr(0, 4); // 코드 4자리만 잘라서
								var temp = data[i].name.split(" "); // 배열로 만들고
								var name = temp[temp.length -1]; // 마지막 항목만 가져온다.
								$("#item2").append("<option value='" + code + "'>"+ name +"</option>");
							}
						}
					}
				});
			}
		});
	});
</script>
<style type="text/css">
	select { width: 200px; clear: both;}
	div.title { width: 150px; text-align: right; float: left; margin-right: 10px;}
</style>
</head>
<body>
	<%
		String filename = application.getRealPath("/dong.json");
		List<AreaVO> listItem = SelectService.getInstance().selectItem1(filename);
		request.setAttribute("listItem", listItem);
	%>
	<hr />
	<div class="title">시도 : </div> 
	<select name="item1" id="item1">
		<option>선택</option>
		<c:forEach var="vo" items="${listItem }">
			<option value="${fn:substring(vo.code,0,2) }">${vo.name }</option>
		</c:forEach>
	</select>
	<br />
	<div class="title">시군구 : </div> 
	<select name="item2" id="item2">
		<option>선택</option>
	</select>
	<br />
	<div class="title">읍면동 : </div> 
	<select name="item3" id="item3">
		<option>선택</option>
	</select>
	<br />
	<div class="title">리 : </div> 
	<select name="item4" id="item4">
		<option>선택</option>
	</select>
	<br />
</body>
</html>