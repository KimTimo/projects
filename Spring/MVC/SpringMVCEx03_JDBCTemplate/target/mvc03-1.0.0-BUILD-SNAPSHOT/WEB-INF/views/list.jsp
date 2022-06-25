<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function editForm(id, name, age){
		//alert(id + "\n" + name + "\n" + age);
		$("#eid").val(id);
		$("#ename").val(name);
		$("#eage").val(age);
		$("#ename").focus();
	}
	function deleteForm(id, name, age){
		//alert(id + "\n" + name + "\n" + age);
		$("#did").val(id);
		$("#dname").val(name);
		$("#dage").val(age);
		$("#deleteBtn").focus();
	}
</script>

<style type="text/css">
	div {border: 1px solid gray;margin-bottom: 5px; padding: 10px;}
</style>
</head>
<body>
	<c:if test="${empty list }">
		<div style="color: red;text-align: center;">등록된 내용이 없습니다.</div>
	</c:if>
	<c:if test="${not empty list }">
		<c:forEach var="vo" items="${list }">
			<div> 
			${vo.id }. ${vo.name } (${vo.age}세)
			<input type="button" value="수정"  onclick="editForm(${vo.id},'${vo.name }','${vo.age}')" />
			<input type="button" value="삭제"  onclick="deleteForm(${vo.id},'${vo.name }','${vo.age}')"  />
			</div>
		</c:forEach>
	</c:if>
	<form action="insertOk" method="post">
		<input type="text" name="name" id="name" required="required" placeholder="이름"/>
		<input type="text" name="age" id="age" required="required" placeholder="나이"/>
		<input type="submit"  value="저장"/>
	</form>
	<form action="updateOk" method="post">
		<input type="text" name="id" id="eid" readonly="readonly" size="3"/>
		<input type="text" name="name" id="ename" required="required" placeholder="이름"/>
		<input type="text" name="age" id="eage" required="required" placeholder="나이"/>
		<input type="submit"  value="수정"/>
	</form>
	<form action="deleteOk" method="post">
		<input type="text" name="id" id="did" readonly="readonly" size="3"/>
		<input type="text" name="name" id="dname" readonly="readonly"/>
		<input type="text" name="age" id="dage" readonly="readonly"/>
		<input type="submit"  value="삭제" id="deleteBtn"/>
	</form>
</body>
</html>