<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// 받는 한글 인코딩 처리
request.setCharacterEncoding("UTF-8");
String referer = request.getHeader("referer"); // 이전 주소를 알아낸다.
// 이 파일을 반드시 POST로만 접근해야 한다.
if(! request.getMethod().equals("POST")){
	// 이전페이지로 간다.
	if(referer!=null){
		response.sendRedirect(referer);
	}else{
		response.sendRedirect("login.jsp");
	}
	return;
}
// 넘어온 데이터를 받자!!
String userid = request.getParameter("userid");
String password = request.getParameter("password");
String saveid = request.getParameter("saveid");

// 이제 로그인처리를 하자
// 정보가 넘어오지 않았다면 이전페이지로 보낸다.

if(userid==null || userid.trim().length()==0 || password==null || password.trim().length()==0){
	// 이전페이지로 간다.
		if(referer!=null){
			response.sendRedirect(referer);
		}else{
			response.sendRedirect("login.jsp");
		}
		return;
	}
// 나중에는 회원정보에서 지정아이디와 패스워드를 가져와서 비교를 해야 하지만
// 지금은 아이디와 비번이 같을 경우에만 로그인 성공으로 하자
if(userid.equals(password)){
	//로그인 성공
	session.setAttribute("userid", userid);
	if(saveid!=null && saveid.equals("1")){
		// 아이디 자동저장이 체크되어 있다면 쿠키에 저장을 하자
		Cookie cookie = new Cookie("userid",URLEncoder.encode(userid,"UTF-8"));
		cookie.setMaxAge(60*60*24*7); // 유효기간을 1주일로 지정
		response.addCookie(cookie);
	}else{
		// 아이디 자동저장이 체크되어 있지 않다면 쿠키에서 삭제를 하자.
		Cookie cookie = new Cookie("userid","");
		cookie.setMaxAge(0); // 유효기간을 0으로 하여 바로 지워지게 하자
		response.addCookie(cookie);
	}
	// 로그인이 성공했으니 이전페이지로 가자!
	response.sendRedirect(referer);
	return;
}else{
	// 아이디와 비번이 다르면 로그인 실패라고 하자!! 자바스크립트로 띄워보자!!
	out.println("<script>");
	out.println("alert('잘못된 정보입니다.')");
	out.println("location.href='" + referer + "';");
	out.println("</script>");
}


%>