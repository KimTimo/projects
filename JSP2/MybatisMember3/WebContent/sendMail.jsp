<%@page import="kr.green.member.service.MemberService"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일보내기</title>
<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!-- include summernote css/js -->
<link	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<!-- CDN 한글화 -->
<script	src=" https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.18/lang/summernote-ko-KR.min.js"></script>
<script src="${pageContext.request.contextPath}/js/comm.js"></script>
<script>
	$(function(){
		$('#content').summernote({
		    lang: 'ko-KR',	 	// default: 'en-US'
	    	height : 300, 		// set editor height
			minHeight : null, 	// set minimum height of editor
			maxHeight : null, 	// set maximum height of editor
			fontNames : [ '맑은고딕', 'Arial', 'Arial Black','Comic Sans MS', 'Courier New', ],
			fontNamesIgnoreCheck : [ '맑은고딕' ],
			focus : true,
			callbacks : {
				onImageUpload : function(files, editor, welEditable) {
					for (var i = files.length - 1; i >= 0; i--) {
						sendFile(files[i], this);
					}
				}
			}		    
		});
	});
	function sendFile(file, el) {
		var form_data = new FormData();
      	form_data.append('file', file);
      	$.ajax({
        	data: form_data,
        	type: "POST",
        	url: 'imageUpload.jsp',
        	cache: false,
        	contentType: false,
        	enctype: 'multipart/form-data',
        	processData: false,
        	success: function(img_name) {
          		$(el).summernote('editor.insertImage', img_name);
        	},
        	error : function(){
        		alert('에러!!!');
        	}
      	});
    }
	
</script>
<style type="text/css">
	* { font-size: 10pt; }
	table#mainContent{width: 90%; margin: auto;}
	th {border: 0px solid gray; background-color: silver;padding: 5px; text-align: center;}
	td {border: 0px solid gray; padding: 5px;}
	td.title {border:none; padding: 5px; text-align: center; font-size: 18pt;}
</style>

</head>
<body>
	<%
		String idxs = request.getParameter("idx");
		// List<String> emailList = MemberService.getInstance().selectEmail(idxs);
		// request.setAttribute("emailList", emailList);
		request.setAttribute("idxs", idxs);
	%>
	<%-- ${idxs } --%>
	<form action="sendMailOk.jsp" method="post">
		<table id="mainContent">
			<tr>
				<td colspan="2" class="title">선택한 사용자 에게 메일 보내기</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>
					<input type="text" name="subject" size="100" required="required"/>
					<input type="hidden" name="idxs" value="${idxs }" />
				</td>
			</tr>
			<tr>
				<td valign="top">내용</td>
				<td><textarea name="content" id="content" style="width: 300px; height: 200px;"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: right;"><input
					type="submit" value="메일보내기" /></td>
			</tr>
		</table>
	</form>
</body>
</html>