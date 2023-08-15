<%@page import="kr.green.member.service.MemberService"%>
<%@page import="kr.green.member.vo.MemberVO"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여기에 제목</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/comm.js"></script>
<script>
	$(function(){
		
	});
</script>
</head>
<body>
	<fmt:requestEncoding value="UTF-8"/>
	<c:if test='${pageContext.request.method!="POST" }'>
		<c:redirect url="index.jsp"></c:redirect>
	</c:if>
	
	<%
		// 1. 넘어온 데이터를 받아
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String remember = request.getParameter("remember");
		
		// 2. DB의 정보를 이용하여 아이디와 비번이 같은지를 검사한다.==> 서비스에서 처리
		MemberVO memberVO = MemberService.getInstance().loginCheck(userid, password);
		// 3. 로그인이 되면 회원정보를 세션에 저장하고 아니면 로그인화면으로 돌여보낸다.
		if(memberVO!=null){
			// 로그인 성공하면 회원정보를 세션에 저장
			session.setAttribute("mvo", memberVO);
			// 자동 저장이 체크되어 있으면
			if(remember!=null && remember.equals("1")){
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
			response.sendRedirect("index.jsp");
			return;
		}else{
			// 로그인 실패!!!
			out.println("<script>");
			out.println("alert('잘못된정보입니다.');");
			out.println("location.href='login.jsp';");
			out.println("</script>");			
		}
	%>
</body>
</html>