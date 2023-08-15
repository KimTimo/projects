<%@page import="kr.green.email.util.SendMail"%>
<%@page import="kr.green.email.util.MailVO"%>
<%@page import="kr.green.member.service.MemberService"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:requestEncoding value="UTF-8"/>
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
<%--
메일보낼 idx : ${param.idxs } <br />
<hr />
제목 : ${param.subject } <br />
<hr />
내용 : ${param.content } <br />
<hr />
 --%>
<%
	// 이제 여기에서 메일을 전손하면 된다.
	// 1. idx로 이메일 주소들 얻어와야 한다.
	String idxs = request.getParameter("idxs");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	List<String> emailList = MemberService.getInstance().selectEmail(idxs);
	//out.println(emailList);
	// 2. 반목문을 돌려서 각각의 이메일에 메일을 발손한다.
	MailVO mailVO = new MailVO();
	mailVO.setFrom("itsungnam202106@gmail.com");
	mailVO.setPassword("woaldjqtek2");
	mailVO.setSubject(subject);
	mailVO.setContent(content);
	for(String email : emailList){
		mailVO.setTo(email); // 받는사람만 변경해서 계속 이메일을 발송한다
		if(SendMail.mailSender(mailVO)){
			out.println(email + "에 전송 성공!!! <br>");
		}else{
			out.println(email + "에 전송 실패!!! <br>");
		}
	}
%>
<button class="btn btn-outline-success btn-sm" onclick="location.href='ListTest.jsp'">돌아가기</button>
</body>
</html>