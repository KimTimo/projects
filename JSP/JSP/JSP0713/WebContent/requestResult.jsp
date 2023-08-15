<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청 정보 받기</title>
</head>
<body>
	<%
	// POST 전송의 경우 한글이 깨진다. 깨지지 않으려면 저걸 넣어줘야한다.
	request.setCharacterEncoding("UTF-8");
	// 1개씩 받기
	String userid = request.getParameter("userid");
	String password = request.getParameter("password");
	String gender = request.getParameter("gender");
	//String language = request.getParameter("language");
	// name속성의 값이 같은게 여러개일 경우에는 request.getParameterValues 로 받는다. 배열로 받아줌.
	String[] languages = request.getParameterValues("language");
	//----------------------------------------------------------------
	String age = request.getParameter("age");
	String note = request.getParameter("note");
	%>

	사용자 아이디 :
	<%=userid%>
	<br /> 
	사용자 비밀번호 :
	<%=password%>
	<br /> 
	성별 :
	<%=gender%>
	<br /> 
	언어 :
	<%
	//=language
	%>
	<%
	//--------------------------------------------------------------------
	if (languages != null && languages.length > 0) {
		for (String language : languages) {
			out.print(language + " ");
		}

	}
	%>
	<br /> 연령대 :
	<%=age%>
	<br /> 설명 :
	<%=note%>
	<br />

</body>
</html>