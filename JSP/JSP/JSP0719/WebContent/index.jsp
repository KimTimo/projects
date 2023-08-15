<%@page import="kr.green.memo.vo.PagingVO"%>
<%@page import="kr.green.memo.service.MemoService"%>
<%@page import="kr.green.memo.vo.MemoVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<MemoVO> list = MemoService.readMemo(application.getRealPath("/memo.json"));
//=============================================================================================
// 이부분 추가

// 페이징 처리를 위해서 넘어오는 3가지를 받는다.
int currentPage = 1;
int pageSize = 10;
int blockSize = 10;
int totalCount = list.size();
// 넘어온 값을 받는다.
try {
	currentPage = Integer.parseInt(request.getParameter("p"));
} catch (Exception e) {
	;
}

try {
	pageSize = Integer.parseInt(request.getParameter("s"));
} catch (Exception e) {
	;
}

try {
	blockSize = Integer.parseInt(request.getParameter("b"));
} catch (Exception e) {
	;
}

// 페이징 계산을 한다.
PagingVO<MemoVO> pagingVO = new PagingVO<>(totalCount, currentPage, pageSize, blockSize);
pagingVO.setList(list);
//=============================================================================================================
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>출석게시판</title>
<style type="text/css">
* {
	font-size: 10px;
}

table {
	width: 990px;
	margin: auto;
}

th {
	padding: 5px;
	border: 1px solid gray;
	background-color: silver;
}

td {
	padding: 5px;
	border: 1px solid gray;
}

.title {
	border: none;
	background-color: white;
	font-size: 18pt;
}

.sub_title {
	border: none;
	background-color: white;
	font-size: 8pt;
	text-align: right;
}
</style>
<script type="text/javascript">
	function formCheck() {
		var obj = document.getElementById("name");
		if (!obj.value || obj.value.trim().length == 0) {
			alert('이름은 반드시 입력해야 합니다.');
			obj.value = '';
			obj.focus();
			return false;
		}
		var obj = document.getElementById("password");
		if (!obj.value || obj.value.trim().length == 0) {
			alert('비밀번호를 반드시 입력하시오.');
			obj.value = '';
			obj.focus();
			return false;
		}
		var obj = document.getElementById("content");
		if (!obj.value || obj.value.trim().length == 0) {
			alert('내용은 반드시 입력해야 합니다.');
			obj.value = '';
			obj.focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<form action="memoInsertOk.jsp" method="post"
		onsubmit="return formChech()">
		<table>
			<tr>
				<th class="title" colspan="5">한줄 메모장 프로그램 Ver 0.9</th>
			</tr>
			<tr>
				<th class="sub_title" colspan="5">전체 : <%=pagingVO.getPageInfo()%>
					<%-- 이 부분 변경 --%>
				</th>
			</tr>
			<tr>
				<th width="5%">No</th>
				<th width="60%">내용</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>ip</th>
			</tr>
			<%
			if (list != null && list.size() > 0) {
				for (int i = pagingVO.getStartNo(); i <= pagingVO.getEndNo(); i++) {
					MemoVO vo = list.get(i);
			%>
			<tr>
				<td><%=list.size() - i%></td>
				<td align="left">
					<%
					String content = vo.getContent();
					content = content.replaceAll("<", "&lt;");
					content = content.replaceAll(">", "&gt;");
					out.println(content);
					%>

				</td>
				<td>
					<%
					String name = vo.getName();
					name = name.replaceAll("<", "&lt;");
					name = name.replaceAll(">", "&gt;");
					out.println(name);
					%>
				</td>
				<td><%=vo.getRegDate()%></td>
				<td><%=vo.getIp()%></td>
			</tr>

			<%
			}
			%>
			<!-- ------------------------------------------------------------------------------------------------------------ -->
			<!-- 이 부분 추가!!! 페이지 이동 처리 -->
			<tr>
				<td colspan="5" style="border: none; text-align: center;">
				<%=pagingVO.getPageList() %>
			</tr>
			<%
			} else {
			%>
			<tr>
				<td colspan="5">등록된 글이 없습니다</td>


				<%
				}
				%>
			
			<tr>
				<td colspan="5" style="border: none;">
					<%--여기에 쓰기 폼을 달아보자!!! 작성자, 비밀번호 , 내용을 입력 받는다. --%> <input
					type="text" name="name" id="name" placeholder="이름" size="20" /> <input
					type="password" name="password" id="password" placeholder="비밀번호"
					size="20" style="margin-bottom: 5px;" /><br /> <input type="text"
					name="content" id="content" placeholder="내용을 입력하세요" size="130" />
					<input type="submit" id="submitBtn" value="저장하기" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>