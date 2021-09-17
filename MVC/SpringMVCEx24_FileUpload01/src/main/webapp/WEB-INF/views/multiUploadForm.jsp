<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여러개 파일 업로드하기</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function(){
	
	});
</script>
</head>
<body>
	<form action="multiUploadOk" method="post" enctype="multipart/form-data">
		<input type="file" name="files" id="file1"/> 
		<br>
		<input type="file" name="files" id="file2"/> 
		<br>
		<input type="file" name="files" id="file3"/> 
		<br>
		<input type="file" name="files" id="file3"/> 
		<br>
		<input type="file" name="files" id="file4"/> 
		<br>
		<textarea name="content" id="content" cols="50" rows="5"  required="required" placeholder="설명을 달아라"></textarea>
		<br />
		<input type="submit" value="파일업로드하기" />
	</form>
</body>
</html>