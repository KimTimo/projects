<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여기에 제목</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/comm.js"></script>
<script>
	$(function() {

	});
</script>
<style type="text/css">
	div { margin: auto; border: 0px solid gray;width: 70%;padding : 20px;}
</style>
</head>
<body>
	<div>
		<form action="sendMail4.jsp" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<th colspan="2">JSP 메일 보내기(서버로 파일전송하여 첨부하기)</th>
				</tr>
				<tr>
					<td>from</td>
					<td><input type="text" name="from" size="30"/></td>
				</tr>
				<!-- 비밀번호 추가 -->
				<tr>
					<td>password</td>
					<td><input type="password" name="password"  size="30"/></td>
				</tr>
				<tr>
					<td>to</td>
					<td><input type="text" name="to"  size="30"/></td>
				</tr>
				<tr>
					<td>subject</td>
					<td><input type="text" name="subject" /></td>
				</tr>
				<tr>
					<td valign="top">content</td>
					<td><textarea name="content" style="width: 370px; height: 200px;"></textarea></td>
				</tr>
				<tr>
					<td valign="top">첨부파일</td>
					<td>
						<input type="file" name="file1"/> <br />
						<input type="file" name="file2"/> <br />
						<input type="file" name="file3"/> <br />
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: right;">
						<input type="submit" value="메일보내기" />
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>