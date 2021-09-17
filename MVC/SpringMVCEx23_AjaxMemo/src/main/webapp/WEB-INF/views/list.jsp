<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>허접한 1줄 메모장</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="resources/css/comm.css">
<script type="text/javascript" src="resources/js/comm.js"></script>
<script>
	$(function(){
		
	});
	
	function formCheck(){
		var value = $("#name").val();
		if(!value | value.trim().length==0){
			alert('이름은 반드시 입력해야 합니다.');
			$("#name").val("");
			$("#name").focus();
			return false;
		}
		var value = $("#password").val();
		if(!value | value.trim().length==0){
			alert('비밀번호는 반드시 입력해야 합니다.');
			$("#password").val("");
			$("#password").focus();
			return false;
		}
		var value = $("#content").val();
		if(!value | value.trim().length==0){
			alert('내용은 반드시 입력해야 합니다.');
			$("#content").val("");
			$("#content").focus();
			return false;
		}
		return true;
	}
	function editForm(idx, name, content){
		$("#submitBtn").val("수정"); // 저장버튼의 이름을 수정으로 변경
		$("#idx").val(idx); // idx넣고
		$("#password").val(""); // password는 비워주고
		$("#name").val(name); // 이름 넣고
		$("#content").val(content); // 내용넣고
		$("#mode").val("update"); // 수정이라고 모드 변경
		$("#cancelBtn").css('display','inline'); // 취소버튼 보이고
		$("#password").focus(); // 커서 옮기고
	}
	function deleteForm(idx, name, content){
		$("#submitBtn").val("삭제"); // 저장버튼의 이름을 삭제로 변경
		$("#idx").val(idx); // idx넣고
		$("#password").val(""); // password는 비워주고
		$("#name").val(name); // 이름 넣고
		$("#content").val(content); // 내용넣고
		$("#mode").val("delete"); //삭제라고 모드 변경
		$("#cancelBtn").css('display','inline'); // 취소버튼 보이고
		$("#password").focus(); // 커서 옮기고
	}
	function resetForm(){
		$("#submitBtn").val("저장"); // 저장버튼의 이름을 저장으로 변경
		$("#idx").val(0); // idx넣고
		$("#password").val(""); // password는 비워주고
		$("#name").val(""); // 이름 넣고
		$("#content").val(""); // 내용넣고
		$("#mode").val("insert"); //저장이라고 모드 변경
		$("#cancelBtn").css('display','none'); // 취소버튼 보이고
		$("#name").focus(); // 커서 옮기고
	}
	function changePageSize(){
		// alert($("#s").val());
		SendPost('list',{"p":${pv.currentPage},"s":$("#s").val(),"b":${pv.blockSize}});
	}
</script>
</head>
<body>
	<table>
		<tr>
			<td colspan="5" class="title">허접한 1줄 메모장(Ver 0.009)</td>
		</tr>
		<tr>
			<td colspan="5" class="info">
			${pv.pageInfo }
			
			<select name="s" id="s" onchange="changePageSize();">
				<option value="3" ${pv.pageSize==3 ? " selected='selected' " : "" }>03개씩 보기</option>
				<option value="5" ${pv.pageSize==5 ? " selected='selected' " : "" }>05개씩 보기</option>
				<option value="10" ${pv.pageSize==10 ? " selected='selected' " : "" }>10개씩 보기</option>
				<option value="20" ${pv.pageSize==20 ? " selected='selected' " : "" }>20개씩 보기</option>
				<option value="30" ${pv.pageSize==30 ? " selected='selected' " : "" }>30개씩 보기</option>
			</select>
			
			</td>
		</tr>
		<tr>
			<th width="5%">번호</th>
			<th width="10%">작성자</th>
			<th>내용</th>
			<th width="10%">작성일</th>
			<th width="10%">IP</th>
		</tr>
		<c:if test="${empty pv.list }">
			<tr>
				<td colspan="5" align="center">등록된 글이 없습니다.</td>
			</tr>
		</c:if>
		<c:if test="${not empty pv.list }">
			<c:forEach var="vo" items="${pv.list }" varStatus="vs">
				<%-- 번호는 계산해서 출력해보자 --%>
				<c:set var="no" value="${pv.totalCount - (pv.currentPage-1)*pv.pageSize }"/>
				<tr align="center">
					<td>${no-vs.index }</td>
					<td>
						<c:out value="${vo.name }"></c:out>
					</td>
					<td align="left">
						<c:out value="${vo.content }"></c:out>
						<%-- 수정/삭제 버튼을 달자 --%>
						<button class="btn btn-outline-success btn-sm" onclick="editForm(${vo.idx},'${vo.name }', '${vo.content }')">Edit</button>
						<button class="btn btn-outline-success btn-sm" onclick="deleteForm(${vo.idx},'${vo.name }', '${vo.content }')">Delete</button>
					</td>
					<td>
						<fmt:formatDate value="${vo.regDate }" pattern="yyyy-MM-dd"/>
					</td>
					<td>${vo.ip }</td>
				</tr>
			</c:forEach>
			<%-- 페이지 리스트 --%>
			<tr>
				<td colspan="5" align="center" style="border: none;">${pv.pageList }</td>
			</tr>
		</c:if>
		<%-- 입력폼 --%>
		<tr>
			<td colspan="5" align="center" style="border: none;">
				<form action="update" method="post" onsubmit="return formCheck();" id="memoForm">
					<%-- 수정/삭제 할때 idx를 숨겨서 가지고 가자 --%>
					<input type="hidden" name="idx" id="idx" value="0" />
					<%-- 저장/수정/삭제 할때 mode를 숨겨서 가지고 가자 --%>
					<input type="hidden" name="mode" id="mode"   value="insert" >
					<%-- ip도 숨겨서 가자 --%>
					<input type="hidden" name="ip" id="ip" value="${pageContext.request.remoteAddr }" />
					<input type="text" name="name" id="name" placeholder="이름입력" required="required" size="10" />
					<input type="password" name="password" id="password" placeholder="암호입력" required="required" size="10" />
					<input type="text" name="content" id="content" placeholder="내용입력" required="required" size="100" />
					<input type="submit" value="저장" id="submitBtn" class="btn btn-success btn-sm" />
					<%-- 수정/삭제를 취소할 수 있는 머븥을 일단은 숨겨서 놔두자 --%>
					<input type="button" id="cancelBtn" value="취소" style="display: none;"  class="btn btn-success btn-sm"  onclick="resetForm()"/>
				</form>
			
			</td>
		</tr>
		
	</table>
</body>
</html>