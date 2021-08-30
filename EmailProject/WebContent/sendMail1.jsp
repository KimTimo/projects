<%@page import="javax.mail.PasswordAuthentication"%>
<%@page import="javax.mail.Transport"%>
<%@page import="javax.mail.Message"%>
<%@page import="javax.mail.internet.InternetAddress"%>
<%@page import="javax.mail.Address"%>
<%@page import="javax.mail.internet.MimeMessage"%>
<%@page import="javax.mail.Session"%>
<%@page import="email.util.SMTPAuthenticator"%>
<%@page import="javax.mail.Authenticator"%>
<%@page import="java.util.Properties"%>
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
<%
	// 넘어온 데이터 받기
	String from = request.getParameter("from");
	String to = request.getParameter("to");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");

	// SMTP 서버에 접속하기 위한 정보들
	Properties p = new Properties(); // 정보를 담을 객체
	p.put("mail.smtp.host","smtp.gmail.com"); // 네이버 SMTP 또는 gmail SMTP
	p.put("mail.smtp.port", "465");
	p.put("mail.smtp.starttls.enable", "true");
	p.put("mail.smtp.auth", "true");
	p.put("mail.smtp.debug", "true");
	p.put("mail.smtp.socketFactory.port", "465");
	p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	p.put("mail.smtp.socketFactory.fallback", "false");
	
	try{
		// Authenticator auth = new SMTPAuthenticatior(); // 인증객체 생성
		// Session ses = Session.getInstance(p,auth); // 설정 정보와 인증객체를 보내 세션 생성
		
		// 별도의 클래스를 만들지 않고 익명 클래스를 이용해보자
		Session ses = Session.getInstance(p,new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// 자신의 네이버나 지메일의 계정 정보를 넣어준다.
				return new PasswordAuthentication("eogus8875@naver.com", "Daehyun12@");
			}
		}); // 설정 정보와 인증객체를 보내 세션 생성
		
		ses.setDebug(true); // 디버그모드 설정. 나중에는 false로 변경
		MimeMessage msg = new MimeMessage(ses); // 메일의 내용을 담을 객체
		Address fromAddr = new InternetAddress(from); // 주소를 생성
		msg.setFrom(fromAddr); // 보내는 사람
		Address toAddr = new InternetAddress(to);
		msg.addRecipient(Message.RecipientType.TO, toAddr); // 받는 사람
		msg.setSubject(subject); // 제목
		msg.setContent(content, "text/html;charset=UTF-8"); // 내용과 인코딩 설정
		Transport.send(msg); // 전송		
	}catch(Exception e){
		// 에러가 나면 이전으로 가기
		e.printStackTrace();
		out.println("<script>alert('메일보내기 실패!!');history.back();</script>");
		return;
	}
	// 성공시
	out.println("<script>alert('메일보내기 성공!!');history.back();</script>");
%>
</body>
</html>