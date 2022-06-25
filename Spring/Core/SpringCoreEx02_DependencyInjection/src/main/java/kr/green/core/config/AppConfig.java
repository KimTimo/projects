package kr.green.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.green.core.vo.ActiveMQMessaging;
import kr.green.core.vo.Communication;
import kr.green.core.vo.EmailMessaging;
import kr.green.core.vo.MMSMessaging;
import kr.green.core.vo.Messaging;
import kr.green.core.vo.SMSMessaging;

@Configuration
public class AppConfig {

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
		Communication communication = new Communication();
		communication.setMessaging(messaging);
		return communication;
	}
	@Bean("communication2")
	public Communication communication2() {
		Communication communication = new Communication();
		communication.setMessaging(SMSMessage());
		return communication;
	}
	@Bean("communication3")
	public Communication communication3() {
		Communication communication = new Communication();
		communication.setMessaging(MMSMessage());
		return communication;
	}
	@Bean("communication4")
	public Communication communication4() {
		Communication communication = new Communication();
		communication.setMessaging(new EmailMessaging());
		return communication;
	}
	
}
