package kr.green.core.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import kr.green.core.config.AppConfig;
import kr.green.core.vo.Communication;

public class AppMain2 {
	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);

		Communication communication = (Communication) context.getBean("communication1");
		communication.communicate();
		communication = (Communication) context.getBean("communication2");
		communication.communicate();
		communication = (Communication) context.getBean("communication3");
		communication.communicate();
		communication = (Communication) context.getBean("communication4");
		communication.communicate();
		context.close();
	}
}
