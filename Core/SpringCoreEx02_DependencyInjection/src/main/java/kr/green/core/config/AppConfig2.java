package kr.green.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.green.core.vo.ActiveMQMessaging;
import kr.green.core.vo.Communication;
import kr.green.core.vo.Communication2;
import kr.green.core.vo.EmailMessaging;
import kr.green.core.vo.Encryption;
import kr.green.core.vo.MD5Encryption;
import kr.green.core.vo.MMSMessaging;
import kr.green.core.vo.Messaging;
import kr.green.core.vo.RSAEncryption;
import kr.green.core.vo.SMSMessaging;

@Configuration
public class AppConfig2 {

	@Bean("activeMQMessaging")
	public Messaging activeMQMessage() {
		return new ActiveMQMessaging();
	}
	@Bean("smsMessaging")
	public Messaging SMSMessage() {
		return new SMSMessaging();
	}
	@Bean("mmsMessaging")
	public Messaging MMSMessage() {
		return new MMSMessaging();
	}

	@Bean("communication1")
	public Communication communication1() {
		Messaging messaging = activeMQMessage();
		// 생성자를 통한 주입
		Communication communication = new Communication(messaging);
		return communication;
	}
	@Bean("communication2")
	public Communication communication2() {
		// 생성자를 통한 주입
		Communication communication = new Communication(SMSMessage());
		return communication;
	}
	@Bean("communication3")
	public Communication communication3() {
		// 생성자를 통한 주입
		return new Communication(MMSMessage());
	}
	@Bean("communication4")
	public Communication communication4() {
		// 생성자를 통한 주입
		return new Communication(new EmailMessaging());
	}
	
	@Bean("communication5")
	public Communication2 communication5() {
		// 생성자를 통한 주입
		return new Communication2(new MD5Encryption());
	}
	
	@Bean("communication6")
	public Communication2 communication6() {
		// 생성자를 통한 주입
		Encryption encryption = new RSAEncryption();
		return new Communication2(encryption);
	}
}
