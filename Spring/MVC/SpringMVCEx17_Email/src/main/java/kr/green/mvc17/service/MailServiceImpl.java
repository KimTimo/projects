package kr.green.mvc17.service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import kr.green.mvc17.vo.MailVO;

@Service("mailService")
public class MailServiceImpl implements MailService{

	@Autowired
	JavaMailSender javaMailSender;

	@Override
	public void sendEmail(final String emailAddress, final String subject, final String body) {
		javaMailSender.send(new MimeMessagePreparator() {
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setFrom("eoguszan@gmail.com");
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(emailAddress));
				mimeMessage.setSubject(subject);
				mimeMessage.setText(body);
			}
		});		
	}

	@Override
	public void sendEmail(MailVO mailVO) {
		javaMailSender.send(new MimeMessagePreparator() {
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setFrom(mailVO.getFromEmailAddress());
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(mailVO.getToEmailAddress()));
				mimeMessage.setSubject(mailVO.getSubject());
				mimeMessage.setText(mailVO.getBody());
			}
		});				
	}
}
