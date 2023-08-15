<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8"); // POST전송에서 한글이 깨지지 않으려면
	if(!request.getMethod().equals("POST")){ // 폼을 통해서 넘어온것이 아니라면
		response.sendRedirect("login.jsp"); // 로그인 폼으로 보낸다.
		return;
	}
	// 넘어온 데이터 3개를 읽는다.
	String userid = request.getParameter("userid");
	String password = request.getParameter("password");
	String saveid = request.getParameter("saveid");
	// 여기에서 로그인처리를 한다.
	// DB에서 읽어서 처리를 해야 하지만 아직은 DB를 사용못하니 
	// 아이디와 비밀번호가 같으면 로그인 처리하는것으로 가정하자!!!!
	if(userid.equals(password)){
		// 로그인 성공
		session.setAttribute("userid", userid);
		// 자동 저장이 체크되어 있으면
		if(saveid!=null && saveid.equals("1")){
			// 아이디를 쿠키에 저장
			Cookie cookie = new Cookie("userid", userid);
			cookie.setMaxAge(60*60*24*7); // 유효기간을 7일로 설정
			response.addCookie(cookie);
		}else{
			// 저장된 아이디를 쿠키에서 삭제
			Cookie cookie = new Cookie("userid", "");
			cookie.setMaxAge(0); // 유효기간을 0으로 설정
			response.addCookie(cookie);
		}
	}else{
		// 로그인 실패!!!
		out.println("<script>");
		out.println("alert('잘못된정보입니다.');");
		out.println("location.href='login.jsp';");
		out.println("</script>");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
</head>
<body>
	${param.userid }님 반갑습니다. <br />
	<button onclick="location.href='logout.jsp'">로그아웃</button>
</body>
</html>