<%@page import="javax.activation.DataHandler"%>
<%@page import="javax.activation.FileDataSource"%>
<%@page import="java.io.File"%>
<%@page import="javax.mail.internet.MimeBodyPart"%>
<%@page import="javax.mail.BodyPart"%>
<%@page import="javax.mail.internet.MimeMultipart"%>
<%@page import="javax.mail.Multipart"%>
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
	final String from = request.getParameter("from");
	final String password = request.getParameter("password");
	String to = request.getParameter("to");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");

	// SMTP 서버에 접속하기 위한 정보들
	Properties p = new Properties(); // 정보를 담을 객체
	
	// 이렇게하면 보내는 사람은 반드시 gmail을 써야 한다.
	// p.put("mail.smtp.host","smtp.gmail.com"); // 네이버 SMTP 또는 gmail SMTP
	// 조금만 변경하면 네이버나 지메일 모두 가능하지 않을까?
	String smtpServer = "smtp." + from.split("@")[1]; // 보내는 사람의 이메일 주소에서 도메인만 추출하여 적용
	p.put("mail.smtp.host", smtpServer);
	
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
				// return new PasswordAuthentication("itsungnam202106@gmail.com", "woaldjqtek2"); // 유출 위험성
				// 아이디와 비번을 받은 변수로 대치
				return new PasswordAuthentication(from, password);
			}
		}); // 설정 정보와 인증객체를 보내 세션 생성
		
		ses.setDebug(true); // 디버그모드 설정. 나중에는 false로 변경
		MimeMessage msg = new MimeMessage(ses); // 메일의 내용을 담을 객체
		Address fromAddr = new InternetAddress(from); // 주소를 생성
		msg.setFrom(fromAddr); // 보내는 사람
		Address toAddr = new InternetAddress(to);
		msg.addRecipient(Message.RecipientType.TO, toAddr); // 받는 사람
		msg.setSubject(subject); // 제목
		//========================================================================================
		// 1. 파일을 첨부할 객체
		Multipart multipart = new MimeMultipart();
		// 2. 메세지를 저장할 객체
		BodyPart messageBodyPart = new MimeBodyPart();
		// 3. 몸체 내용을 지정
		messageBodyPart.setContent(content, "text/html;charset=UTF-8"); // html 전송
		// messageBodyPart.setText(content); // 텍스트 전송
		// 4. 파일을 첨부할 객체에 추가
		multipart.addBodyPart(messageBodyPart);
		// 5. 파일을 첨부 한다.
		BodyPart filePart = new MimeBodyPart();
		File file = new File(application.getRealPath("images/2.jpg"));
		FileDataSource fds = new FileDataSource(file);
		filePart.setDataHandler(new DataHandler(fds));
		filePart.setFileName(fds.getName());
		// 6. 파일을 첨부할 객체에 추가
		multipart.addBodyPart(filePart);
		//--------------------------------------------------------------------
		// 첨부파일 개수 만큼 추가하면 된다. 
		// 5. 파일을 첨부 한다.
		BodyPart filePart2 = new MimeBodyPart();
		File file2 = new File(application.getRealPath("images/3.png"));
		FileDataSource fds2 = new FileDataSource(file2);
		filePart2.setDataHandler(new DataHandler(fds2));
		filePart2.setFileName(fds2.getName());
		// 6. 파일을 첨부할 객체에 추가
		multipart.addBodyPart(filePart2);
		//--------------------------------------------------------------------
		
		// 7. 만들어진 Multipart객체를 보낼 메일에 지정한다
		msg.setContent(multipart);
		//========================================================================================
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