<%@page import="kr.green.member.service.MemberService"%>
<%@page import="kr.green.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	// 여기에 관리자로 로그인 되어있는지를 판단하는 코드가 있어야 한다.
	// 관리자로 로그인 되어 있으면 목록을 보여주고
	// 관리자가 아니면 관리자로 로그인하도록 로그인 화면으로 가야 한다.

	List<MemberVO> memList = MemberService.getInstance().selectList();
	request.setAttribute("memList", memList);
	// ${memList }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록 보기</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/comm.js"></script>
<script>
	$(function(){
		// 홈으로가기 버튼 클릭 이벤트
		$("#goHome").click(function() {
			location.href='index.jsp';
		});
		// 체크박스 전체 선택/해제
		$("#selectToggle").change(function() {
			// alert(this.checked);
			if(this.checked){
				// 모두 선택
				for(i=1;i<=${fn:length(memList) };i++){
					$("#listChk"+i).prop("checked", true);
				}
			}else{
				// 모두 해제
				for(i=1;i<=${fn:length(memList) };i++){
					$("#listChk"+i).prop("checked", false);
				}
			}
		});
		// 메일 보내기 버튼을 클릭하면
		$("#sendMail").click(function(){
			// 선택된 체크 박스들의 값을 읽어서 변수에 넣는다.
			var values = "";
			for(i=1;i<=${fn:length(memList) };i++){
				if($("#listChk"+i).is(':checked')){
					values += $("#listChk"+i).val() + " "; // 값을 읽어서 추가
				}
			}
			// alert(values);
			values = values.trim(); // 공백을 제거하고
			// 메일보내기 폼으로 이동하면 된다.
			SendPost("sendMail.jsp", {"idx":values});
		});
	});
</script>
<style type="text/css">
	* { font-size: 10pt; }
	table#mainContent{width: 90%; margin: auto;}
	th {border: 1px solid gray; background-color: silver;padding: 5px; text-align: center;}
	td {border: 1px solid gray; padding: 5px;}
	td.title {border:none; padding: 5px; text-align: center; font-size: 18pt;}
	td.info {border:none; padding: 5px; text-align: right; }
	td.info2 {border: 1px solid gray; padding: 5px; text-align: center; }
</style>
</head>
<body>
	<form action="#" method="post">
	<table id="mainContent">
		<tr>
			<td colspan="7" class="title">회원목록 보기</td>
		</tr>
		<tr>
			<td colspan="7" class="info">
				<input type="button" value=" 선택 메일보내기 " id="sendMail" class="btn btn-outline-success btn-sm"/>		
				<input type="button" value=" 홈으로가기 " id="goHome" class="btn btn-outline-success btn-sm"/>		
			</td>
		</tr>
		<tr>
			<td colspan="7" class="info">전체 : ${fn:length(memList) }명</td>
		</tr>
		<tr>
			<th><input type="checkbox" id="selectToggle"/></th>
			<th>사용자아이디</th>
			<th>사용자이름</th>
			<th>현재상태</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th>관리</th>
		</tr>
		<c:forEach var="mvo" items="${memList }" varStatus="vs">
			<tr>
				<td align="center" ><input type="checkbox" id="listChk${vs.count }" value="${mvo.idx }"/> </td>
				<td><c:out value="${mvo.userid }"></c:out> </td>
				<td><c:out value="${mvo.username }"></c:out> </td>
				<td>
					<c:if test="${mvo.use==0 }">미인증</c:if> 
					<c:if test="${mvo.use==1 }">인증</c:if> 
					<c:if test="${mvo.use==2 }">휴면계정</c:if> 
					<c:if test="${mvo.use==3 }">탈퇴</c:if> 
				</td>
				<td><c:out value="${mvo.phone }"></c:out> </td>
				<td><c:out value="${mvo.email }"></c:out> </td>
				<td align="center"> <input type="button" value=" 상세보기 "  class="btn btn-outline-success btn-sm"/> </td>
			</tr>
		</c:forEach>
	</table>
	</form>


</body>
</html>