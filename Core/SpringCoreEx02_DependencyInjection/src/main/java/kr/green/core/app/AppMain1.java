package kr.green.core.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.core.vo.Communication;

public class AppMain1 {
	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("application.xml");
		//Communication communication = context.getBean("communication", Communication.class);
		Communication communication = (Communication) context.getBean("communication1");
		communication.communicate();
		communication = (Communication) context.getBean("communication2");
		communication.communicate();
		communication = (Communication) context.getBean("communication3");
		communication.communicate();
		communication = (Communication) context.getBean("communication4");
		communication.communicate();
		context.close();
		
		/*
		// 순수 자바를 이용
		Messaging messaging = new ActiveMQMessaging();
		Communication communication2 = new Communication();
		communication2.setMessaging(messaging); // setter를 통한 주입
		communication2.communicate();
		*/
	}
}
