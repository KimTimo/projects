<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form태그</title>
</head>
<body>
	<form action="requestResult2.jsp" method="post">
		사용자아이디 : <input type="text" name="userid"> <br />
		<!-- 일반적으로 보이는 문자열 입력 -->
		사용자비밀번호 : <input type="password" name="password"> <br />
		<!-- type="password" : 숨겨서 보낼 문자열 입력 -->
		성별 :
		<!-- type='radio' : 여러개 중에 1개만 선택할때 사용. 반드시 name 속성이 같아야 한다. value 속성값이 넘어감 -->

		<label><input type="radio" name="gender" value="m" />남자</label> <input
			type="radio" name="gender" value="f" checked="checked" id="f" /><label
			for="f">여자</label>
		<!-- checked="checked" : 기본으로 선택되어짐 -->
		<br /> 사용 가능한 기술 : 
		<label><input type="checkbox"name="language" value="HTML">HTML</label> <label>
		<input type="checkbox" name="language" value="CSS">CSS</label> <label>
		<input	type="checkbox" name="language" value="JavaScript">JavaScript</label>
		<label><input type="checkbox" name="language" value="Java"
			checked="checked">Java</label> <br /> 연령대 : <select name="age">
			<option value="10">10대</option>
			<option value="20">20대</option>
			<option value="30" selected="selected">30대</option>
			<option value="40">40대</option>
		</select> <br /> 가입인사 :
		<br />
		<textarea rows="5" cols="50" name="note"></textarea>
		<br />
	    <input type="submit" value="로그인하기">
	</form>

</body>
</html>