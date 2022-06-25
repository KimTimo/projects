package kr.green.searches.service;

import java.net.InetAddress;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import kr.green.searches.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("mailService")
public class MailService {

	@Autowired
	JavaMailSender mailSender;
	
	public void sendMail(String from, String to, String subject, String body) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,false,"UTF-8");
				helper.setFrom("eogsu8548@naver.com");
				helper.setTo(to);
				helper.setSubject(subject);
				helper.setText(body);
			}
		};
		try {
			mailSender.send(preparator);
			log.info("메일보내기 성공!!!!");
		}catch (Exception e) {
			log.info("메일보내기 실패!!!!");
			e.printStackTrace();
		}
	}
	
	public void sendMail(MemberVO memberVO) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,false,"UTF-8");
				helper.setFrom("eogsu8548@naver.com");
				helper.setTo(memberVO.getEmail());
				helper.setSubject(memberVO.getUsername() + "님 회원가입을 축하합니다.");
				StringBuffer sb = new StringBuffer();
				sb.append(memberVO.getUsername() + "님 회원가입을 축하합니다.<br>");
				sb.append("<a href='http://" + InetAddress.getLocalHost().getHostAddress() + ":8080/searches/authOk");
				sb.append("?userid=" + memberVO.getUserid() + "&uuid=" + memberVO.getUuid() + "'>인증</a><br>");
				helper.setText(sb.toString(),true); // 두번째 인수가 html사용여부
			}
		};
		try {
			mailSender.send(preparator);
			log.info("메일보내기 성공!!!!");
		}catch (Exception e) {
			log.info("메일보내기 실패!!!!");
			e.printStackTrace();
		}
	}
}
