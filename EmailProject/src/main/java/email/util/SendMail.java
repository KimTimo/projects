package email.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import email.vo.MailVO;

// JSP파일이 너무 길고 지저분해진다. 
// 유틸리티 클래스 하나를 만들어 두면 편리하게 사용 가능하다.
public class SendMail {
	// 데이터를 저장하기 않고 기능만을 있는 클래스는 메서드들을 static으로 만들면 좋다.
	// 1번 예제의 내용을 메서드로 만들어 보자
	public static boolean mailSender(String from, String to, String subject, String content) {
		boolean result = false;
		// SMTP 서버에 접속하기 위한 정보들
		Properties p = new Properties(); // 정보를 담을 객체
		p.put("mail.smtp.host", "smtp.gmail.com"); // 네이버 SMTP 또는 gmail SMTP
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");

		try {
			// 별도의 클래스를 만들지 않고 익명 클래스를 이용해보자
			Session ses = Session.getInstance(p, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					// 자신의 네이버나 지메일의 계정 정보를 넣어준다.
					return new PasswordAuthentication("eogus8875@naver.com", "Daehyun12@");
				}
			}); // 설정 정보와 인증객체를 보내 세션 생성
			ses.setDebug(false); // 디버그모드 설정. 나중에는 false로 변경
			MimeMessage msg = new MimeMessage(ses); // 메일의 내용을 담을 객체
			Address fromAddr = new InternetAddress(from); // 주소를 생성
			msg.setFrom(fromAddr); // 보내는 사람
			Address toAddr = new InternetAddress(to);
			msg.addRecipient(Message.RecipientType.TO, toAddr); // 받는 사람
			msg.setSubject(subject); // 제목
			msg.setContent(content, "text/html;charset=UTF-8"); // 내용과 인코딩 설정
			Transport.send(msg); // 전송
			result = true;
		} catch (Exception e) {
			// 에러가 나면 이전으로 가기
			e.printStackTrace();
		}
		return result;
	}

	// 2번 예제의 내용을 메서드로 만들어 보자
	public static boolean mailSender(MailVO mailVO) {
		boolean result = false;
		// SMTP 서버에 접속하기 위한 정보들
		Properties p = new Properties(); // 정보를 담을 객체

		String smtpServer = "smtp." + mailVO.getFrom().split("@")[1]; // 보내는 사람의 이메일 주소에서 도메인만 추출하여 적용
		p.put("mail.smtp.host", smtpServer);

		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");

		try {
			// 별도의 클래스를 만들지 않고 익명 클래스를 이용해보자
			Session ses = Session.getInstance(p, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					// 자신의 네이버나 지메일의 계정 정보를 넣어준다.
					return new PasswordAuthentication(mailVO.getFrom(), mailVO.getPassword());
				}
			}); // 설정 정보와 인증객체를 보내 세션 생성
			ses.setDebug(false); // 디버그모드 설정. 나중에는 false로 변경
			MimeMessage msg = new MimeMessage(ses); // 메일의 내용을 담을 객체
			Address fromAddr = new InternetAddress(mailVO.getFrom()); // 주소를 생성
			msg.setFrom(fromAddr); // 보내는 사람
			Address toAddr = new InternetAddress(mailVO.getTo());
			msg.addRecipient(Message.RecipientType.TO, toAddr); // 받는 사람
			msg.setSubject(mailVO.getSubject()); // 제목
			msg.setContent(mailVO.getContent(), "text/html;charset=UTF-8"); // 내용과 인코딩 설정
			Transport.send(msg); // 전송
			result = true;
		} catch (Exception e) {
			// 에러가 나면 이전으로 가기
			e.printStackTrace();
		}
		return result;
	}

	// 3번 예제의 내용을 메서드로 만들어 보자
	public static boolean mailSender(MailVO mailVO, String path, List<String> fileList) {
		boolean result = false;
		// SMTP 서버에 접속하기 위한 정보들
		Properties p = new Properties(); // 정보를 담을 객체

		String smtpServer = "smtp." + mailVO.getFrom().split("@")[1]; // 보내는 사람의 이메일 주소에서 도메인만 추출하여 적용
		p.put("mail.smtp.host", smtpServer);

		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");

		try {
			// 별도의 클래스를 만들지 않고 익명 클래스를 이용해보자
			Session ses = Session.getInstance(p, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					// 자신의 네이버나 지메일의 계정 정보를 넣어준다.
					return new PasswordAuthentication(mailVO.getFrom(), mailVO.getPassword());
				}
			}); // 설정 정보와 인증객체를 보내 세션 생성
			ses.setDebug(false); // 디버그모드 설정. 나중에는 false로 변경
			// =======================================================================================
			MimeMessage msg = new MimeMessage(ses); // 메일의 내용을 담을 객체
			Address fromAddr = new InternetAddress(mailVO.getFrom()); // 주소를 생성
			msg.setFrom(fromAddr); // 보내는 사람
			Address toAddr = new InternetAddress(mailVO.getTo());
			msg.addRecipient(Message.RecipientType.TO, toAddr); // 받는 사람
			msg.setSubject(mailVO.getSubject()); // 제목
			// =======================================================================================
			// 1. 파일을 첨부할 객체
			Multipart multipart = new MimeMultipart();
			// 2. 메세지를 저장할 객체
			BodyPart messageBodyPart = new MimeBodyPart();
			// 3. 몸체 내용을 지정
			messageBodyPart.setContent(mailVO.getContent(), "text/html;charset=UTF-8"); // html 전송
			// =======================================================================================
			// 리스트로 넘어온 파일을 첨부한다.
			for (String fileName : fileList) {
				BodyPart filePart = new MimeBodyPart();
				File file = new File(path + "/" + fileName);
				FileDataSource fds = new FileDataSource(file);
				filePart.setDataHandler(new DataHandler(fds));
				filePart.setFileName(fds.getName());
				// 6. 파일을 첨부할 객체에 추가
				multipart.addBodyPart(filePart);
			}
			// 만들어진 Multipart객체를 보낼 메일에 지정한다
			msg.setContent(multipart);
			// =======================================================================================
			Transport.send(msg); // 전송
			result = true;
		} catch (Exception e) {
			// 에러가 나면 이전으로 가기
			e.printStackTrace();
		}
		return result;
	}

	// 4번 예제의 내용을 메서드로 만들어 보자(COS 사용)
	public static boolean mailSender(ServletContext application, HttpServletRequest request) {
		boolean result = false;
		try {
			// 넘어온 데이터 받기
			String upload_path = application.getRealPath("/upload/");
			int maxSize = 10 * 1024 * 1024;

			// 이순간 모드 업로드가 이루어진다.
			MultipartRequest multi = new MultipartRequest(request, upload_path, maxSize, "utf-8",
					new DefaultFileRenamePolicy());
			// 폼필드의 내용을 읽자.
			String from = multi.getParameter("from");
			String password = multi.getParameter("password");
			String to = multi.getParameter("to");
			String subject = multi.getParameter("subject");
			String content = multi.getParameter("content");

			// SMTP 서버에 접속하기 위한 정보들
			Properties p = new Properties(); // 정보를 담을 객체

			String smtpServer = "smtp." + from.split("@")[1]; // 보내는 사람의 이메일 주소에서 도메인만 추출하여 적용
			p.put("mail.smtp.host", smtpServer);

			p.put("mail.smtp.port", "465");
			p.put("mail.smtp.starttls.enable", "true");
			p.put("mail.smtp.auth", "true");
			p.put("mail.smtp.debug", "true");
			p.put("mail.smtp.socketFactory.port", "465");
			p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			p.put("mail.smtp.socketFactory.fallback", "false");

			// 별도의 클래스를 만들지 않고 익명 클래스를 이용해보자
			Session ses = Session.getInstance(p, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
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
			// ========================================================================================
			// 1. 파일을 첨부할 객체
			Multipart multipart = new MimeMultipart();
			// 2. 메세지를 저장할 객체
			BodyPart messageBodyPart = new MimeBodyPart();
			// 3. 몸체 내용을 지정
			messageBodyPart.setContent(content, "text/html;charset=UTF-8"); // html 전송
			// messageBodyPart.setText(content); // 텍스트 전송
			// 4. 파일을 첨부할 객체에 추가
			multipart.addBodyPart(messageBodyPart);

			// ***********************************************************************************
			// 넘어온 파일 첨부
			@SuppressWarnings("unchecked")
			Enumeration<String> files = multi.getFileNames(); // 필드명 받기
			while (files.hasMoreElements()) {
				String fieldName = files.nextElement();
				File file = multi.getFile(fieldName);
				if (file != null) {
					BodyPart filePart = new MimeBodyPart();
					FileDataSource fds = new FileDataSource(file);
					filePart.setDataHandler(new DataHandler(fds));
					// 한글 파일이름이 깨지지 않게 한다.
					filePart.setFileName(MimeUtility.encodeText(multi.getOriginalFileName(fieldName)));
					// 파일을 첨부할 객체에 추가
					multipart.addBodyPart(filePart);
				}
			}
			// ***********************************************************************************
			// 만들어진 Multipart객체를 보낼 메일에 지정한다
			msg.setContent(multipart);
			// 전송을 한다.
			Transport.send(msg);

			result = true;
		} catch (Exception e) {
			// 에러가 나면 이전으로 가기
			e.printStackTrace();
		}
		return result;
	}

	// 4번 예제의 내용을 메서드로 만들어 보자(COMMONS-FILEUPLOAD사용)
	public static boolean mailSenderCommons(ServletContext application, HttpServletRequest request) {
		boolean result = false;
		try{
			String from="", password="", to="", subject="", content="";
			List<BodyPart> fileList = new ArrayList<BodyPart>();
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if(isMultipart){
				DiskFileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				List<FileItem> items = upload.parseRequest(request);
				for(FileItem item : items){
					if(item.isFormField()){
						// 일반 필드라면
						String name = item.getFieldName(); 			// 이름읽기
					    String value = item.getString("UTF-8");   	// 내용읽기
					    switch (name) {
						case "from": from = value; break;
						case "password": password = value; break;
						case "to": to = value; break;
						case "subject": subject = value; break;
						case "content": content = value; break;
						}
					}else{
						// 파일이 넘어왔다면
					    String fileName = item.getName();       // 파일명 
					    long sizeInBytes = item.getSize(); // 파일의 크기
					    if(sizeInBytes>0){
						    String oFileName = "";
						    if(fileName.lastIndexOf(File.separator)!=-1){ // 파일이름에 \나/가 있다면 뒤의 파일명만 잘라낸다.
						    	oFileName = fileName.substring(fileName.lastIndexOf(File.separator)+1);
						    }
						    String path = application.getRealPath("/upload/"); 
						    String sFileName = UUID.randomUUID().toString(); // 유일한 문자열을 만들어준다.
						    File file = new File(path + File.separator + sFileName); // 저장할 위치에 파일객체 생성
						    item.write(file); // 파일을 저장
						    
							BodyPart filePart = new MimeBodyPart();
							FileDataSource fds = new FileDataSource(file);
							filePart.setDataHandler(new DataHandler(fds));
							// 한글 파일이름이 깨지지 않게 한다.
							filePart.setFileName(MimeUtility.encodeText(oFileName));
							fileList.add(filePart);
					    }
					}
				}
			}
				
			// SMTP 서버에 접속하기 위한 정보들
			Properties p = new Properties(); // 정보를 담을 객체
			String smtpServer = "smtp." + from.split("@")[1]; // 보내는 사람의 이메일 주소에서 도메인만 추출하여 적용
			p.put("mail.smtp.host", smtpServer);
			p.put("mail.smtp.port", "465");
			p.put("mail.smtp.starttls.enable", "true");
			p.put("mail.smtp.auth", "true");
			p.put("mail.smtp.debug", "true");
			p.put("mail.smtp.socketFactory.port", "465");
			p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			p.put("mail.smtp.socketFactory.fallback", "false");
		
			// 별도의 클래스를 만들지 않고 익명 클래스를 이용해보자
			final String fromFinal = from; 
			final String passwordFinal = password; 
			Session ses = Session.getInstance(p,new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(fromFinal, passwordFinal);
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
			
			// ***********************************************************************************
			// 넘어온 파일 첨부
			for(BodyPart filePart : fileList) multipart.addBodyPart(filePart);
			// ***********************************************************************************
	 		// 만들어진 Multipart객체를 보낼 메일에 지정한다
			msg.setContent(multipart);
			// 전송을 한다.
			Transport.send(msg); 	
			
			result = true;
		}catch(Exception e){
			// 에러가 나면 이전으로 가기
			e.printStackTrace();
		}		
		return result;
	}
}
