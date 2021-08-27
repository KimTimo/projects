<%@page import="kr.green.category.service.CategoryService"%>
<%@page import="kr.green.category.vo.CategoryVO"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	// 서비스를 호출하여 모든 카테고리를 읽어서 영역에 저장을 하자
	List<CategoryVO> list = CategoryService.getInstance().selectList();
	request.setAttribute("list", list);
%>
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
		$("#itemAddBtn").click(function(){
			var value = $("#item").val();
			if(value==null || value.trim().length==0){
				alert('대항목은 반드시 입력해야 합니다.');
				$("#item").val("");
				$("#item").focus();
				return false;
			}
			SendPost("updateAdd.jsp", {"item":value});
		});
	});
	
	function editBtnClick(idx){
		// alert(idx + "번 수정");
		var value = $("#item"+idx).val();
		if(value==null || value.trim().length==0){
			alert('항목은 반드시 입력해야 합니다.');
			$("#item"+idx).val("");
			$("#item"+idx).focus();
			return false;
		}
		SendPost("updateItem.jsp", {"idx":idx,"item":value});
	}
	
	function deleteBtnClick(idx, ref, seq, lev){
		if(confirm(idx + "번을 정말로 삭제 하시겠습니까?")){
			SendPost("deleteItem.jsp", {"idx":idx,"ref":ref, "seq":seq,"lev":lev});
		}
	}
	
</script>
</head>
<body>
	<input type="text" name="item" id="item"/> 
	<button id="itemAddBtn"  class="btn btn-outline-success btn-sm">대항목 추가</button>
	<hr />
	<c:if test="${empty list }">
		등록된 카테고리가 없습니다. <br />
	</c:if>
	<c:if test="${not empty list }">
		<c:forEach var="vo" items="${list }">
			<c:if test="${vo.lev gt 0 }">
				<c:forEach var="l" begin="0" end="${vo.lev }">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</c:forEach>
				☞ 
			</c:if>
			<%-- 여기에 소항목을 추가하는 폼을 만든다. --%>
			${vo.item } 
			<form action="updateAdd.jsp" method="post" style="display: inline;">
				<input type="hidden" name="ref" id="ref" value="${vo.ref }"/> 
				<input type="hidden" name="seq" id="seq" value="${vo.seq }"/> 
				<input type="hidden" name="lev" id="lev" value="${vo.lev }"/> 
				<input type="text"   name="item" id="item${vo.idx }" required="required" placeholder="항목입력"/> 
				<input type="submit" value="추가"  class="btn btn-outline-success btn-sm"/> 
				<input type="button" value="수정"  onclick="editBtnClick(${vo.idx})"  class="btn btn-outline-success btn-sm"/>
				<input type="button" value="삭제"  onclick="deleteBtnClick(${vo.idx },${vo.ref },${vo.seq },${vo.lev })"  class="btn btn-outline-success btn-sm"/> 
			</form>
			<br/>
		</c:forEach>
	</c:if>
</body>
</html>