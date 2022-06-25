<%@page import="kr.green.mybatis.emp.vo.DeptVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.green.mybatis.emp.service.DeptService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	List<DeptVO> list = DeptService.getInstance().selectAll();
	request.setAttribute("list", list);
	List<String> deptList = DeptService.getInstance().selectDeptID();
	request.setAttribute("deptList", deptList);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>여기 제목</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="css/comm.css" rel="stylesheet">
<style type="text/css">

</style>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/comm.js"></script>
<script type="text/javascript">
	$(function(){
		$("#deptID").change(function(){
			var deptid = $(this).val();
			if(deptid==null || deptid=="")
				location.href="deptListEx01.jsp";
			else
				location.href="deptSearchList.jsp?id=" + deptid;
		});
	});
</script>
</head>
<body>
	<table>
		<tr>
			<td colspan="6" class="title">부서별 사원목록 보기</td>
		</tr>
		<tr>
			<td colspan="6" class="info">
				전체 : ${list.size() }개 <br />
				부서선택 : 
				<select id="deptID">
					<option value="">전체보기</option>
					<c:forEach var="id" items="${deptList }">
						<option value="${id }" ${param.id==id ? "selected='selected'" : "" }>${id }번 부서 보기</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<th>사번</th>
			<th>이름</th>
			<th>부서번호</th>
			<th>부서이름</th>
			<th>부서위치</th>
			<th>직업종류</th>
		</tr>
		<c:if test="${empty list }">
			<tr>
				<td colspan="6" class="content">데이터 없다!!!</td>
			</tr>
		</c:if>
		<c:if test="${not empty list }">
			<c:forEach var="vo" items="${list }">
				<tr align="center">
					<td>${vo.emp_id }</td>
					<td>${vo.emp_name }</td>
					<td>${vo.dept_id }</td>
					<td>${vo.dept_name}</td>
					<td>${vo.dept_city }</td>
					<td>${vo.job_id }</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>