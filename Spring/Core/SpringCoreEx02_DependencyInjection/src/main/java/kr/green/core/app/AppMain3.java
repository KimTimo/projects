package kr.green.core.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.core.vo.Communication;
import kr.green.core.vo.Communication2;

public class AppMain3 {
	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("application2.xml");

		Communication communication = (Communication) context.getBean("communication1");
		communication.communicate();
		communication = (Communication) context.getBean("communication2");
		communication.communicate();
		communication = (Communication) context.getBean("communication3");
		communication.communicate();
		communication = (Communication) context.getBean("communication4");
		communication.communicate();
		
		Communication2 communication2 = context.getBean("communication5", Communication2.class);
		communication2.encryption();
		
		communication2 = context.getBean("communication6", Communication2.class);
		communication2.encryption();
		
		context.close();
	}
}
